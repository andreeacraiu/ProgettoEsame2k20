package it.univpm.Progetto2k20.service;

import java.util.ArrayList;
import it.univpm.Progetto2k20.model.*;


/**
 * Classe che carica i metadati
 * 
 *  
 */
public class Metadati {

private static ArrayList<Metadata> metadata = new ArrayList<Metadata>();
	
	

	public static ArrayList<Metadata> getMetadata() {
		metadata.add(new Metadata("created_at","Data di creazione del tweet","String"));
		metadata.add(new Metadata("id","Descrive in modo univoco il post","long"));
		metadata.add(new Metadata("text","Campo testuale del post","String"));
		metadata.add(new Metadata("language_post","Lingua del post","String"));
		metadata.add(new Metadata("name","Nome dell'utente","String"));
		metadata.add(new Metadata("screen_name","Nome a schermo dell'utente","String"));
		metadata.add(new Metadata("id_user","Descrive in modo univoco l'utente","String"));
	    metadata.add(new Metadata("location_user","Luogo degli utenti","String"));
	    metadata.add(new Metadata("numpost_user","Numero totale di post dell'utente","long"));
		
		return metadata;
	}

}



