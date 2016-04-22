package scores;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class HighScore1 {
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
	
	static String[] addElement(String[] a, String e) {
		a  = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}
}