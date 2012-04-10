/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.*;
import cc.test.bridge.BridgeConstants.Side;
import cc.test.bridge.LineInterface;
import cc.test.bridge.NoteInterface;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.util.WorkDate;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author idontknow5691
 */
public class BudgetTest {
	
	/**
	 * The store or mongo db name
	 */
	public final static String STORE_NAME = "badm";
    
	/**
	 * The scratch pad for Helper
	 */
	private static WorkletContext context = WorkletContext.getInstance();
	
	private static Budget budget;
	
	public BudgetTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
            if (!Accounts.login()) {
                fail("Could not login.");
            }

	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		Helper.logout(Helper.whoAmI(context), context);
	}
	
	@Before
	public void setUp() {
		budget = new Budget();
                budget.setName("I'm a budget");
                budget.setTotal(4000.0);
                budget.commit();
                   
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void create(){
                System.out.println("Create");
                budget = (Budget) new BudgetFactory().create();
                budget.commit();
		assert(budget.getId() > -1);
	}
        
        @Test
        public void read(){
            System.out.println("Read");
            Budget readBudget = Budget.find(budget.getId());
            assert(budget.getName().equals(readBudget.getName()));
        }
        
        @Test
        public void Update(){
            System.out.println("Update");
            budget.setTotal(6000.0);
            budget.commit();
            Budget readBudget = Budget.find(budget.getId());
            assertEquals((Double)readBudget.getTotal(), (Double)6000.0);
        }
        
        @Test
        public void Delete(){
            Integer id = budget.getId();
            budget.delete();
            Budget readBudget = Budget.find(id);
            assertEquals(readBudget, null);
        }
        
        @Test
        public void All(){
            ArrayList<Budget> all = budget.all();
            assert(all.size() > 0);
            System.out.println("Size:"+all.size());
            for(int i=0; i<all.size(); i+=1){
                System.out.println(all.get(i).getId());
            }
        }
	
	
}
