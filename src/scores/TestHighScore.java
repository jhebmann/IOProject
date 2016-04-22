package scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TestHighScore {

	public static void main(String[] args) {
		System.out.println("Step 1\n");
		//Step 1-1
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your name please :");
		String name = "";
		name = keyboard.nextLine();
		keyboard.close();
		
		//Step 1-2
		File file = new File("lib/scoreSamples.txt");
		int ligne = ThreadLocalRandom.current().nextInt(1, 11);
		int result = 0;
		try {
			Scanner score = new Scanner(file);
			for (int i = 0 ; i< ligne ; i++)
				result = score.nextInt();
			System.out.println("Your score is : " + result);
			score.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			System.out.println("Your name is : "+name);
		}
		
		System.out.println("All scores are : ");
		try{
			String[] scores = HighScore1.getScores();
			for (int i = 0 ; i< scores.length ; i++)
				System.out.println(scores[i]);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println("\n\nStep 2\n");
		
		//Step 2
		System.out.println("Best scores are :");
		String[] scores = {};
		BestPlayer[] top10 = {};
		try{
			scores = HighScore2.getScores();
			top10 = HighScore2.tenBestScores(scores);
			for (int i = 0 ; i < top10.length ; i++)
				System.out.println("Score of "+top10[i].getPlayer()+" : "+top10[i].getScore());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println("\n\nStep 3\n");
		
		//Step 3
		if (top10.length < 10 || result > top10[9].getScore()){
			System.out.println("Your score was among the 10 best ! Congratulations !");
			try{
				HighScore3.sendScore(new BestPlayer(name, result));
				System.out.println("The 10 best scores now are :");
				try{
					scores = HighScore3.getScores();
					top10 = HighScore3.tenBestScores(scores);
					for (int i = 0 ; i < top10.length ; i++)
						System.out.println("Score of "+top10[i].getPlayer()+" : "+top10[i].getScore());
				}catch(Exception e){
					e.printStackTrace();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Your score wasn't among the 10 best ! Try again !");
		}
	}
}
