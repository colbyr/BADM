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
    protected ArrayList<Integer> noteIds;
    private final static String repoName = "budget";
    
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
        return Helper.query("Lines", JSON.serialize(query), WorkletContext.getInstance());
    }

    @Override
    public ArrayList<NoteInterface> fetchNotes() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.budgetId",this.id); //entry.budgetId seems to be how he did this not sure why it works
        return Helper.query("Notes", JSON.serialize(query), WorkletContext.getInstance());
    }

    @Override
    public LineInterface createLine() {
        return null;
    }

    @Override
    public NoteInterface createNote() {
        return null;
    }

    @Override
    public void add(NoteInterface ni) {
        
    }

    @Override
    public void delete(NoteInterface ni) {
        
    }

    @Override
    public void add(LineInterface li) {
        
    }

    @Override
    public void delete(LineInterface li) {
        
    }

    @Override
    public void update(LineInterface li) {
       
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
    
}
