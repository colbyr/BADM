/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Accounts;
import badm.Audit;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author trescenzi
 */
public class AuditTest {
    Audit audit;
    public AuditTest() {
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
        audit = new Audit();
        audit.setDescription("I'm an audit");
        audit.setValue(4000.0);
        audit.commit();
    }
    
    @Test
    public void create(){
        assert(audit.getId() > -1);
    }
    
    @Test
    public void Read(){
        Audit readAudit = (Audit) Audit.find(audit.getId());
        assert(readAudit.getDescription().equals("I'm an audit"));
    }
    
    @Test
    public void Update(){
        audit.setValue(6000.0);
        audit.commit();
        Audit readAudit = (Audit) Audit.find(audit.getId());
        assert(readAudit.getValue().equals(6000.0));
    }
    
    @Test
    public void Delete(){
        audit.delete();
        Audit readAudit = (Audit) Audit.find(audit.getId());
        assertEquals(null,readAudit);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
