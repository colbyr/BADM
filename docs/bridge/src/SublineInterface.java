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

/**
 * This interface is a bridge to the subline class.
 * @author Ron Coleman, Ph.D.
 */
public interface SublineInterface extends BridgeInterface {
    
    /**
     * Gets all the transactions associated with this subline.
     * @return List of transaction which will have length greater than or equal to zero
     */
    public ArrayList<TransactionInterface> fetchTransactions();


    /**
     * Creates a new transaction in the NEW state but does not add it to the list
     * of transactions.
     * @return 
     */
    public TransactionInterface createTransaction();
    
    public Integer getSubNumber();
    
    public void add(TransactionInterface transaction);
    
    public void delete(TransactionInterface transaction);
    
}
