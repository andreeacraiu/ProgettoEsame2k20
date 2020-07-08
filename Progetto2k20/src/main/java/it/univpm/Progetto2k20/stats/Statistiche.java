package it.univpm.Progetto2k20.stats;


import java.util.ArrayList;

import it.univpm.Progetto2k20.model.*;

public class Statistiche {
	
	/**
	 * Metodo che calcola la frequenza settimanale del numero di tweet esteri
	 * @see Frequenze
	 * @param tweet = ArrayList contenente i tweet da analizzare
	 * @return array list delle frequenze
	 */
	public static ArrayList<Frequenze> frequenza_settimana(ArrayList<Tweet> tweet) {
		ArrayList<Frequenze> arrayfr = new ArrayList<Frequenze>();
		
		String [] giorni=new String[] {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
		
		for(int i=0;i<giorni.length;i++) {
			Frequenze f =new Frequenze();
			f.setGiorno(giorni[i]);
			arrayfr.add(f);
		}
		
		for(int i=0;i<arrayfr.size();i++) {
			int k=0;
			
				for (Tweet t : tweet) {
					String giorno=t.getCreated_at().substring(0,3);
					String g=arrayfr.get(i).getGiorno();
						if (g.equals(giorno))
							k++;
					}arrayfr.get(i).setNumpost(k);
			}
		
		return arrayfr;
		
	
	}
		
	/**
	 * Metodo che conta i tweet da utenti stranieri per lingua
	 * 
	 * @param arraylist = ArrayList contenente i tweet da analizzare
	 * @return numero di tweet totali 
	 */
	public static int contaUser(ArrayList<Tweet> arraylist) {
		int c=0;
		for (Tweet t : arraylist) {
			if (!t.getlanguage_post().equals("it")) {
				c++;
			}
		}
		return c;
	}



	
}
	
	
    



