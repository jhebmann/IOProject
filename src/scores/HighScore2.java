package scores;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * A class which represents a highscore (Step 2)
 * 
 * @author  birzaneanu, hebmann
 */
public class HighScore2 {
	/**
	 * Gets scores from ThingSpeak
	 * @return All scores stored online
	 * @throws Exception If there are connection problems
	 */
	public static String[] getScores() throws Exception{
		String[] scores = {};
		URL url = new URL("https://api.thingspeak.com/channels/109947/feeds.csv");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine = in.readLine();
        while ((inputLine = in.readLine()) != null && inputLine.length()>=1){
            scores = addElement(scores, inputLine.substring(inputLine.indexOf(",", inputLine.indexOf(",")+1)+1, inputLine.length()));
        }
        in.close();
		return scores;
	}
	
	/**
	 * Adds a String to a String Array
	 * @param a The String Array in which the String will be added
	 * @param e The String that will be added in the Array
	 * @return a The new Array
	 */	
	private static String[] addElement(String[] a, String e) {
		a  = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}

	/**
	 * Adds a BestPlayer to a BestPlayer Array
	 * @param a The BestPlayer Array in which the BestPlayer will be added
	 * @param e The BestPlayer that will be added in the BestPlayer Array
	 * @return a The new BestPlayer Array
	 */
	private static BestPlayer[] addElement(BestPlayer[] a, BestPlayer e) {
		a  = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}
	
	/**
	 * Get the 10 best scores from all scores
	 * @param readScores The scores read online
	 * @return The 10 best scores or all scores if there are less than 10 of them
	 */
	public static BestPlayer[] tenBestScores(String[] readScores){
		BestPlayer[] allBest = {};
		for (int i = 0 ; i< readScores.length ; i++){
			allBest = addElement(allBest, new BestPlayer(readScores[i].substring(readScores[i].indexOf(",")+1),Integer.parseInt(readScores[i].substring(0, readScores[i].indexOf(",")))));
		}
		
		Arrays.sort(allBest, new Comparator<BestPlayer>() {
	        public int compare(BestPlayer b1, BestPlayer b2) {
	        	return b2.compareTo(b1);
	        }
	    });
	    if (allBest.length>10){
	    	BestPlayer[] top10 = new BestPlayer[10];
	    	for (int i = 0 ; i < 10 ; i++)
	    		top10[i] = allBest[i];
	    	return top10;
	    }
		return allBest;
	}
}