/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Transaction;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Transaction Bean Test
 * 
 * @author Colby Rabideau
 */
public class TransactionBeanTest {

    /**
     * Transaction
     */
    public static Transaction transaction;

    /**
     * Set Up Class
     *
     * @return void
     */
    @BeforeClass
    public static void setUpClass() {
        transaction = new Transaction();
    }

    /**
     * [test] Subline Id
     *
     * @return void
     */
    @Test
    public void testSublineId() {
        Integer test = 5;
        transaction.setSublineId(test);
        assertEquals(test, transaction.getSublineId());
    }

    /**
     * [test] Amount
     *
     * @return void
     */
    @Test
    public void testAmount() {
        Double test = 5.00;
        transaction.setAmount(test);
        assertEquals(test, transaction.getAmount());
    }

    /**
     * [test] Date
     *
     * @return void
     */
    @Test
    public void testDate() {
        Date test = new Date();
        transaction.setDate(test);
        assertEquals(test, transaction.getDate());
    }

}
