/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Line;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author idontknow5691
 */
public class LineBeanTest {

    /**
     * Line
     */
    public static Line line;

    /**
     * Set Up Class
     *
     * @return void
     */
    @BeforeClass
    public static void setUpClass() {
        line = new Line();
    }

    /**
     * [test] Number
     *
     * @return void
     */
    @Test
    public void testNumber() {
        Integer test = 1;
        line.setNumber(test);
        assertEquals(test, line.getNumber());
    }

    /**
     * [test] Budget Id
     *
     * @return void
     */
    @Test
    public void testBudgetId() {
        Integer test = 1;
        line.setBudgetId(test);
        assertEquals(test, line.getBudgetId());
    }

    /**
     * [test] Total
     *
     * @return void
     */
    @Test
    public void testTotal() {
        Double test = 20.00;
        line.setTotal(test);
        assertEquals(test, line.getTotal());
    }

}
