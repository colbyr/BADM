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
        
        Transaction t = new Transaction();
        Transaction p = new Transaction();
        Transaction u = new Transaction();
        t.setName("Transaction");
        System.out.println(t.commit());
        t.commit();
        p.setName("Transaction");
        t.commit();
        u.setName("Transaction");
        u.commit();
        Integer id = t.getId();
        System.out.println(Transaction.find(id).getName().equals(t.getName()));
        
    }
}
