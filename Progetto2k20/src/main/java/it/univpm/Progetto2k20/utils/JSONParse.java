package it.univpm.Progetto2k20.utils;


import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import it.univpm.Progetto2k20.model.*;

/**
 * Classe che esegue il parsing dei tweet
 * 
 * @see Parser
 * 
 */
public class JSONParse extends Parser
{
	public static ArrayList <Tweet> parsaJson(String data)
	{
		
			ArrayList <Tweet> result= new ArrayList <Tweet>();
			
			//JSONParser 
				JSONObject jobj = new JSONObject();
				try {
					jobj = parserJO(data);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	
			//JSON Array statuses
		JSONArray jsonarray= (JSONArray) jobj.get("statuses");
		
			//Get data 
			for(Object o : jsonarray)
			{  
				Tweet t1= new Tweet();
				
				
				  t1.setCreated_at((String) ((JSONObject) o).get("created_at"));
					t1.setId((Long) ((JSONObject) o).get("id"));
					t1.setText((String) ((JSONObject) o).get("text"));
   
				
           JSONObject j1 = new JSONObject();
	       j1 = (JSONObject) ((JSONObject) o).get("user");
	       if (j1 != null)
				{
					
	    	   String name = (String) ((JSONObject) j1).get("name");
				t1.setname(name);
				String screen = (String) ((JSONObject) j1).get("screen_name");
				t1.setScreen_name(screen);
				Long numpost = (Long) ((JSONObject) j1).get("listed_count");
				t1.setnumpost_user(numpost);
				String location = (String) ((JSONObject) j1).get("location");
				t1.setLocation_user(location);
				
				
				if (j1.get("location").equals("")) {
					t1.setLocation_user("Location Ignota");
					}
				else {t1.setLocation_user((String) j1.get("location"));
					}
				
				
				String id = (String) ((JSONObject) j1).get("id_str");
				t1.setId_user(id);
				
				
				

				}
	       JSONObject j2 = new JSONObject();
			j2 = (JSONObject) ((JSONObject) o).get("metadata");
			if (j2 != null) {
				 String language = (String) ((JSONObject) j2).get("iso_language_code");
					t1.setlanguage_post(language);
			}
			

			
			
	       
	       
	       
			result.add(t1);
			
			
		
		
	}return result;
	}
	
	
}
	
