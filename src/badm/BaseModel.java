/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import org.workplicity.entry.Entry;

/**
 * BaseModel
 *	
 * Gloabl model methods
 * 
 * @author Colby Rabideau
 */
abstract class BaseModel extends Entry {
	
	/**
	 * Repository Name
	 *
	 * name of the model's Mongo collection
	 */
	protected static String repositoryName = "";
	
	/**
	 * Get Repository Name
	 *	
	 * returns repo name based on the class, if repositoryName is not set
	 * 
	 * @return String
	 */
	public String getRepositoryName() {
		
		String name;
		
		if(repositoryName == ""){
			String full =this.getClass().getName();
			int mid = full.lastIndexOf ('.') + 1;
			name = full.substring(mid) + "s";
		} else {
			name = repositoryName;
		}

		return name;
	}
	
}
