/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import java.util.ArrayList;

/**
 *
 * @author idontknow5691
 */
public class Audit extends BaseModel {

	public int timestamp;
	
	public ArrayList<Integer> updated;
	
	public String description;
        
        protected Integer budgetId;

        public Integer getBudgetId() {
            return budgetId;
        }

        public void setBudgetId(Integer budgetId) {
            this.budgetId = budgetId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ArrayList<Integer> getUpdated() {
            return updated;
        }

        public void setUpdated(ArrayList<Integer> updated) {
            this.updated = updated;
        }
	public Integer budgetId;
	public ArrayList<Integer> updated;
	public String description;

	public void setBudgetId(Integer budgetId) {
		this.budgetId = budgetId;
	}
	
	public Integer getBudgetId() {
		return budgetId;
	}
	
	public int getTimestamp()
	{
		return timestamp;
	}


	public ArrayList getUpdated()
	{
		return updated;
	}

}