package it.univpm.Progetto2k20.utils;


import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import it.univpm.Progetto2k20.model.*;


/**
 * Classe che permette di trasformare il JSON scaricato in un oggetto di tipo
 * Tweet
 * 
 * @see Tweet
 */
public class JSONParse {
	
	
	/**
	 * Metodo che parsa il JSON in un oggetto di tipo Tweet
	 * 
	 * @see Tweet
	 * @param jsonArray JSON array da parsare
	 * @return un Array di oggetti di tipo Tweet
	 */
	

      public static ArrayList<Tweet> parsaJson(JSONArray json) {

		ArrayList<Tweet> result = new ArrayList<Tweet>();

		for (int i = 0; i < json.size(); i++) {
			Tweet t1= new Tweet();
			    
			    JSONObject tweet = (JSONObject) json.get(i);
			    t1.setCreated_at((String) tweet.get("created_at"));
				t1.setId((long) tweet.get("id"));
				t1.setText((String) tweet.get("text"));
				t1.setlanguage_post((String) tweet.get("iso_language_code"));
				
				
				JSONObject tweet3 = (JSONObject) tweet.get("user");
				t1.setScreen_name((String) tweet3.get("screen_name"));
				t1.setId_user((String) tweet3.get("id_str"));
				t1.setLocation_user((String) tweet3.get("location"));
				
				
				result.add(t1);
		}

		return result;
	}
	
	
}
