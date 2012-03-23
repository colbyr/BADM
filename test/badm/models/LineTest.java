/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Accounts;
import badm.Line;
import cc.test.bridge.SublineInterface;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author idontknow5691
 */
public class LineTest {
	
	public LineTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
		if (!Accounts.login()) {
			fail("Could not login.");
		}
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

	/**
	 * Test of getTotal method, of class Line.
	 */
	@Test
	public void testTotal() {
		System.out.println("getTotal");
		Line instance = new Line();
		Integer expResult = 20;
		instance.setTotal(expResult);
		Integer result = instance.getTotal();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getNumber method, of class Line.
	 */
	@Test
	public void testNumber() {
		System.out.println("getNumber");
		Line instance = new Line();
		Integer expResult = 1;
		instance.setNumber(expResult);
		Integer result = instance.getNumber();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getBudgetId method, of class Line.
	 */
	@Test
	public void testBudgetId() {
		System.out.println("getBudgetId");
		Line instance = new Line();
		Integer expResult = 3;
		instance.setBudgetId(expResult);
		Integer result = instance.getBudgetId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of fetchSublines method, of class Line.
	 */
	@Test
	public void testFetchSublines() {
		System.out.println("fetchSublines");
		// TODO better test for fetchSublines()
	}

	/**
	 * Test of createSubline method, of class Line.
	 */
	@Test
	public void testCreateSubline() {
		System.out.println("createSubline");
		Line instance = new Line();
		SublineInterface expResult = null;
		SublineInterface result = instance.createSubline();
		assertNotNull(result);
	}

	/**
	 * Test of add method, of class Line.
	 */
	@Test
	public void testAdd() {
		System.out.println("add");
		SublineInterface si = null;
		Line instance = new Line();
		instance.add(si);
		// TODO better test for add()
	}

	/**
	 * Test of delete method, of class Line.
	 */
	@Test
	public void testDelete() {
		System.out.println("delete");
		// TODO better test for delete()
	}

	/**
	 * Test of getName method, of class Line.
	 */
	@Test
	public void testName() {
		System.out.println("getName");
		Line instance = new Line();
		String expResult = "Awesome Line";
		instance.setName(expResult);
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of update method, of class Line.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		// TODO better test for update()
	}

	/**
	 * Test of find method, of class Line.
	 */
	@Test
	public void testFind() {
		System.out.println("find");
		// TODO better test for find()
	}
}
