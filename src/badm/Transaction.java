/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.TransactionInterface;
import com.mongodb.BasicDBObject;
import java.util.Date;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;

/**
 *
 * @author idontknow5691
 */
public class Transaction extends BaseModel implements TransactionInterface {

	protected Integer sublineId;
	protected String name;
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
         *  Associates a Transaction with a Subline. Must be called if the 
         * Transaction is to be paired with a Subline unless you already
         * called Subline.createTransaction() or Subline.add(Transaction) with this
         * specific Transaction.
         * @param sid The Subline to link to
         */
	public void setSublineId(Integer sid) {
		this.sublineId = sid;
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
	}

        /**
         * 
         * @param name New name
         */
	@Override
	public void setName(String name) {
		this.name = name;
	}

        /**
         * 
         * @return The name of the Transaction
         */
	@Override
	public String getName() {
		return name;
	}
        
        /**
         * Finds a Transaction.
         * @param id The id of the Transaction to be found.
         * @return The Transaction or null if not found
         */
	public static Transaction find(Integer id) {
            BasicDBObject query = new BasicDBObject();
            query.put("entry.id", id);
            try{
                return (Transaction) MongoHelper.query(query,BaseModel.getStoreName(),new Transaction().getRepositoryName()).get(0);
            }catch(Exception e){
                    System.out.println("couldnt find Subline #"+id+" "+e);
            }
            return null;	
        }
	
}