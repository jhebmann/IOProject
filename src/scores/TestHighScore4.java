package scores;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *	A class which run tests on the fourth step
 * 
 * @author birzaneanu, hebmann
 */
public class TestHighScore4 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your name please :");
		String name = "";
		name = keyboard.nextLine();

		boolean stop = false;
		String[] scores = {};
		BestPlayer[] top10 = {};

		do {
			//First thing in loop : we get online scores
			System.out.println("Best scores are :");
			try {
				scores = HighScore2.getScores();
				top10 = HighScore2.tenBestScores(scores);
				for (int i = 0; i < top10.length; i++)
					System.out.println("Score of " + top10[i].getPlayer() + " : " + top10[i].getScore());
			} catch (Exception e) {
				e.printStackTrace();
			}

			//Then, we ask if the player wanna start/restart
			System.out.println("Do you want to (re)start ? (Y/N)");
			String restart = "";
			restart = keyboard.nextLine();
			if (restart.toUpperCase().equals("N")){
				stop = true;
			}

			if (!stop){
				//If he restarts, we get a random score from the file
				File file = new File("lib/scoreSamples.txt");
				int ligne = ThreadLocalRandom.current().nextInt(1, 11);
				int result = 0;
				try {
					Scanner score = new Scanner(file);
					for (int i = 0; i < ligne; i++)
						result = score.nextInt();
					System.out.println("Your score is : " + result);
					score.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (top10.length < 10 || result > top10[9].getScore()) {
					//If the score is among the 10 best scores, we send it online
					System.out.println("Your score was among the 10 best ! Congratulations !");
					try {
						HighScore3.sendScore(new BestPlayer(name, result));
						System.out.println("The 10 best scores now are :");
						try {
							scores = HighScore3.getScores();
							top10 = HighScore3.tenBestScores(scores);
							for (int i = 0; i < top10.length; i++)
								System.out.println("Score of " + top10[i].getPlayer() + " : " + top10[i].getScore());
							System.out.println();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Your score wasn't among the 10 best ! Try again !");
				}
			}
		} while (!stop);
		keyboard.close();
	}
}