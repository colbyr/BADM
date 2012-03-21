/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.test.bridge;

/**
 *
 * @author roncoleman125
 */
public class BridgeConstants {
    

    public enum State {
        /**
         * Clean state is never used since anything thing that is not
         * in the hamper is assumed to be clean. However, for future
         * reference and completeness this state has been added here.
         */
        CLEAN, 
        
        /**
         * Create state implies a never object is being added or created
         * for the first time. The object is not yet been persisted.
         */
        CREATE,
        
        /**
         * Update state implies the object has been updated and needs to be
         * written to persistent store.
         */
        UPDATE,
        
        /**
         * Delete state implies the object has been deleted and needs to be
         * retired from persistent storage.
         */
        DELETE
    };
    
    public enum Side {
        /**
         * Income side
         */
        INCOME, 
        
        /**
         * Expenditures side
         */
        EXPENDITURE };    
    
}
