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

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This interface is a bridge to the line class.
 * @author Ron Coleman, Ph.D.
 */
public interface LineInterface extends BridgeInterface {
    /**
     * Gets the line number. The line number is distinguished from the unique id.
     * @return Number
     */
    public Integer getNumber();
    
    /**
     * Gets all the sublines associated with this line.
     * @return Sublines
     */
    public ArrayList<SublineInterface> fetchSublines();
    
   /**
     * Creates a new subline. This does NOT add the subline to the budget. To add
     * the subline the budget use the add method.
     * @return Line
     */
    public SublineInterface createSubline();
    
    /**
     * Adds a subline to the line. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param note A note
     */    
    public void add(SublineInterface subline);
    
    /**
     * Deletes a subline in the line. This does NOT commit the change. Use the commit
     * method for this purpose.
     * @param note A note
     */     
    public void delete(SublineInterface subline);
}
