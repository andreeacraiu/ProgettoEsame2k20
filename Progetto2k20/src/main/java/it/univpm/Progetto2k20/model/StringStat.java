package it.univpm.Progetto2k20.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import it.univpm.Progetto2k20.stats.*;

/**
 * Classe che crea la mappa(campo-valore)
 * formata dalle statistiche contando le occorrenze 
 * sui campi di tipo String
 * 
 * @see Stats
 *
 */
public class StringStat extends  Stats{
	
	private Stats Ricerca;
	

	public StringStat(ArrayList<Tweet> vett, String field) throws JSONException
	{
		
		super();
		Map<String, Object> map = new HashMap<String, Object>();
		map = new Occ().occurrence(vett, field);
		
		Ricerca = new Stats(map);
	}

	public Stats getStat() {
		return Ricerca;
	}


}
