/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.LineInterface;
import cc.test.bridge.SublineInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;



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
        query.put("entry.lineId", id);
        System.out.println(id);
        try{
            return MongoHelper.query(query,BaseModel.getStoreName(),new Subline().getRepositoryName());
        }catch(Exception e){
                System.out.println("couldnt fetch sublines"+e);
        }
        return null;
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
