package scores;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Comparator;

public class HighScore2 {
	public static String[] getScores() throws Exception{
		String[] scores = {};
		URL oracle = new URL("https://api.thingspeak.com/channels/109947/feeds.csv");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine = in.readLine();
        while ((inputLine = in.readLine()) != null && inputLine.length()>=1){
            scores = addElement(scores, inputLine.substring(inputLine.indexOf(",", inputLine.indexOf(",")+1)+1, inputLine.length()));
        }
        in.close();
		return scores;
	}
	
	static String[] addElement(String[] a, String e) {
		a  = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}
	
	static BestPlayer[] addElement(BestPlayer[] a, BestPlayer e) {
		a  = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}
	
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