/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import com.mongodb.BasicDBObject;
import java.util.HashMap;
import org.workplicity.util.MongoHelper;

/**
 * Audit
 *
 * Model for tracking budget changes
 *
 * @author Colby Rabideau
 */
public class Audit extends BaseModel {

	protected Integer timestamp;
	protected HashMap<String , Integer> updated;
	protected String description;
	protected Integer budgetId;
        protected Double value;

        /**
         * The value of the change that is represented by the audit.
         * @return the value
         */
        public Double getValue() {
            return value;
        }

        /**
         * 
         * @param value The value of the change
         */
        public void setValue(Double value) {
            this.value = value;
            dirty();
        }
        

	/**
	 * get budget id
	 * 
	 * returns id of parent budget
	 * 
	 * @return 
	 */
	public Integer getBudgetId() {
		return budgetId;
	}

	/**
	 * set budget id
	 * 
	 * sets parent budget id
	 * 
	 * @param budgetId 
	 */
	public void setBudgetId(Integer budgetId) {
		this.budgetId = budgetId;
                dirty();
	}

	/**
	 * get description
	 * 
	 * gets audit description
	 * 
	 * @return 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * set description
	 * 
	 * sets audit description
	 * 
	 * @param description 
	 */
	public void setDescription(String description) {
		this.description = description;
                dirty();
	}

	/**
	 * get updated
	 * 
	 * returns array list of update chain
	 * 
	 * @return 
	 */
	public HashMap<String,Integer> getUpdated() {
		return updated;
	}

	/**
	 * set updated
	 * 
	 * set updated chain array list
	 * 
	 * @param updated 
	 */
	public void setUpdated(HashMap<String,Integer> updated) {
		this.updated = updated;
                dirty();
	}

	/**
	 * get audit timestamp
	 * @return 
	 */
	public Integer getTimeStamp() {
		return timestamp;
	}
        
        public void setTimeStamp(Integer time){
            timestamp = time;
            dirty();
        }
        
            /**
     * Finds a Audit with a specific id.
     * @param id The id of the Audit to be found
     * @return The Audit, of null if not found.
     */
    public static Audit find(Integer id) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("entry.id", id);
	    System.out.println(id);
	    try{
		Audit audit = (Audit) MongoHelper.query(query,BaseModel.getStoreName(),auditRepo).get(0);
                trimHamper(audit);
                return audit;
	    }catch(Exception e){
		    System.out.println("couldnt find audit #"+id+" "+e);
	    }
	    return null;
    }

	
}