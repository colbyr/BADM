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
package badm;

import cc.test.bridge.BridgeConstants.State;
import cc.test.bridge.BudgetFactoryInterface;
import cc.test.bridge.BudgetInterface;

/**
 * This class creates uncommitted budgets. 
 * @author Ron Coleman, Ph.D.
 */
public class BudgetFactory implements BudgetFactoryInterface {

    /**
     * Creates a new budget that will be written to persistence on commit
     * @return Uncommitted budget
     */
    @Override
    public BudgetInterface create() {
        // Create a budget
        Budget budget = new Budget();     
        return budget;
    }


}
