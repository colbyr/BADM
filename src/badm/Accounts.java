package badm;

import java.util.Properties;
import org.workplicity.entry.User;
import org.workplicity.repos.mongo.Repository;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;

/**
 * This class implements accounts repository for Cloud Count.
 *
 * @author Ron Coleman
 */
public class Accounts extends Repository {

	public final static String TITLE = "Accounts";
	
	public static String dbUrl = "http://localhost:8080/netprevayle/task";
	public static String dbName = "badm";
	public static String user = "admin";
	public static String password = "gaze11e";
	public static String className = "User";

	/**
	 * Initializes the repository.
	 *
	 * @param props Properties
	 * @throws Exception
	 */
	@Override
	public void init(Properties props) {

		if (populated()) {
			return;
		}
		
		System.out.println("ACCOUNTS init invoked for db = '" + dbName + "'");

		// Create the default accounts from the properties
		System.out.println("populating collection '" + NetTask.REPOS_ACCOUNTS + "'");
		int i = 0;

		System.out.println("name=" + user + " passwd=" + password + " className=" + className);

		// Create the user
		User admin = new User(); //(User) aclass.newInstance();
		admin.setLogname(user);
		admin.setPassword(password);

		// Insert the user into the accounts repository
		try {
			MongoHelper.insert(admin, dbName, TITLE);
		} catch (Exception e) {
			System.out.println("Insert failed: " + e);
		}

		System.out.println("user id = " + admin.getId());

		i++;

		System.out.println("init done!");
	}

	/**
	 * populated
	 * 
	 * determines if accounts have been populated
	 * 
	 * @return boolean
	 */
	public boolean populated() {
		// If the accounts collection is empty, add the default accounts
		try {
			return MongoHelper.isPopulated(dbName, NetTask.REPOS_ACCOUNTS);
		} catch (Exception e) {
			System.out.println("Populated check failed: " + e);
			return false;
		}
	}

	/**
	 * login
	 * 
	 * attempts to login to netprevayle, and initialize on failure
	 * 
	 * @return boolean
	 */
	public static boolean login() {
		Accounts accounts = new Accounts();
		try {
			// Set the store name since the default may be be not ours
			NetTask.setStoreName(dbName);
			NetTask.setUrlBase(dbUrl);

			// Attempt the login
			if (Helper.login(user, password, BaseModel.context())) {
				return true;
			} else {
				accounts.init(null);
				return Helper.login(user, password, BaseModel.context());
			}

		} catch (Exception e) {
			System.out.println("Login failed: " + e);
			accounts.init(null);
			return Helper.login(user, password, BaseModel.context());
		}
	}
}
