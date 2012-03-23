/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import java.util.ArrayList;

/**
 * Audit
 *
 * Model for tracking budget changes
 *
 * @author Colby Rabideau
 */
public class Audit extends BaseModel {

	public int timestamp;
	public ArrayList<Integer> updated;
	public String description;
	protected Integer budgetId;

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
	}

	/**
	 * get updated
	 * 
	 * returns array list of update chain
	 * 
	 * @return 
	 */
	public ArrayList<Integer> getUpdated() {
		return updated;
	}

	/**
	 * set updated
	 * 
	 * set updated chain array list
	 * 
	 * @param updated 
	 */
	public void setUpdated(ArrayList<Integer> updated) {
		this.updated = updated;
	}

	/**
	 * get audit timestamp
	 * @return 
	 */
	public int getTimestamp() {
		return timestamp;
	}
	
}