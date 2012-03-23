/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.SublineInterface;
import cc.test.bridge.TransactionInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;

/**
 *
 * @author idontknow5691
 */
public class Subline extends Line implements SublineInterface {

	protected Integer subNumber;

	@Override
	public ArrayList<TransactionInterface> fetchTransactions() {
		BasicDBObject query = new BasicDBObject();
		query.put("entry.budgetId", id);
		ArrayList<TransactionInterface> result;
		try {
			result = MongoHelper.query(query, BaseModel.getStoreName(), new Line().getRepositoryName());
		} catch (Exception e) {
			result = null;
			System.out.println("couldn't fetch lines" + e);
		}
		return result;
	}

	@Override
	public TransactionInterface createTransaction() {
		Transaction t = new Transaction();
		t.setSublineId(id);
		return t;
	}
        
        @Override
	public Integer getSubNumber() {
		return subNumber;
	}

	@Override
	public void add(TransactionInterface ti) {
		Transaction t = (Transaction) ti;
		t.setSubline(this);
	}

	@Override
	public void delete(TransactionInterface ti) {
		Transaction t = (Transaction) ti;
		Helper.delete(t, t.getRepositoryName(), context());
		try {
			MongoHelper.delete(t, BaseModel.getStoreName(), this.getRepositoryName());
		} catch (Exception e) {
			System.out.println("couldn't delete transaction - " + e);
		}
	}

	public static Subline find(Integer id) {
		return (Subline) Helper.fetch("Sublines", id, context());
	}
}
