/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.BridgeHelper.Side;
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
 *
 * @author Trescenzi
 */
public class Budget extends Entry implements BudgetInterface, BudgetFactoryInterface{
    protected String description;
    protected ArrayList<Integer> noteIds;
    
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<NoteInterface> fetchNotes() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.budgetId",this.id);//entry.budgetId seems to be how he did this not sure why it works
        return Helper.query("Notes",JSON.serialize(query),WorkletContext.getInstance());
    }

    @Override
    public LineInterface createLine() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NoteInterface createNote() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(NoteInterface ni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(NoteInterface ni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(LineInterface li) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(LineInterface li) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(LineInterface li) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(NoteInterface ni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setName(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public org.workplicity.util.WorkDate getUpdateDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean commit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getRepositoryName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BudgetInterface create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
