package scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TestHighScore {

	public static void main(String[] args) {
		//Etape 1-1
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your name please :");
		String name = "";
		name = keyboard.nextLine();
		keyboard.close();
		
		//Etape 1-2
		File file = new File("lib/scoreSamples.txt");
		int ligne = ThreadLocalRandom.current().nextInt(1, 11);
		try {
			Scanner score = new Scanner(file);
			String result = "";
			for (int i = 0 ; i< ligne ; i++)
				result = score.nextLine();
			System.out.println("Your score is : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			System.out.println("Your name is : "+name);
		}
		
		
		System.out.println("Best scores are : ");
		try{
			String[] scores = HighScore1.getScores();
			for (int i = 0 ; i< scores.length ; i++)
				System.out.println(scores[i]);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
