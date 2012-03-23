/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Accounts;
import badm.Note;
import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author idontknow5691
 */
public class NoteTest {
	
	public NoteTest() {
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
	 * Test of setBudgetId method, of class Note.
	 */
	@Test
	public void testBudgetId() {
		System.out.println("setBudgetId");
		Integer id = 10;
		Note instance = new Note();
		instance.setBudgetId(id);
		assertEquals(id, instance.getBudgetId());
	}

//	/**
//	 * Test of setText method, of class Note.
//	 */
//	@Test
//	public void testSetText() {
//		System.out.println("setText");
//		String t = "";
//		Note instance = new Note();
//		instance.setText(t);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of getAuthor method, of class Note.
//	 */
//	@Test
//	public void testGetAuthor() {
//		System.out.println("getAuthor");
//		Note instance = new Note();
//		String expResult = "";
//		String result = instance.getAuthor();
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of setAuthor method, of class Note.
//	 */
//	@Test
//	public void testSetAuthor() {
//		System.out.println("setAuthor");
//		String string = "";
//		Note instance = new Note();
//		instance.setAuthor(string);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of setName method, of class Note.
//	 */
//	@Test
//	public void testSetName() {
//		System.out.println("setName");
//		String string = "";
//		Note instance = new Note();
//		instance.setName(string);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of getName method, of class Note.
//	 */
//	@Test
//	public void testGetName() {
//		System.out.println("getName");
//		Note instance = new Note();
//		String expResult = "";
//		String result = instance.getName();
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of find method, of class Note.
//	 */
//	@Test
//	public void testFind() {
//		System.out.println("find");
//		Integer id = null;
//		Note expResult = null;
//		Note result = Note.find(id);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
}
