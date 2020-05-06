package steakstore;

public class Review {
	int score;
	User author;
	
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

}