package steakstore;

import java.io.Serializable;

/**
 * This class helps main access review scores
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class Review implements Serializable{
	int score;
	User author;
	/**
	 * Constructor that sets a score and an author
	 * @param score the score the user (author) gave
	 * @param author the user who gave the score
	 */
	public Review (int score, User author) {
		this.score = score;
		this.author = author;
	}
	
	/**
	 * Returns the score of the review
	 * 
	 * @return The score of the review
	 */
	public int getScore() {
		return score;
	}
	
	public User getAuthor() {
		return author;
	}

}