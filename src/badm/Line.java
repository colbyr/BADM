/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.LineInterface;
import cc.test.bridge.SublineInterface;
import java.util.ArrayList;
import org.workplicity.entry.Entry;

/**
 *
 * @author idontknow5691
 */
public class Line extends Entry implements LineInterface {

	@Override
	public Integer getNumber() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ArrayList<SublineInterface> fetchSublines() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public SublineInterface createSubline() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void add(SublineInterface si) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(SublineInterface si) {
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

	@Override
	public String getRepositoryName() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
