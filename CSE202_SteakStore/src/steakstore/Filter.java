package steakstore;

import java.io.Serializable;

public class Filter implements Serializable {
	private String term;
	
	public Filter(String t) {
		setTerm(t);
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}