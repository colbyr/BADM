/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;


import cc.test.bridge.BridgeConstants;
import cc.test.bridge.BridgeInterface;
import java.util.Iterator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.workplicity.entry.Entry;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 * BaseModel
 *	
 * Gloabl model methods
 * 
 * @author Colby Rabideau
 */
abstract class BaseModel extends Entry implements BridgeInterface{
	
    
        String name;
        @Override
        public void setName(String name){
            this.name = name;
            dirty();
        }
        @Override
        public String getName(){
            return name;
        }
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
        @Override
	public Boolean commit() {
		Integer something = -1;
		try {
            for (Iterator<BridgeInterface> it = BridgeHelper.getHamper().keySet().iterator(); it.hasNext();) {
                
                BaseModel bm = (BaseModel)it.next();
                System.out.println("Checking State"+ bm.getClass());
                System.out.println(BridgeHelper.getHamper().get(bm));
                if(BridgeHelper.getHamper().get(bm) == BridgeConstants.State.UPDATE ||
                        BridgeHelper.getHamper().get(bm) == BridgeConstants.State.CREATE){
                    something = MongoHelper.insert(bm,BaseModel.getStoreName(), bm.getRepositoryName());
                    System.out.println("Commiting "+bm.getId()+ "to repo");
                }
            }
		} catch(Exception e) {
			System.out.println(this.getClass().getName()+" with id:" + id + " has not been commited because of error" + e);
			return false;
		}
                return (something > -1) ? true : false;
	}
        
        public Boolean delete(){
            Integer something;
		try {
			something = MongoHelper.delete(this,BaseModel.getStoreName(), getRepositoryName());
		} catch(Exception e) {
			System.out.println(this.getClass().getName()+" with id:" + id + " has not been deleted because of error" + e);
			return false;
		}
		return (something > -1) ? true : false; 
        }
	
	/**
	 * context
	 * 
	 * Convenience method for getting the current context
	 * 
	 * @return WorkletContext
	 */
	public static WorkletContext context(){
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
        
	/**
	 * Update
	 * 
	 * @param audit 
	 */
        public void update(Audit audit){
            audit.getUpdated().add(0, id);
            dirty();
        }
        
        @JsonIgnore
        public static String getStoreName() {
            return NetTask.getStoreName();
        }
        
        
        public void dirty(){
            BridgeHelper.getHamper().put(this,BridgeConstants.State.UPDATE);
        }
	
}
