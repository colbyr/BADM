/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Budget;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author idontknow5691
 */
public class BudgetBeanTest {
	
    /**
     * Budget
     */
    public static Budget budget;

    /**
     * Set Up Class
     *
     * @return void
     */
    @BeforeClass
    public static void setUpClass() {
        budget = new Budget();
    }

    /**
     * [test] Description
     *
     * @return void
     */
    @Test
    public void testDescription() {
        String test = "this is a description";
        budget.setDescription(test);
        assertEquals(test, budget.getDescription());
    }

    /**
     * [test] Total
     *
     * @return void
     */
    @Test
    public void testTotal() {
        Double test = 100.00;
        budget.setTotal(test);
        assertEquals(test, budget.getTotal());
    }

}
