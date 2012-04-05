/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Subline;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Subline Bean Test
 *
 * @author Colby Rabideau
 */
public class SublineBeanTest {

    /**
     * Subline
     */
    public static Subline subline;

    /**
     * Set Up Class
     *
     * @return void
     */
    @BeforeClass
    public static void setUpClass() {
        subline = new Subline();
    }
	
    /**
     * [test] Subline Number
     *
     * @return void
     */
    @Test
    public void testSubNumber() {
        Integer test = 5;
        subline.setSubNumber(test);
        assertEquals(test, subline.getSubNumber());
    }

    /**
     * [test] Line Id
     *
     * @return void
     */
    @Test
    public void testLineId() {
        Integer test = 50;
        subline.setLineId(test);
        assertEquals(test, subline.getLineId());
    }

}
