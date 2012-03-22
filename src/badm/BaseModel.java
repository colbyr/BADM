/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import org.workplicity.entry.Entry;

/**
 * BaseModel
 *	some methods that are used in all models
 * @author idontknow5691
 */
abstract class BaseModel extends Entry {
	
	public static String className = "";
	
	public String getRepositoryName() {
		
		String name;
		
		if(className == ""){
			String full =this.getClass().getName();
			int mid = full.lastIndexOf ('.') + 1;
			name = full.substring(mid) + "s";
		} else {
			name = className;
		}

		return name;
	}
	
}
