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

import org.workplicity.util.WorkDate;


/**
 * This interface defines behaviors for all bridges whether they are linked
 * or embedded.
 * @author Ron Coleman, Ph.D.
 */
public interface BridgeInterface {
    /**
     * Gets the unique id. It will be -1 if the budget does
     * not yet exist in the repository.
     */
    public Integer getId();

    /**
     * Sets the name. For a budget this is the "title"; for lines and sublines
     * this is the "name".
     * @return Name
     */    
    public void setName(String name);
    
    /**
     * Gets the name. For a budget this is the "title"; for lines and sublines
     * this is the "name".
     * @return Name
     */
    public String getName();
    
    /**
     * Gets the update date. It will be null if the budget does
     * not yet exist in the repository. 
     * @return Update date or null
     */
    public WorkDate getUpdateDate();
    
    /**
     * Commits changes for write-through to the repository.
     * @return True if the commit was successful and false otherwise
     */
    public Boolean commit();
    
    /**
     * Gets the repository name.
     * @return Repository name
     */
    public String getRepositoryName();
}
