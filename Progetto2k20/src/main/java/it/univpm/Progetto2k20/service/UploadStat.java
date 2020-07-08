package it.univpm.Progetto2k20.service;


import it.univpm.Progetto2k20.stats.Statistiche;
import it.univpm.Progetto2k20.utils.JSONObject;
import it.univpm.Progetto2k20.utils.JSONParse;

import it.univpm.Progetto2k20.model.*;

/**
 * Classe che carica il numero di tweet esteri
 * 
 */

public class UploadStat {
	
	static Stat stat = new Stat();
	
	


	public static Stat getStat() {
		stat.setUtentiEstero(Statistiche.contaUser(JSONParse.parsaJson(JSONObject.downloadTweets())));
		return stat;
	

}
	
	

}
