package kunal.sjsu.fetcher;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Populate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String urltext = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.sectors&format=json&env=http%3A%2F%2Fdatatables.org%2Falltables.env&callback=cbfunc";
			URL url = new URL(urltext);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url
					.openStream()));
			String inputLine;
			// Process each line.
			while((inputLine = in.readLine())!=null){}
			//System.out.println(in.readLine());
			//in.close();		
			
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
		    ByteArrayOutputStream buf = new ByteArrayOutputStream();
		    int result = bis.read();
		    while(result != -1) {
		      byte b = (byte)result;
		      buf.write(b);
		      result = bis.read();
		      
		    } 
		    System.out.println(buf);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
