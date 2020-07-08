package it.univpm.Progetto2k20.model;

/** 
 * Classe che modella un metadato 
 * @param name = nome assegnato
 * @param sorceField = descrizione 
 * @param type = tipo di dato
 * 
 */

public class Metadata {
	private String name; 
	private String sourceField; 
	private String type; 
	
	
	/** 
	 * Costruttore
	 * 
	 */

	public Metadata(String name, String sourceField, String type) {
		this.name = name;
		this.sourceField = sourceField;
		this.type = type;
	}
	
	/** 
	 * Getters e setters
	 * 
         */

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	
	
	

}
