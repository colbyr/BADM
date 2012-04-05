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
import org.workplicity.util.Helper;

/**
 * Note Model Test 
 *
 * @author Colby Rabideau
 */
public class NoteTest {

	public Note note;

	@BeforeClass
	public static void setUpClass() throws Exception {
		if (!Accounts.login()) {
			fail("Could not login.");
		}
	}
	
	/**
	 * Set Up
	 *
	 * @return void
	 */
	@Before
	public void setUp() {
		note = new Note();
		note.setAuthor("Colby");
		note.setName("Test");
		note.setBudgetId(1);
		note.commit();
	}
	
	/**
	 * Tear Down
	 *
	 * @return void
	 */
	@After
	public void tearDown() {
		note.delete();
	}

	/**
	 * [test] Create Note
	 *
	 * @return void
	 */
	@Test
	public void create() {
		assertTrue(note.getId() > -1);
	}
	
	/**
	 * [test] Set & Save Attributes
	 *
	 * @return void
	 */
	@Test
	public void testSetAndSaveAttributes() {
		assertEquals("Colby", note.getAuthor());
		assertEquals("Test", note.getName());
		assertEquals(new Integer(1), note.getBudgetId());
	}
	
	/**
	 * [test] Update Attributes
	 *
	 * @return void
	 */
	@Test
	public void update() {
		note.setAuthor("Tom");
		assertTrue(note.commit());
		
		System.out.println("fetching note with id: " + note.getId());
		
		Note new_note = Note.find(note.getId());
		assertNotNull(new_note);
		assertEquals(note.getAuthor(), new_note.getAuthor());
	}
	
	/**
	 * [test] Delete Note
	 *
	 * @return void
	 */
	@Test
	public void delete() {
		assertTrue(note.delete());
	}

}
