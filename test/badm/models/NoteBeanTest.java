/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Note;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Note Bean Test
 * 
 * @author Colby Rabideau
 */
public class NoteBeanTest {
	
    /**
     * Note  
     */
    public static Note note;

    /**
     * Set Up Class
     *
     * @return void
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        note = new Note();
    }

    /**
     * [test] Text
     *
     * @return void
     */
    @Test
    public void testText() {
        String test = "This is a test";
        note.setText(test);
        assertEquals(test, note.getText());
    }

    /**
     * [test] Date
     *
     * @return void
     */
    @Test
    public void testDate() {
        Date date = new Date();
        note.setDate(date);
        assertEquals(date, note.getDate());
    }

    /**
     * [test] Author
     *
     * @return void
     */
    @Test
    public void testAuthor() {
        String test = "Colby";
        note.setAuthor(test);
        assertEquals(test, note.getAuthor());
    }

    /**
     * [test] Budget Id
     *
     * @return void
     */
    @Test
    public void testBudgetId() {
        Integer id = 1;
        note.setBudgetId(id);
        assertEquals(id, note.getBudgetId());
    }    

}
