/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.NoteInterface;
import java.util.Date;
import org.workplicity.entry.Entry;
import org.workplicity.util.Helper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author Trescenzi
 */
public class Note extends BaseModel implements NoteInterface{
    protected String text;
    protected String name;
    protected Date date;
    protected String author;
    protected Integer budgetId;
    
    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getText() {
        return text;
    }
    
    public void setBudgetId(Integer id){
        budgetId=id;
    }
    
    public Integer getBudgetId(){
        return budgetId;
    }

    @Override
    public void setText(String t) {
        text = t;
        //TODO: set dirty
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String string) {
        author = string;
    }

    @Override
    public void setName(String string) {
        name = string;
    }

    @Override
    public String getName() {
        return name;
    }

}
