/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.TransactionInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Date;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;

/**
 * A Transaction. This represents a single change in value for a Budget.
 * Depending on the type of the Budget and how often the Budget is to be updated
 * the number of Transactions will change. The only place that a number amount
 * can change is in a Transaction and the change will then "bubble up" as an
 * Audit changing the values of other objects as it goes.
 *
 * @author Colby Rabideau
 */
public class Transaction extends BaseModel implements TransactionInterface {

	protected Integer sublineId;
	protected Double amount;
	protected Date date;

	/**
	 *
	 * @return The id of the linked Subline
	 */
	public Integer getSublineId() {
		return sublineId;
	}

	/**
	 * Associates a Transaction with a Subline. Must be called if the
	 * Transaction is to be paired with a Subline unless you already called
	 * Subline.createTransaction() or Subline.add(Transaction) with this
	 * specific Transaction.
	 *
	 * @param sid The Subline to link to
	 */
	public void setSublineId(Integer sid) {
		this.sublineId = sid;
		dirty();
	}

	/**
	 *
	 * @return Date of creation
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 *
	 * @param date The new Date
	 */
	@Override
	public void setDate(Date date) {
		this.date = date;
		dirty();
	}

	/**
	 *
	 * @return The value of the Transaction
	 */
	@Override
	public Double getAmount() {
		return amount;
	}

	/**
	 *
	 * @param amount New amount
	 */
	@Override
	public void setAmount(Double amount) {
		this.amount = amount;
                dirty();
	}

	@Override
	public void update(Audit audit) {
		super.update(audit);
		audit.setDescription("Change in transaction " + this.getId() + " " + audit.getValue());
                //try{
		Subline su = Subline.find(sublineId);
                System.out.println(su.getId());
                        su.update(audit);
                /*}catch(NullPointerException e){
                    System.out.println("Subline associated with Transcation #"+id+
                            " with subline id of " + sublineId + " does not exits");
                }*/
	}

	/**
	 * Finds a Transaction.
	 *
	 * @param id The id of the Transaction to be found.
	 * @return The Transaction or null if not found
	 */
	public static Transaction find(Integer id) {
		BasicDBObject query = new BasicDBObject();
		query.put("entry.id", id);
		try {
			Transaction t = (Transaction) MongoHelper.query(query, BaseModel.getStoreName(),transactionRepo).get(0);
                        trimHamper(t);
                        return t;
		} catch (Exception e) {
			System.out.println("couldnt find Transaction #" + id + " " + e);
		}
		return null;
	}
}