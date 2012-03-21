////Copyright (C) 2012 Ron Coleman. Contact: ronncoleman at gmail.com
////
////This library is free software; you can redistribute it and/or
////modify it under the terms of the GNU General Public License
////as published by the Free Software Foundation; either
////version 3 of the License, or (at your option) any later version.
////
////This library is distributed in the hope that it will be useful,
////but WITHOUT ANY WARRANTY; without even the implied warranty of
////MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
////General Public License for more details.
////
////You should have received a copy of the GNU General Public License
////along with this library; if not, write to the Free Software
////Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
//package cc.test.bridge;
//import java.util.HashMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * This is a helper class for managing the bridge.
// *
// * @author Ron Coleman, Ph.D.
// */
//public class BridgeHelper {
//
//    /**
//     * Budget factory
//     */
//    protected static BudgetFactoryInterface budgetFactory = null;
//
//    /**
//     * Constructor -- private to private to suggest one of these need not be
//     * constructed.
//     */
//    private BridgeHelper() {
//    }
//
//    /**
//     * Registers a budget factory. This needs to be the first method that the
//     * model invokes in a static block somewhere in the the code.
//     *
//     * @param budgetFactory Budget factory
//     */
//    public static void register(BudgetFactoryInterface budgetFactory) {
//        BridgeHelper.budgetFactory = budgetFactory;
//    }
//
//    /**
//     * Gets the budget factory.
//     *
//     * @return Budget factory
//     */
//    public static BudgetFactoryInterface getBudgetFactory() {
//        return budgetFactory;
//    }
//    
//    public static BudgetInterface getBudget(String className) {
//        try {
//            return (BudgetInterface) Class.forName(className).newInstance();
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//        
//        return null;
//    }
//
//    public enum State {
//        /**
//         * Clean state is never used since anything thing that is not
//         * in the hamper is assumed to be clean. However, for future
//         * reference and completeness this state has been added here.
//         */
//        CLEAN, 
//        
//        /**
//         * Create state implies a never object is being added or created
//         * for the first time. The object is not yet been persisted.
//         */
//        CREATE,
//        
//        /**
//         * Update state implies the object has been updated and needs to be
//         * written to persistent store.
//         */
//        UPDATE,
//        
//        /**
//         * Delete state implies the object has been deleted and needs to be
//         * retired from persistent storage.
//         */
//        DELETE
//    };
//    
//    public enum Side {
//        /**
//         * Income side
//         */
//        INCOME, 
//        
//        /**
//         * Expenditures side
//         */
//        EXPENDITURE };    
//    
//    /**
//     * Hamper where dirty objects and their dirty state is stored for
//     * reference by the model.
//     */
//    protected static HashMap<BridgeInterface, State> hamper = new HashMap<BridgeInterface, State>();
//
//    /**
//     * Gets the hamper.
//     * @return Hamper
//     */
//    public static HashMap<BridgeInterface, State> getHamper() {
//        return hamper;
//    }
//}
