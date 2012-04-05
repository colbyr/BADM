/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Accounts;
import badm.Budget;
import badm.BudgetFactory;
import badm.Line;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author trescenzi
 */
public class LineTest {
    
    public LineTest() {
    }
    
    Line line;
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
        line = new Line();
        line.commit();
        line.setName("Line");
        line.setBudgetId(1);
        line.commit();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void create(){
            System.out.println("Create");
            line.commit();
            assert(line.getId() > -1);
    }
    
    @Test
    public void read(){
            System.out.println("Read");
            Line readLine = Line.find(line.getId());
            assert(readLine.getName().equals(line.getName()));
    }
    
    @Test
    public void Update(){
            System.out.println("Update");
            line.setName("Updated");
            line.commit();
            Line readLine = Line.find(line.getId());
            assertEquals(readLine.getName(), "Updated");
    }
    
    @Test
    public void Delete(){
        System.out.println("Delete");
        Integer id = line.getId();
        line.delete();
        Line readLine = Line.find(line.getId());
        assertEquals(readLine, null);
    }

}
