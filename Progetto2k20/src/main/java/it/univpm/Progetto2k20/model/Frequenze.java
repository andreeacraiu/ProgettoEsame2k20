package it.univpm.Progetto2k20.model;


/**
 * Classe che modella le frequenze
 *
 */
public class Frequenze {
	int numpost = 0;  
	String giorno;  
	

	/**
	 * Costruttore 
	 * 
	 * @param numpost
	 * @param giorno
	 */
	public Frequenze(int numpost, String giorno) {
		super();
		this.numpost = numpost;
		this.giorno = giorno;
	}

	/**
	 * Costruttore senza parametri
	 */
	public Frequenze() {
		super();
	}

	/**
	 * Getters
	 */
	public int getNumpost() {
		return numpost;
	}
	
    public String getGiorno() {
		return giorno;
	}
	/**
	 * Setters
	 */
	public void setNumpost(int numpost) {
		this.numpost = numpost;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public void incrementaNpost() {
		numpost++;
		return;		
	}


}
