/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import badm.Accounts;
import badm.BridgeHelper;
import badm.Budget;
import badm.Line;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.*;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author idontknow5691
 */
public class Test3 {
	
	private static WorkletContext context = WorkletContext.getInstance();
	private static Budget budget;
	private static Integer id;

	
	public Test3() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		Helper.logout(Helper.whoAmI(context), context);
	}
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void login(){
		Accounts.login();
	}
	
	@Test
	public void createBudget(){
		try{
		budget = (Budget) BridgeHelper.getBudgetFactory().create();
		
		budget.setDescription("My Budget");
		}catch(Exception e){
			fail("cannot create budget" + e);
		}
	}
	
	@Test
	public void syncBudget(){
		try{
			budget.setDescription("I'M A BUDGET!!!!!!!!");
			budget.commit();
		}catch(Exception e){
			fail("cannot sync budget" + e);
		}
	}
	
	@Test
	public void queryBudget(){
		try{
			budget.setDescription("I'M A BUDGET!!!!!!!!");
			budget.setTotal(1337.0);
			budget.commit();
                        id = budget.getId();
		}catch(Exception e){
			fail("cannot sync budget" + e);
		}
		try{
			Budget queriedBudget = Budget.find(id);
			assertEquals(queriedBudget.getDescription(), "I'M A BUDGET!!!!!!!!");
			System.out.println(queriedBudget.getDescription());
		}catch(Exception e){
			fail("Could not fetch the budget"+e);
		}
	}
        
        @Test
    public void createCommit(){
       Budget test = new Budget();
       test.setName("My Budget");
       test.commit();
       Integer budgetId = test.getId();
       Line line =  (Line)test.createLine();
       line.setName("sexy line");
       test.commit();
       Integer lineId = line.getId();
       System.out.println("creatcommit"+lineId);
       Budget pulledBudget = Budget.find(budgetId);
       Line pulledLine = Line.find(lineId);
       
       assertEquals(pulledBudget.getName(), "My Budget");
       assertEquals(pulledLine.getName(), "sexy line");
    }
	
}
