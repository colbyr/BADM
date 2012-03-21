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

import java.util.Date;

/**
 * This interface is a bridge to the note class.
 * @author Ron Coleman, Ph.D.
 */
public interface NoteInterface extends BridgeInterface {
    /**
     * Gets the date of the note.
     * Note this is distinguished from the update date which this class inherits.
     * @return Date
     */
    public Date getDate();
    
    /**
     * Gets the note text.
     * @return String
     */
    public String getText();
    
    /**
     * Sets the note text.
     * @param text Text of the note
     */
    public void setText(String text);
    
    /**
     * Gets the author.
     * @return String
     */
    public String getAuthor();
    
    /**
     * Sets the author.
     * @param author Author
     */
    public void setAuthor(String author);
}
