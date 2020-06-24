package it.univpm.Progetto2k20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.Progetto2k20.service.TweetService;


@RestController

public class Controller {

	
	@Autowired
	TweetService tweet;

	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweet() {
		return new ResponseEntity<>(tweet.getTweet(), HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/stat", method = RequestMethod.GET)
	public ResponseEntity<Object> getStats() {
		return new ResponseEntity<>(tweet.getStats(), HttpStatus.OK);
	}*/

	

    


}

