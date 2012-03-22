/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.TransactionInterface;
import java.util.Date;
import org.workplicity.entry.Entry;

/**
 *
 * @author idontknow5691
 */
public class Transaction extends BaseModel implements TransactionInterface {

	@Override
	public Date getDate() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setDate(Date date) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Double getAmount() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setAmount(Double d) {
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

}