/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.NoteInterface;
import com.mongodb.BasicDBObject;
import java.util.Date;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;

/**
 * Note
 * 
 * Model of user notes, belonging to a budget
 * 
 * @author Trescenzi
 */
public class Note extends BaseModel implements NoteInterface {

	protected String text;
	protected Date date;
	protected String author;
	protected Integer budgetId;

	/**
	 * get date
	 * 
	 * returns the note date
	 * 
	 * @return Date
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * get text
	 * 
	 * get note text
	 * 
	 * @return String
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * set budget id
	 * 
	 * sets the id of the note's budget
	 * 
	 * @param id 
	 */
	public void setBudgetId(Integer id) {
		budgetId = id;
                dirty();
	}

	/**
	 * get budget id
	 * @return 
	 */
	public Integer getBudgetId() {
		return budgetId;
	}

	/**
	 * set text
	 * 
	 * set note text
	 * 
	 * @param t 
	 */
	@Override
	public void setText(String t) {
		text = t;
		dirty();
	}

	/**
	 * get author 
	 * 
	 * get note author
	 * 
	 * @return String
	 */
	@Override
	public String getAuthor() {
		return author;
	}

	/**
	 * set author
	 * 
	 * sets note author
	 * 
	 * @param string 
	 */
	@Override
	public void setAuthor(String string) {
		author = string;
                dirty();
	}

	/**
	 * find
	 * 
	 * find and returns note object by id
	 * 
	 * @param id
	 * @return Note
	 */
	public static Note find(Integer id) {
		BasicDBObject query = new BasicDBObject();
		query.put("entry.id", id);
		System.out.println(id);
		try{
			return (Note) MongoHelper.query(query, BaseModel.getStoreName(),new Note().getRepositoryName()).get(0);
		}catch(Exception e){
			System.out.println("couldnt find note #"+id+" "+e);
			return null;
		}
	}
}
