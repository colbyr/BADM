/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.*;
import cc.test.bridge.BridgeConstants;
import cc.test.bridge.TransactionInterface;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author trescenzi
 */
public class FullTest {
    
    static Budget badassbudget;
    
    public FullTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        badassbudget = new Budget();
        badassbudget.setDescription("I'm gona kick your ass");
        badassbudget.commit();
        
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void lines() {
        Line mrliney = new Line();
        mrliney.setGoal(1000.0);
        badassbudget.commit();
        badassbudget.add(mrliney);
        badassbudget.commit();
        Integer id = badassbudget.getId();
        Budget budget = Budget.find(id);
        Line line = (Line) budget.fetchLines(BridgeConstants.Side.INCOME).get(0);
        System.out.println(line.getGoal());
        System.out.println(mrliney.getGoal());
        assert(line.getGoal().equals(mrliney.getGoal()));
     }
     
     @Test
     public void sublines() {
        Line mrliney = new Line();
        mrliney.setGoal(1000.0);
        badassbudget.commit();
        badassbudget.add(mrliney);
        badassbudget.commit();
        Subline sub = new Subline();
        sub.setGoal(200.0);
        sub.commit();
        mrliney.add(sub);
        mrliney.commit();
        Integer id = badassbudget.getId();
        Budget budget = Budget.find(id);
        Subline subline = (Subline) budget.fetchLines(BridgeConstants.Side.INCOME).get(0)
                .fetchSublines().get(0);
        System.out.println(subline.getGoal());
        System.out.println(sub.getGoal());
        assert(subline.getGoal().equals(sub.getGoal()));
     }
     
     @Test
     public void transactions() {
        Line mrliney = new Line();
        mrliney.setGoal(1000.0);
        badassbudget.commit();
        badassbudget.add(mrliney);
        badassbudget.commit();
        Subline sub = new Subline();
        sub.setGoal(200.0);
        sub.commit();
        mrliney.add(sub);
        mrliney.commit();
        Transaction tran = new Transaction();
        tran.setAmount(150.0);
        sub.commit();
        System.out.println(tran.getId());
        sub.add(tran);
        sub.commit();
        Integer id = badassbudget.getId();
        Budget budget = Budget.find(id);
        Transaction transaction =(Transaction) budget.fetchLines(BridgeConstants.Side.INCOME).get(0)
                .fetchSublines().get(0).fetchTransactions().get(0);
        System.out.println(transaction.getAmount());
        System.out.println(tran.getAmount());
        assert(transaction.getAmount().equals(tran.getAmount()));
     }
     
     @Test
     public void autoUpdate() {
        Line mrliney = new Line();
        mrliney.setGoal(1000.0);
        badassbudget.commit();
        badassbudget.add(mrliney);
        badassbudget.commit();
        Subline sub = new Subline();
        sub.setGoal(200.0);
        sub.commit();
        mrliney.add(sub);
        mrliney.commit();
        Transaction tran = new Transaction();
        sub.commit();
        sub.add(tran);
        sub.commit();
        tran.setAmount(150.0);
        sub.commit();
        Audit audit = new Audit();
	audit.setValue(150.0);
        audit.setUpdated(new ArrayList<Integer>());
        tran.update(audit);
        tran.commit();
        Integer id = badassbudget.getId();
        Budget budget = Budget.find(id);
        assertNotNull(budget.getTotal());
     }
}
