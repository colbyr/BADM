/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm;

import cc.test.bridge.NoteInterface;
import java.util.Date;
import org.workplicity.util.Helper;

/**
 * Note
 * @author Trescenzi
 */
public class Note extends BaseModel implements NoteInterface {

	protected String text;
	protected String name;
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
		//TODO: set dirty
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
	}

	/**
	 * set name
	 * 
	 * sets note name
	 * 
	 * @param string 
	 */
	@Override
	public void setName(String string) {
		name = string;
	}

	/**
	 * get name
	 * 
	 * get note name
	 * 
	 * @return String
	 */
	@Override
	public String getName() {
		return name;
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
		return (Note) Helper.fetch("Notes", id, context());
	}
}
