package it.univpm.Progetto2k20.model;

/**
 * Classe che contiene una mappa
 *
 */
import java.util.Map;

public class Stats {
	
	

	
private Map<String, Object> Result;
	
	public Stats(Map<String, Object> map) {
		this.setResult(map);
		
	}
	
	public Stats() {
	}

	public Map<String, Object> getResult() {
		return Result;
	}

	public void setResult(Map<String, Object> r) {
		Result = r;
	}

	
	
	

}
