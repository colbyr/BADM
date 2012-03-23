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
	
	// accounts thing...
	Accounts acc = new Accounts();
	
	// properties
	Properties props = new Properties();
	
	// set properties
	props.setProperty("system.name", "badm");
	props.setProperty("system.user.0", "admin gaze11e User");
	
	// init accounts
	acc.init(props);
	    
	NetTask.setStoreName("badm");
	NetTask.setUrlBase("http://localhost:8080/netprevayle/task");
	
	System.out.println("Store: " + NetTask.getStoreName());
	System.out.println("URL: " + NetTask.getUrlBase());
	
	WorkletContext context = WorkletContext.getInstance();
	
	System.out.println(context.toString());
	
        Helper.login("admin", "gaze11e", context);
	
	Budget b = new Budget();
	System.out.println(b.getRepositoryName());
    }
}
