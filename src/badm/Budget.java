/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.BridgeConstants.Side;
import cc.test.bridge.BudgetInterface;
import cc.test.bridge.LineInterface;
import cc.test.bridge.NoteInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 * Budget
 * 
 * @author Trescenzi
 */
public class Budget extends BaseModel implements BudgetInterface {
    protected String description;
    protected String name;
    protected Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String d) {
        description = d;
    }

    @Override
    public ArrayList<LineInterface> fetchLines(Side side) {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.budgetId", id);
        try{
            return MongoHelper.query(query,BaseModel.getStoreName(),new Line().getRepositoryName());
        }catch(Exception e){
                System.out.println("couldn't fetch lines"+e);
        }
        return null;
    }

    @Override
    public ArrayList<NoteInterface> fetchNotes() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.budgetId", id);
        try{
            return MongoHelper.query(query,BaseModel.getStoreName(),new Note().getRepositoryName());
        }catch(Exception e){
                System.out.println("couldn't fetch notes"+e);
        }
        return null;
    }

    @Override
    public LineInterface createLine() {
	Line ln = new Line();
	ln.setBudgetId(id);
        return ln;
    }

    @Override
    public NoteInterface createNote() {
	Note n = new Note();
	n.setBudgetId(id);
        return n;
    }

    @Override
    public void add(NoteInterface ni) {
        Note note = (Note) ni;
        note.setBudgetId(this.id);
    }

    @Override
    public void delete(NoteInterface ni) {
        Note note = (Note) ni;
        Helper.delete(note, note.getRepositoryName(), WorkletContext.getInstance());
    }

    @Override
    public void add(LineInterface li) {
        Line line = (Line) li;
        //line.setBudgetId(this.id);
    }

    @Override
    public void delete(LineInterface li) {
        Line line = (Line) li;
        Helper.delete(line, line.getRepositoryName(), WorkletContext.getInstance());
    }

    @Override
    public void update(LineInterface li) {
        Line line = (Line) li;
        Helper.insert(line, line.getRepositoryName(), WorkletContext.getInstance());
    }

    @Override
    public void update(NoteInterface ni) {
        
    }

    @Override
    public void setName(String string) {
        name = string;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public org.workplicity.util.WorkDate getUpdateDate() {
        return null;
    }

    public BudgetInterface create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void addAudit(Audit audit){
        audit.setBudgetId(id);
    }
    
    public void update(Audit audit){
        super.update(audit);
        //TODO add totals and stuffs
        addAudit(audit);
    }
    
    public static Budget find(Integer id) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("entry.id", id);
	    System.out.println(id);
	    try{
		return (Budget) MongoHelper.query(query,BaseModel.getStoreName(),new Budget().getRepositoryName()).get(0);
	    }catch(Exception e){
		    System.out.println("couldnt find budget #"+id+" "+e);
	    }
	    return null;
    }

}
