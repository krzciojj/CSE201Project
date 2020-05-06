package steakstore;

import java.io.Serializable;

public class Filter implements Serializable {
	private String term;
	/**
	 * Constructor that calls on setTerm to set the term for the filter
	 * @param t the string of the term
	 */
	public Filter(String t) {
		setTerm(t);
	}
/**
 * Gets the term for the filter
 * @return
 */
	public String getTerm() {
		return term;
	}
/**
 * sets the term for the filter
 * @param term
 */
	public void setTerm(String term) {
		this.term = term;
	}
}