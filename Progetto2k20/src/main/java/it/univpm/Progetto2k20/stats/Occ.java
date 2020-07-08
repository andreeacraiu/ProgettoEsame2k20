package it.univpm.Progetto2k20.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import it.univpm.Progetto2k20.model.*;
import it.univpm.Progetto2k20.service.StatsService;

/**
 * Trova le occorrenze di ogni elemento su una collezione di stringhe
 * 
 * @param arraylist = ArrayList da esaminare
 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
 * @return map = mappa(campo-valore) contente le occorrenze
 * 
 *
 */

public class Occ {
	public Map<String, Object> occurrence(ArrayList<Tweet> arraylist, String field) throws JSONException {

		ArrayList<String> str = new StatsService().str(arraylist, field);
		Map<String, Object> map = new HashMap<String, Object>();

		int occ = 0;
		String s = null;
		ArrayList<String> temp = new ArrayList<String>();
		temp.addAll(str);

		for (int i = 0; i < arraylist.size(); i++) {

			occ = 0;

			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).equals(str.get(i)) && !str.get(i).isEmpty()) {
					occ++;
					s = temp.get(j);
					temp.remove(j);
					j--;
					map.put(s, occ);
				}
			}
		}
		return map;
	}
}
