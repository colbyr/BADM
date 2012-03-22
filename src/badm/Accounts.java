//Copyright (C) 2009-2012 Ron Coleman. Contact: ronncoleman at ggmail.com
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License
//as published by the Free Software Foundation; either
//version 3 of the License, or (at your option) any later version.
//
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this library; if not, write to the Free Software
//Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

package badm;

import java.util.Properties;
import org.workplicity.entry.User;
import org.workplicity.repos.mongo.Repository;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;

/**
 * This class implements accounts repository for Cloud Count.
 * @author Ron Coleman
 */
public class Accounts extends Repository {
	
    public final static String TITLE = "Accounts";
    public final static String KEY_USER_BASE = "system.user.";
    public final static String KEY_PASSWORD_BASE = "accounts.password.";
    public final static int ACCOUNT_ADMIN_ID = 0;
    public final static int ACCOUNT_SYSTEM_ID = 1;

    /**
     * Initializes the repository.
     * @param props Properties
     * @throws Exception
     */
    @Override
    public void init(Properties props) throws Exception {
        // Get the db (or store or system) name
        String dbName = props.getProperty("system.name");
	
	
	
        System.out.println("ACCOUNTS init invoked for db = '" + dbName+"'");

        // If the accounts collection is empty, add the default accounts
        boolean populated = MongoHelper.isPopulated(dbName, NetTask.REPOS_ACCOUNTS);
        System.out.println("collection '"+NetTask.REPOS_ACCOUNTS+"' populated ="+populated);

        if(populated)
            return;

        // Create the default accounts from the properties
        System.out.println("populating collection '"+ NetTask.REPOS_ACCOUNTS+"'");
        int i = 0;

        while (true) {
                String key = KEY_USER_BASE + i;

                String value = props.getProperty(key);

                System.out.println("property key "+key+" has value = "+value);

                if (value == null)
                    break;

                // Parse the value as: logname password class
                // Note: class must be a subclass of User
                String[] values = value.split(" ");

                String name = values[0];

                String passwd = values[1];

                String className = values[2];

                System.out.println("name="+name+" passwd="+passwd+" className="+className);

                //Class aclass = Class.forName(className);

                // Create the user
                User user = new User(); //(User) aclass.newInstance();
                user.setLogname(name);
                user.setPassword(passwd);

                // Insert the user into the accounts repository
                MongoHelper.insert(user, dbName, TITLE);

                System.out.println("user id = "+user.getId());
                
                i++;
        }
        
        System.out.println("init done!");
    }

}
