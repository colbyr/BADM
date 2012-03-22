/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.TransactionInterface;
import java.util.Date;
import org.workplicity.entry.Entry;
import org.workplicity.util.Helper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author idontknow5691
 */
public class Transaction extends BaseModel implements TransactionInterface {

	protected Integer sublineId;
	protected String name;
	protected Double amount;
	protected Date date;
	
	public Integer getSublineId() {
		return sublineId;
	}
	
	public void setSublineId(Integer sid) {
		this.sublineId = sid;
	}
	
	public Subline getSubline() {
		return Subline.find(sublineId);
	}
	
	public void setSubline(Subline subline) {
		this.sublineId = subline.getId();
	}
	
	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public static Transaction find(Integer id) {
		Transaction result;
		result = (Transaction) Helper.fetch("Transactions", id, context());
		return result;
	}
	
}