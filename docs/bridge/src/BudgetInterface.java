//Copyright (C) 2012 Ron Coleman. Contact: ronncoleman at gmail.com
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License
//as published by the Free Software Foundation; either
//version 3 of the License, or (at your option) any later version.
//
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this library; if not, write to the Free Software
//Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
package cc.test.bridge;

import cc.test.bridge.BridgeConstants.Side;
import java.util.ArrayList;

/**
 * This interface is a bridge to the budget class. 
 * @author Ron Coleman, Ph.D.
 */
public interface BudgetInterface extends BridgeInterface {
    /**
     * Gets the budget description.
     * @return Description
     */
    public String getDescription();    
    
    /**
     * Sets the budget description.
     * @param description Description
     */
    public void setDescription(String description);

    /**
     * Gets the existing lines of a budget. The returned array list is intended
     * to be immutable. To add / delete a line use the add / delete
     * methods and invoke this method again to get the updated line array list.
     * @param side Side (income or expenditures)
     * @return Array list of notes
     */
    public ArrayList<LineInterface> fetchLines(Side side);
    

    /**
     * Gets the existing notes of a budget. The returned array list is intended
     * to be immutable. To add / delete a note use the add / delete
     * methods and invoke this method again to get the updated notes array list.
     * @return Array list of notes
     */
    public ArrayList<NoteInterface> fetchNotes();   
    
    /**
     * Creates a new line. This does NOT add the line to the budget. To add
     * the line the budget use the add method.
     * @return Line
     */
    public LineInterface createLine();
    
    /**
     * Creates a new note. This does NOT add the note to the budget. To add the
     * note to the budget use the add method.
     * @return Note
     */
    public NoteInterface createNote();
    
    /**
     * Adds a note to the budget. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param note A note
     */
    public void add(NoteInterface note);
    
    /**
     * Deletes a note in the budget. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param note A note
     */    
    public void delete(NoteInterface note);

    /**
     * Adds a line to the budget. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param line A line
     */
    public void add(LineInterface line);
    
    /**
     * Deletes a line in the budget. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param line A line
     */ 
    public void delete(LineInterface line);
    
    
    /**
     * Updates a line in the budget. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param line A line
     */     
    public void update(LineInterface line);
    
   /**
     * Updates a note in the budget. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param note A note
     */     
    public void update(NoteInterface note);
    
}
