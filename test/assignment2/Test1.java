/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import badm.BridgeHelper;
import badm.Budget;
import org.junit.*;
import static org.junit.Assert.fail;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author idontknow5691
 */
public class Test1 {
	
	private static WorkletContext context = WorkletContext.getInstance();

	
	public Test1() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
		Helper.logout(Helper.whoAmI(context), context);
	}
	
	@Test
	public void login(){
		
		try { 
			// Set the store name since the default may be be not ours
                        NetTask.setStoreName("badm");
                        NetTask.setUrlBase("http://localhost:8080/netprevayle/task");

                        // Attempt the login
                        if(!Helper.login("admin", "gazelle", context))
				fail("login failed");

		} catch (Exception e) {
			fail("failed with exception: " + e);
		}
	}
	
	
	
}
