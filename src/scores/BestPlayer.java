package scores;

public class BestPlayer {
	private String player;
	private int score;
	
	/**
	 * Constructs a best player from a score and its nickname.
	 * @param player The nickname you want to give to the player
	 * @param score The score you want to give to the player
	 */
	public BestPlayer(String n, int s){
		this.player = n;
		this.score = s;
	}
	
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Compares the score of the current BestPlayer with another BestPlayer's score
	 * @param p The other BestPlayer we want to compare to.
	 * @return 0 if the scores are equals. -1 if the other player's score is better. 1 in any other case.
	 */
	public int compareTo(BestPlayer p){
		if (p.score > this.score)
			return -1;
		else if (p.score < this.score)
			return 1;
		return 0;
	}
	
	public String toString(){
		return this.getPlayer() + " : " + this.getScore();
	}
}
