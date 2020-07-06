package it.univpm.Progetto2k20.controller;


import java.util.ArrayList;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.univpm.Progetto2k20.service.StatsService;
import it.univpm.Progetto2k20.service.TweetService;
import it.univpm.Progetto2k20.utils.*;
import it.univpm.Progetto2k20.model.*;
import it.univpm.Progetto2k20.stats.*;

/**
 * Classe che garantisce la gestione di tutte le chiamate al Server permesse al
 * Client
 *
 */
@RestController
public class Controller {
	
	private Stats map=new Stats();
	@Autowired
	private TweetService tweet;

	
	/**
	 * Rotta che mostra tutti i tweet presenti nel JSON scaricato
	 * 
	 * @return tweet scaricati in formato JSON
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweets() {
		
		return new ResponseEntity<>(tweet.getTweet(), HttpStatus.OK);
	}

	/**
	 * Rotta che mostra i metadati relativi ad ogni tweet presente nella timeline
	 * 
	 * @return  metadati sotto forma di JSON
	 */
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		return new ResponseEntity<>(tweet.getMetadata(), HttpStatus.OK);
	}
	
	/**
	 * Rotta che mostra il numero di post esteri (lingua del post diversa da "it")
	 * 
	 * 
	 * @return  numero di post sotto forma di JSON
	 */
	
	@RequestMapping(value = "/stat", method = RequestMethod.GET)
	public ResponseEntity<Object> getStats() {
		return new ResponseEntity<>(tweet.getStats(), HttpStatus.OK);
	}
	
	/**
	 * Effettuare statistiche sul campo field
	 * 
	 * @param field = campo sul quale effettuare la statistica
	 * @return Statistiche se viene immesso un field esistente, altrimenti
	 * 	       compare un messaggio di errore
	 * @throws JSONException
	 */
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public ResponseEntity statistiche(@RequestParam(required = true) String field
			 ) throws JSONException {
		
		if (!field.isEmpty()) {
			map=StatsService.calculStat(JSONParse.parsaJson(JSONObject.downloadTweets()), field);
			if(map!=null)
				return new ResponseEntity<Stats>(map,HttpStatus.OK);
			}
		 if (field.isEmpty()) {
				
				
			
		     } return new ResponseEntity<String>("Field immesso inesistente", HttpStatus.BAD_REQUEST);
	}



/**
 * Rotta che permette di calcolare la frequenza dei tweet esteri per lingua
 * 
 * @param field = lingua del post inserita dall'utente
 * @return Restituisce la frequenza dei tweet esteri
 * @throws JSONException
 */
	
@RequestMapping(value = "/freq", method = RequestMethod.GET)
public ResponseEntity<ArrayList<Frequenze>> freq (@RequestParam(required = true) String field
		 ) throws JSONException{
	ArrayList<Frequenze> fre = new ArrayList<Frequenze>();
	if (!field.isEmpty()) {
	

	fre = Statistiche.frequenza_settimana(JSONParse.parsaJson(JSONObject.downloadTweets()));

	return new ResponseEntity<>(fre, HttpStatus.OK);
}
	if (field.isEmpty()) {
		
		
		
    }
	return new ResponseEntity<ArrayList<Frequenze>> (HttpStatus.BAD_REQUEST);
}

}
	
