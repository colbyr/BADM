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
import cc.test.bridge.BridgeInterface;
import cc.test.bridge.BudgetFactoryInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


/**
 * This is a helper class for managing the bridge.
 *
 * @author Ron Coleman, Ph.D.
 */
public class BridgeHelper {
    /**
     * Budget factory
     */
    protected static BudgetFactoryInterface budgetFactory = null;
    
    /**
     * Register the factory so that the client can create budgets.
     */
    static {
        BridgeHelper.register(new BudgetFactory()); 
    }


    /**
     * Constructor -- private because one these need not be constructed.
     */
    private BridgeHelper() {
    }

    /**
     * Registers a budget factory. This needs to be the first method that the
     * model invokes in a static block somewhere in the the code.
     *
     * @param budgetFactory Budget factory
     */
    public static void register(BudgetFactoryInterface budgetFactory) {
        BridgeHelper.budgetFactory = budgetFactory;
    }

    /**
     * Gets the budget factory.
     *
     * @return Budget factory
     */
    public static BudgetFactoryInterface getBudgetFactory() {
        return budgetFactory;
    }

    /**
     * Hamper where dirty objects and their dirty state is stored for
     * reference by the model.
     */
    protected static HashMap<BridgeInterface, State> hamper = new  HashMap<BridgeInterface, State>();

    /**
     * Gets the hamper.
     * @return Hamper
     */
    public static HashMap<BridgeInterface, State> getHamper() {
        return  hamper;
    }
    
//    public static void doTheLaundry(){
//        hamper = new  HashMap<BridgeInterface, State>();
//    }
}
