package scores;

public class BestPlayer {
	private String player;
	private int score;
	
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