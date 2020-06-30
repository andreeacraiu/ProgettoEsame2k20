package it.univpm.Progetto2k20.utils;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JSONObject {
	
	public static String downloadTweets() {


		String data = "";
		try
		{
			URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=destinazionemarche&count=100");
			//Parse URL per ottenere il JSON data
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//Richiesta get
			conn.setRequestMethod("GET");
			//Aprire la connnessione
			conn.connect();
			//Ottenere la riposta dello status della Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			
			//Se la risposta non è 200, throw runtimeException
			//altrimenti continuare
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner per la lettura del JSON
				Scanner s = new Scanner(url.openStream());
				while(s.hasNext())
				{
					data+=s.nextLine();
				}
				
				System.out.println("\nJSON Response in String format"); 
				System.out.println(data);
				//Chiusura dello stream di data
				s.close();
				//Chiudere la connessione
			}conn.disconnect();
	}catch(Exception e)
		{
		e.printStackTrace();
	}return data;


}
}
