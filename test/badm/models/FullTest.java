/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.*;
import cc.test.bridge.BridgeConstants;
import cc.test.bridge.TransactionInterface;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author trescenzi
 */
public class FullTest {
    
    static Budget badassbudget;
    static Line mrliney;
    static Subline sub;
    static Transaction tran;
    
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
        mrliney = new Line();
        mrliney.setGoal(1000.0);
        mrliney.setIncome(true);
        badassbudget.commit();
        badassbudget.add(mrliney);
        badassbudget.commit();
        sub = new Subline();
        sub.setGoal(200.0);
        sub.commit();
        mrliney.add(sub);
        mrliney.commit();
        tran = new Transaction();
        tran.setAmount(150.0);
        sub.commit();
        sub.add(tran);
        sub.commit();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void lines() {
        Integer id = badassbudget.getId();
        Budget budget = Budget.find(id);
        Line line = (Line) budget.fetchLines(BridgeConstants.Side.INCOME).get(0);
        assert(line.getGoal().equals(mrliney.getGoal()));
     }
     
     @Test
     public void sublines() {
        Integer id = badassbudget.getId();
        Budget budget = Budget.find(id);
        Subline subline = (Subline) budget.fetchLines(BridgeConstants.Side.INCOME).get(0)
                .fetchSublines().get(0);
        assert(subline.getGoal().equals(sub.getGoal()));
     }
     
     @Test
     public void transactions() {
        Integer id = badassbudget.getId();
        Budget budget = Budget.find(id);
        Transaction transaction =(Transaction) budget.fetchLines(BridgeConstants.Side.INCOME).get(0)
                .fetchSublines().get(0).fetchTransactions().get(0);
        assert(transaction.getAmount().equals(tran.getAmount()));
     }
     
}
