/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.BridgeConstants;
import cc.test.bridge.LineInterface;
import cc.test.bridge.SublineInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;



/**
 * Represents a line in the data model. A line is a category of either
 * expenditures or income. The actual values for the pieces of the line
 * exist in the sublines. 
 * @author idontknow5691
 */
public class Line extends BaseModel implements LineInterface {
    Integer number;
    Integer budgetId;
    Double total;
    Integer numSublines;
    Boolean income;

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }

    public Integer getNumSublines() {
        return numSublines;
    }

    public void setNumSublines(Integer numSublines) {
        this.numSublines = numSublines;
    }
    
    /**
     * 
     * @return The total value of the Line
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 
     * @param total The new total value of the Line
     */
    public void setTotal(Double total) {
        this.total = total;
        dirty();
    }
    
    /**
     * 
     * @return the line number 
     */
    @Override
    public Integer getNumber() {
            return number;
    }
    
    /**
     * 
     * @param n The new line number
     */
    public void setNumber(Integer n){
        number = n;
        dirty();
    }
    
    /**
     * Associates a Line with a Budget. Must be called if the 
     * Line is to be paired with a Budget unless you already
     * called Budget.createLine() or Budget.add(Line) with this
     * specific line.
     * @param id The new Budget to link to this Line
     */
    public void setBudgetId(Integer id){
        budgetId=id;
        dirty();
    }
    
    /**
     * Gets the id for the Budget that this Line is 
     * linked to. Used for queries for finding both the Line
     * and the Budget.
     * @return Id of the linked Budget
     */
    public Integer getBudgetId(){
        return budgetId;
    }
    
    /**
     * Returns all the Sublines that are linked to this Line.
     * If no sublines exist null is returned.
     * @return Linked Sublines/null
     */
    @Override
    public ArrayList<SublineInterface> fetchSublines() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.lineId", id);
        try{
            ArrayList list = MongoHelper.query(query,BaseModel.getStoreName(),"Sublines");
            trimHamper(list);
            return list;
        }catch(Exception e){
                System.out.println("Couldnt fetch sublines of Line #"+number
                        +" because of error:"+e);
        }
        return null;
    }
    
    /**
     * Makes a new Subline and links it to the calling Line.
     * @return a new Subline
     */
    @Override
    public SublineInterface createSubline() {
           Subline subline = new Subline();
           subline.setLineId(id);
           return subline;
    }

    /**
     * Links a Subline to the calling Line
     * @param si The Subline to be linked.
     */
    @Override
    public void add(SublineInterface si) {
            Subline subline = (Subline)si;
            subline.setLineId(id);
            subline.setBudgetId(budgetId);
    }

    /**
     * Deletes a Subline.  
     * @param si The Subline to be deleted
     */
    @Override
    public void delete(SublineInterface si) {
            Subline subline = (Subline) si;
            try{
                subline.delete();
            }catch(Exception e){
                System.out.println("Failed to delete subline #" + subline.getNumber()+
                        "."+subline.getSubNumber()+ "because of error:"+e);
            }
    }

    
    /**
     * Updates the Line and then passes the Audit up to the linked Budget.
     * @param audit The Audit from which the Line will update itself
     */
    @Override
    public void update(Audit audit){
        super.update(audit);
        double value = audit.getValue();
        if(total == null)
        {
            total = value;
        }
        else
        {
            total += value;
        }
        dirty();
        Budget.find(budgetId).update(audit);
    }
    
    /**
     * Finds a Line in the Lines collection.
     * @param id The id of the Line to be found.
     * @return The Line or null if not found.
     */
    public static Line find(Integer id) {	
        BasicDBObject query = new BasicDBObject();
        query.put("entry.id", id);
        try{
           Line li = (Line) MongoHelper.query(query,BaseModel.getStoreName(),lineRepo).get(0);
           trimHamper(li);
           return li;
        }catch(Exception e){
                System.out.println("couldnt find line #"+id+" "+e);
        }
        return null;
    }

}
