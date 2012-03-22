/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.SublineInterface;
import cc.test.bridge.TransactionInterface;
import java.util.ArrayList;
import org.workplicity.entry.Entry;

/**
 *
 * @author idontknow5691
 */
public class Subline extends BaseModel implements SublineInterface {

	@Override
	public ArrayList<TransactionInterface> fetchTransactions() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public TransactionInterface createTransaction() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Integer getSubNumber() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void add(TransactionInterface ti) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(TransactionInterface ti) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setName(String string) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Boolean commit() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
