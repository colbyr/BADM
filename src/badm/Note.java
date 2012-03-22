/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.NoteInterface;
import java.util.Date;
import org.workplicity.entry.Entry;

/**
 *
 * @author Trescenzi
 */
public class Note extends BaseModel implements NoteInterface{
    protected String text;
    protected String name;
    protected Date date;
    protected String author;
    
    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String t) {
        text = t;
        //TODO: set dirty
    }

    @Override
    public String getAuthor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAuthor(String string) {
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

}
