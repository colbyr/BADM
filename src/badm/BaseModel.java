/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.BridgeConstants;
import cc.test.bridge.BridgeInterface;
import java.util.*;
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
public abstract class BaseModel extends Entry implements BridgeInterface, Comparable {

    String name;
    Double goal;
    Integer numTransactions;
    Long createTime;
    Long updateTime;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
        setUpdateTime(createTime);
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getNumTransactions() {
        return numTransactions;
    }

    public void setNumTransactions(Integer numTransactions) {
        this.numTransactions = numTransactions;
    }

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }
    @JsonIgnore
    public final static String budgetRepo = "Budgets";
    @JsonIgnore
    public final static String lineRepo = "Lines";
    @JsonIgnore
    public final static String sublineRepo = "Sublines";
    @JsonIgnore
    public final static String transactionRepo = "Transactions";
    @JsonIgnore
    public final static String noteRepo = "Notes";
    @JsonIgnore
    public final static String auditRepo = "Audits";
    @JsonIgnore
    protected String repositoryName = "";

    @Override
    public void setName(String name) {
        this.name = name;
        dirty();
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Repository Name
     *
     * name of the model's Mongo collection
     */
    /**
     * Get Repository Name
     *
     * returns repo name based on the class, if repositoryName is not set
     *
     * @return String
     */
    public String getRepositoryName() {

        String name;

        if (repositoryName == "") {
            String full = this.getClass().getName();
            int mid = full.lastIndexOf('.') + 1;
            name = full.substring(mid) + "s";
        } else {
            name = repositoryName;
        }

        return name;
    }

    public BaseModel() {
        BridgeHelper.getHamper().put(this, BridgeConstants.State.CREATE);
        setCreateTime(Calendar.getInstance().getTimeInMillis());
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
        Integer newId = -1;
        HashMap hamper = BridgeHelper.getHamper();
        Iterator it = hamper.keySet().iterator();
        while (it.hasNext()) {
            BaseModel bm = (BaseModel) it.next();
            if (hamper.get(bm) == BridgeConstants.State.CREATE) {
                try {
                    newId = MongoHelper.insert(bm, BaseModel.getStoreName(), bm.getRepositoryName());
                    //System.out.println("New item being added "+ bm.getClass() + bm.getRepositoryName()+ bm.getId());
                } catch (Exception ex) {
                    System.out.println("New " + bm.getClass() + bm.getId() + " failed to be commited " + ex);
                }
            } else if (hamper.get(bm) == BridgeConstants.State.UPDATE) {
                try {
                    newId = MongoHelper.update(bm, BaseModel.getStoreName(), bm.getRepositoryName());
                    //System.out.println("Item being updated "+ bm.getClass() + bm.getName()+ bm.getId());
                } catch (Exception ex) {
                    System.out.println("Updated " + bm.getClass() + bm.getId() + " failed to be commited " + ex);
                }
            }
        }
        hamper.clear();
        return (newId > -1) ? true : false;
    }

    public Boolean delete() {
        Integer something;
        try {
            something = MongoHelper.delete(this, BaseModel.getStoreName(), getRepositoryName());
        } catch (Exception e) {
            System.out.println(this.getClass().getName() + " with id:" + id + " has not been deleted because of error" + e);
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

    public static ArrayList all() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Update
     *
     * @param audit
     */
    public void update(Audit audit) {
        if (audit.getUpdated() == null) {
            audit.setUpdated(new HashMap<String, Integer>());
        }
        audit.getUpdated().put(this.toString(), id);
        dirty();
    }

    @JsonIgnore
    public static String getStoreName() {
        return NetTask.getStoreName();
    }

    /**
     * sets the object as dirty and updates the time on it
     */
    public void dirty() {
        if (this.id != -1 && !BridgeHelper.getHamper().containsKey(this)) {
            BridgeHelper.getHamper().put(this, BridgeConstants.State.UPDATE);
        }
        updateTime = Calendar.getInstance().getTimeInMillis();
    }

    protected static void trimHamper(BaseModel bm) {
        HashMap hamper = BridgeHelper.getHamper();
        if (bm.getId() != -1 && hamper.containsKey(bm) && hamper.get(bm) == BridgeConstants.State.CREATE) {
            hamper.remove(bm);
        }
    }

    protected static void trimHamper(ArrayList<BaseModel> list) {
        for (BaseModel bm : list) {
            trimHamper(bm);
        }
    }

    @Override
    public int compareTo(Object o) {
        BaseModel bm = (BaseModel) o;
        if(bm.getUpdateTime() < updateTime){
            return 1;
        }
        else if(bm.getUpdateTime() > updateTime){
            return -1;
        }
        return 0;
    }
    
    @Override
    public String toString(){
        return this.getRepositoryName();
    }
}