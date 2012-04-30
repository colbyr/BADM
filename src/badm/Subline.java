/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.SublineInterface;
import cc.test.bridge.TransactionInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;

/**
 * Represents a Subline in the model. A subline is a specific entry in a line. A
 * subline is broken up into transactions which then contain the values for the
 * subline.
 *
 * @author idontknow5691
 */
public class Subline extends Line implements SublineInterface {

    protected Integer subNumber;
    protected Integer lineId;

    /**
     *
     * @return The linked Line's id.
     */
    public Integer getLineId() {
        return lineId;
    }

    /**
     * Associates a Subline with a Line. Must be called if the Subline is to be
     * paired with a Line unless you already called Line.createSubline() or
     * Line.add(Subline) with this specific Subline.
     *
     * @param id The new Budget to link to this Line
     */
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
        dirty();
    }

    /**
     * Fetches all of the Transactions linked to the Subline. In the future more
     * control will be avaiable over how Transactions can be fetched.
     *
     * @return All linked Transactions
     */
    @Override
    public ArrayList<TransactionInterface> fetchTransactions() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.sublineId", id);
        ArrayList result;
        try {
            result = MongoHelper.query(query, BaseModel.getStoreName(), transactionRepo);
            trimHamper(result);
        } catch (Exception e) {
            result = null;
            System.out.println("couldn't fetch transactions" + e);
        }
        return result;
    }

    /**
     * Makes a new Transaction and links it to the calling Subline.
     *
     * @return A new Transaction
     */
    @Override
    public TransactionInterface createTransaction() {
        Transaction t = new Transaction();
        t.setSublineId(id);
        return t;
    }

    /**
     *
     * @return the Subline number
     */
    @Override
    public Integer getSubNumber() {
        return subNumber;
    }

    /**
     *
     * @param num The new Subline number
     */
    public void setSubNumber(Integer num) {
        subNumber = num;
        dirty();
    }

    /**
     * Links a Transaction to the calling Subline.
     *
     * @param ti The Transaction to be linked.
     */
    @Override
    public void add(TransactionInterface ti) {
        Transaction t = (Transaction) ti;
        t.setSublineId(id);
    }

    /**
     * Deletes the specified Transaction
     *
     * @param ti The Transaction to be deleted.
     */
    @Override
    public void delete(TransactionInterface ti) {
        Transaction t = (Transaction) ti;
        try {
            t.delete();
        } catch (Exception e) {
            System.out.println("couldn't delete transaction - " + e);
        }
    }

    /**
     * Finds a Subline.
     *
     * @param id The id of the Subline to be found.
     * @return The Subline or null if not found
     */
    public static Subline find(Integer id) {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.id", id);
        try {
            Subline su = (Subline) MongoHelper.query(query, BaseModel.getStoreName(), sublineRepo).get(0);
            trimHamper(su);
            return su;
        } catch (Exception e) {
            System.out.println("couldnt find Subline #" + id + " " + e);
        }
        return null;
    }

    @Override
    public void update(Audit audit) {
        //audit.getUpdated().add(0, id);
        double value = audit.getValue();
        if (total == null) {
            total = value;
        } else {
            total += value;
        }
        if (audit.getUpdated() == null) {
            audit.setUpdated(new HashMap<String, Integer>());
        }
        audit.getUpdated().put(this.toString(), id);
        dirty();
        Line.find(lineId).update(audit);

    }
}
