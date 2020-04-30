package steakstore;

public class Review {
	int score;
	String review;
	User author;
	
	public Review (int score, String review, User author) {
		this.score = score;
		this.review = review;
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