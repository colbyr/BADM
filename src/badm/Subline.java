/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.SublineInterface;
import cc.test.bridge.TransactionInterface;
import java.util.ArrayList;
import org.workplicity.util.Helper;

/**
 *
 * @author idontknow5691
 */
public class Subline extends BaseModel implements SublineInterface {

	protected String name;
	protected Integer subNumber;
	
	@Override
	public ArrayList<TransactionInterface> fetchTransactions() {
		throw new UnsupportedOperationException("Not supported yet.");
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
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(TransactionInterface ti) {
		Transaction t = (Transaction) ti;
		Helper.delete(t, t.getRepositoryName(), context());
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	public static Subline find(Integer id) {
            return (Subline) Helper.fetch("Sublines", id, context());
	}
	
}
