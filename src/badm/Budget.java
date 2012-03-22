/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.BridgeConstants.Side;
import cc.test.bridge.BudgetFactoryInterface;
import cc.test.bridge.BudgetInterface;
import cc.test.bridge.LineInterface;
import cc.test.bridge.NoteInterface;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import org.workplicity.entry.Entry;
import org.workplicity.util.Helper;
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
        query.put("entry.budgetId",this.id); //entry.budgetId seems to be how he did this not sure why it works
        System.out.println("query:"+JSON.serialize(query));
        return Helper.query(new Line().getRepositoryName(), JSON.serialize(query), WorkletContext.getInstance());
    }

    @Override
    public ArrayList<NoteInterface> fetchNotes() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.budgetId",this.id); //entry.budgetId seems to be how he did this not sure why it works
        return Helper.query(new Note().getRepositoryName(), JSON.serialize(query), WorkletContext.getInstance());
    }

    @Override
    public LineInterface createLine() {
        return new Line();
    }

    @Override
    public NoteInterface createNote() {
        return new Note();
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
	return (Budget) Helper.fetch("Budgets", id, context());
    }
    
}
