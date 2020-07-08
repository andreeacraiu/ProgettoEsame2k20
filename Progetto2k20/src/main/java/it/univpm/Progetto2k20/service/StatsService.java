package it.univpm.Progetto2k20.service;

import java.util.ArrayList;
import java.util.Arrays;

import it.univpm.Progetto2k20.model.*;

public class StatsService {

	/**
	 * Crea una collezione di attributi dei tweet in base al field
	 * 
	 * @param arraylist = ArrayList da esaminare
	 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
	 * @return collezione di string
	 */
	
	public ArrayList<String> str(ArrayList<Tweet> arraylist, String field) {
		ArrayList<String> arraystring = new ArrayList<String>();
		for (Tweet t : arraylist) {
			
			switch (field) {
			
			case "language_post":
				arraystring.add(t.getlanguage_post());
				break;
			case "location_user":
				arraystring.add(t.getlocation_user());
				break;
			default:
				return null;
			}
			

		}
		return arraystring;
	}
	
	
	/**
	 * Crea uno StringStat 
	 * in base al field passato dall'utente
	 * @param arraylist = ArrayList sul quale effettuare le statistiche
	 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
	 * @return le statistiche effettuate
	 */
	
	
	public static Stats getStats(ArrayList<Tweet> arraylist,String field){
			
			
			
			if (Arrays.asList("language_post","location_user").contains(field)) {
				StringStat stat = new StringStat(arraylist, field);
				return stat.getStat();

			}

			return null;
			
		
		}
	
	
	
}


