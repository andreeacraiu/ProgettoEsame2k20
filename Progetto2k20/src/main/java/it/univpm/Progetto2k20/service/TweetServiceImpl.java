package it.univpm.Progetto2k20.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import it.univpm.Progetto2k20.utils.*;
import it.univpm.Progetto2k20.model.*;

/**
 * Classe che implementa i metodi dell'interfaccia TweetService
 * 
 * @see TweetService
 *
 */



@Service
public class TweetServiceImpl implements TweetService {

	private Map<String, Metadata> metadata = new HashMap<>();
	private Map<Long, Tweet> data=new HashMap<>();
	private Stat stat = UploadStat.getStat();

	
	public TweetServiceImpl() {
		try {
			ArrayList<Tweet> twe = JSONParse.parsaJson(JSONObject.downloadTweets());
			for (int i = 0; i < twe.size(); i++) {
				Tweet tw = twe.get(i);
				data.put((long) tw.getId(), tw);
			}
			
		
			ArrayList<Metadata> metadati = Metadati.getMetadata();
			for (int i = 0; i < metadati.size(); i++) {
				Metadata met = metadati.get(i);
				metadata.put ((String) met.getName(), met);
		
			} } catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	public Collection<Tweet> getTweets() {
		return data.values();
	}
	
	
	@Override
	public Collection<Metadata> getMetadata() {
		return metadata.values();
	}
	
    @Override
	public Stat getStat() {
		return stat;
	}
	
	
	
	
	
}

	
