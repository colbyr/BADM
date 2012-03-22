/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.LineInterface;
import cc.test.bridge.SublineInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import org.workplicity.entry.Entry;
import org.workplicity.worklet.WorkletContext;
import org.workplicity.util.Helper;
import com.mongodb.util.JSON;



/**
 *
 * @author idontknow5691
 */
public class Line extends BaseModel implements LineInterface {
    Integer number;
    String name;
    Integer budgetId;
    Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public Integer getNumber() {
            return number;
    }
    
    public void setNumber(Integer n){
        number = n;
    }
    
    public void setBudgetId(Integer id){
        budgetId=id;
    }
    
    public Integer getBudgetId(){
        return budgetId;
    }

    @Override
    public ArrayList<SublineInterface> fetchSublines() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.lineId",this.id); //entry.budgetId seems to be how he did this not sure why it works
            return Helper.query(new Subline().getRepositoryName(),JSON.serialize(query),  WorkletContext.getInstance());
    }

    @Override
    public SublineInterface createSubline() {
           return new Subline();
    }

    @Override
    public void add(SublineInterface si) {
            Subline subline = (Subline)si;
            //subline.setLineId(id);
    }

    @Override
    public void delete(SublineInterface si) {
            Subline subline = (Subline) si;
            Helper.delete(subline, subline.getRepositoryName(), WorkletContext.getInstance());
    }

    @Override
    public void setName(String string) {
            name = string;
    }

    @Override
    public String getName() {
            return name;
    } 
    
    public void update(Audit audit){
        super.update(audit);
        Budget.find(budgetId).update(audit);
    }
    
   public static Line find(Integer id) {	
       return (Line) Helper.fetch("Lines", id, context());
    }

}
