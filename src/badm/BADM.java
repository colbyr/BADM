/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import java.util.Properties;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author Trescenzi
 */
public class BADM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
	if(!Accounts.login()) {
		throw new Exception("Could not set up accounts...");
	}
    }
}
