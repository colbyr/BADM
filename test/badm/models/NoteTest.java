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

	public Note note;
	
	@AfterClass
	public static void tearDownClass() throws Exception {
	}
	
	@Before
	public void setUp() {
		note = new Note();
		note.setAuthor("Colby");
		note.setName("Test");
		note.setBudgetId(1);
		note.commit();
	}
	
	@After
	public void tearDown() {
		note.delete();
	}

	@Test
	public void testCreateNote()
	{
		assertTrue(note.getId() > -1);
	}
	
	@Test
	public void testSetAndSaveAttributes()
	{
		assertEquals("Colby", note.getAuthor());
		assertEquals("Test", note.getName());
		assertEquals(new Integer(1), note.getBudgetId());
	}
	
	@Test
	public void testUpdateAttribtues()
	{
		note.setAuthor("Tom");
		assertTrue(note.commit());
		
		System.out.println("fetching note with id: " + note.getId());
		
		Note new_note = Note.find(note.getId());
		assertNotNull(new_note);
		assertEquals(note.getAuthor(), new_note.getAuthor());
	}
	
	@Test
	public void testDeleteNote()
	{
		assertTrue(note.delete());
	}
	
	@Test
	public void testFalse()
	{
		assertFalse(false);
	}
}
