/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.BridgeConstants.Side;
import cc.test.bridge.BudgetInterface;
import cc.test.bridge.LineInterface;
import cc.test.bridge.NoteInterface;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.*;
import org.workplicity.entry.Entry;
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
	
	public BudgetTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void verify() {
		try {
                    try { 
                            // Set the store name since the default may be be not ours
                            NetTask.setStoreName(STORE_NAME);
                            NetTask.setUrlBase("http://localhost:8080/netprevayle/task");

                            // Attempt the login
                            if(!Helper.login("admin", "gazelle", context))
                                    fail("login failed");

                    } catch (Exception e) {
                            fail("failed with exception: " + e);
                    }
                    System.out.println("sex");
                    System.out.println(Helper.getTicket(context));
                    BudgetInterface budget = BridgeHelper.getBudgetFactory().create(); 
                    String repos = budget.getRepositoryName();
                    System.out.println(budget.commit());
                    System.out.println(Helper.getTicket(context));
                    System.out.println("sexy");
                    // Retrieve the budget
                    budget.setDescription("My Budget");
                    budget.commit();
                    BudgetInterface budgetF = 
                            (Budget) Helper.fetch(repos, -1, WorkletContext.getInstance());

                    if(budgetF == null)
                            fail("budget not found");

                    System.out.println("budget description = '"+budgetF.getDescription()+"'");

                    // Verify that the name is what we expect
                    assert(budgetF.getDescription().equals("My Budget"));

		} catch (Exception e) {
			fail("failed with exception: " + e);
		}
	}
	
	/**
	 * Test of getDescription method, of class Budget.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		Budget instance = new Budget();
		String expResult = "";
		String result = instance.getDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setDescription method, of class Budget.
	 */
	@Test
	public void testSetDescription() {
		System.out.println("setDescription");
		String d = "";
		Budget instance = new Budget();
		instance.setDescription(d);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fetchLines method, of class Budget.
	 */
	@Test
	public void testFetchLines() {
		System.out.println("fetchLines");
		Side side = null;
		Budget instance = new Budget();
		ArrayList expResult = null;
		ArrayList result = instance.fetchLines(side);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fetchNotes method, of class Budget.
	 */
	@Test
	public void testFetchNotes() {
		System.out.println("fetchNotes");
		Budget instance = new Budget();
		ArrayList expResult = null;
		ArrayList result = instance.fetchNotes();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createLine method, of class Budget.
	 */
	@Test
	public void testCreateLine() {
		System.out.println("createLine");
		Budget instance = new Budget();
		LineInterface expResult = null;
		LineInterface result = instance.createLine();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createNote method, of class Budget.
	 */
	@Test
	public void testCreateNote() {
		System.out.println("createNote");
		Budget instance = new Budget();
		NoteInterface expResult = null;
		NoteInterface result = instance.createNote();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of add method, of class Budget.
	 */
	@Test
	public void testAdd_NoteInterface() {
		System.out.println("add");
		NoteInterface ni = null;
		Budget instance = new Budget();
		instance.add(ni);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of delete method, of class Budget.
	 */
	@Test
	public void testDelete_NoteInterface() {
		System.out.println("delete");
		NoteInterface ni = null;
		Budget instance = new Budget();
		instance.delete(ni);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of add method, of class Budget.
	 */
	@Test
	public void testAdd_LineInterface() {
		System.out.println("add");
		LineInterface li = null;
		Budget instance = new Budget();
		instance.add(li);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of delete method, of class Budget.
	 */
	@Test
	public void testDelete_LineInterface() {
		System.out.println("delete");
		LineInterface li = null;
		Budget instance = new Budget();
		instance.delete(li);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of update method, of class Budget.
	 */
	@Test
	public void testUpdate_LineInterface() {
		System.out.println("update");
		LineInterface li = null;
		Budget instance = new Budget();
		instance.update(li);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of update method, of class Budget.
	 */
	@Test
	public void testUpdate_NoteInterface() {
		System.out.println("update");
		NoteInterface ni = null;
		Budget instance = new Budget();
		instance.update(ni);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getId method, of class Budget.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Budget instance = new Budget();
		Integer expResult = null;
		Integer result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setName method, of class Budget.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String string = "";
		Budget instance = new Budget();
		instance.setName(string);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class Budget.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Budget instance = new Budget();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUpdateDate method, of class Budget.
	 */
	@Test
	public void testGetUpdateDate() {
		System.out.println("getUpdateDate");
		Budget instance = new Budget();
		WorkDate expResult = null;
		WorkDate result = instance.getUpdateDate();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of commit method, of class Budget.
	 */
	@Test
	public void testCommit() {
		System.out.println("commit");
		Budget instance = new Budget();
		Boolean expResult = null;
		Boolean result = instance.commit();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRepositoryName method, of class Budget.
	 */
	@Test
	public void testGetRepositoryName() {
		System.out.println("getRepositoryName");
		Budget instance = new Budget();
		String expResult = "";
		String result = instance.getRepositoryName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
