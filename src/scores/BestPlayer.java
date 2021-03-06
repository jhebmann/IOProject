package scores;

/**
 * A class which represents one of the best players
 * 
 * @author birzaneanu, hebmann
 */
public class BestPlayer {
	private String player;
	private int score;
	
	/**
	 * Constructs a best player from a score and its nickname.
	 * @param n The nickname you want to give to the player
	 * @param s The score you want to give to the player
	 */
	public BestPlayer(String n, int s){
		this.player = n;
		this.score = s;
	}
	
	/**
        * Returns the player name.
        * @return The name of the player
        */
	public String getPlayer() {
		return player;
	}
	
	/**
 	* Sets the player name
 	* @param player The player name to set
 	*/
	public void setPlayer(String player) {
		this.player = player;
	}
	
	/**
 	* Returns the score.
 	* @return The score of the player
 	*/
	public int getScore() {
		return score;
	}
	
	/**
 	* Sets the score
 	* @param score The score to set
 	*/
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Compares the score of the current BestPlayer with another BestPlayer's score
	 * @param p The other BestPlayer we want to compare to.
	 * @return 0 if the scores are equals, -1 if the other player's score is better, 1 in any other case.
	 */
	public int compareTo(BestPlayer p){
		if (p.score > this.score)
			return -1;
		else if (p.score < this.score)
			return 1;
		return 0;
	}
	
	/**
	 * Sets the String version of a BestPlayer
	 */
	public String toString(){
		return this.getPlayer() + " : " + this.getScore();
	}
}
