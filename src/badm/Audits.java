/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import java.util.ArrayList;
import org.workplicity.entry.Entry;

/**
 *
 * @author idontknow5691
 */
public class Audits extends Entry {

	public int timestamp;
	
	public ArrayList<Integer> updated;
	
	public String description;
	
	public int getTimestamp()
	{
		return timestamp;
	}
	
	public ArrayList getUpdated()
	{
		return updated;
	}
	
}