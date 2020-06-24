package it.univpm.Progetto2k20.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import it.univpm.Progetto2k20.model.*;
import it.univpm.Progetto2k20.utils.JSONDownloader;
import it.univpm.Progetto2k20.utils.JSONParse;


@Service
public class TweetServiceImpl implements TweetService {

	
	private Map<Long, Tweet> timeline=new HashMap<>();
	
	public TweetServiceImpl() {
		try {
			ArrayList<Tweet> twe= new ArrayList<Tweet>();
			twe = JSONParse.parsaJson(JSONDownloader.download());
			for (int i = 0; i < twe.size(); i++) {
				Tweet tw = twe.get(i);
				timeline.put((long) tw.getId(), tw);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Collection<Tweet> getTweet() {
		return timeline.values();
	}
}
	