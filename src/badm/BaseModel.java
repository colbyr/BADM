/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.workplicity.entry.Entry;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

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
	
	@JsonIgnore
	protected String repositoryName = "";
	
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
	
	/**
	 * Get ID
	 * 
	 * returns the model ID
	 * 
	 * @return Integer
	 */
	@Override
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * Commit
	 * 
	 * saves the model to the database
	 * 
	 * @return Boolean
	 */
	public Boolean commit() {
		Integer something;
		try {
			something = MongoHelper.insert(this,"badm", getRepositoryName());
		} catch(Exception e) {
			System.out.println("Budget has not been commited because of error" + e);
			return false;
		}
		
		System.out.println(something);
		return (something > -1) ? true : false;
	}
	
	/**
	 * context
	 * 
	 * Convenience method for getting the current context
	 * 
	 * @return WorkletContext
	 */
	public static WorkletContext context() {
		return WorkletContext.getInstance();
	}
	
	/**
	 * find
	 * 
	 * fetches model by id and returns the object
	 * 
	 * @param id
	 * @return BaseModel
	 */
	public static BaseModel find(Integer id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
        
        public void update(Audit audit){
            audit.getUpdated().add(0, id);
        }
	
}
