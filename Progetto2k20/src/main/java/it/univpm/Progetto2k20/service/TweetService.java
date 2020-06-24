package it.univpm.Progetto2k20.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import it.univpm.Progetto2k20.model.*;

@Service
public interface TweetService {

	//public abstract Stat getStats();
	public Collection<Tweet> getTweet();
}

