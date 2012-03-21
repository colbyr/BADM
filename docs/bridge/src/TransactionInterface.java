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
 * This interface is a bridge to the transaction class.
 * @author Ron Coleman, Ph.D.
 */
public interface TransactionInterface extends BridgeInterface {
    /**
     * Gets the date of the transaction.
     * @return Transaction date
     */
    public Date getDate();
    
    /**
     * Sets the date of the transaction.
     * @param date Sets the transaction date.
     */
    public void setDate(Date date);
    
    /**
     * Gets the amount of the transaction. It will always be >= 0.
     * @return Transaction amount.
     */
    public Double getAmount();
    
    /**
     * Sets the transaction amount.
     * @param amount Amount always >= 0
     */
    public void setAmount(Double amount);
}
