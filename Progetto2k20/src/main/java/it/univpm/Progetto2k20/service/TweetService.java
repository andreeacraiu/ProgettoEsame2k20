package it.univpm.Progetto2k20.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import it.univpm.Progetto2k20.model.*;

/**
 * Interfaccia che contiene i metodi che saranno implementati in
 * TweetServiceImpl
 * 
 * @see TweetServiceImpl
 *
 */

@Service
public interface TweetService {

	public abstract Stat getStat();

	public Collection <Tweet> getTweets();
	
	
	
	public abstract Collection<Metadata> getMetadata();
	
	
}


