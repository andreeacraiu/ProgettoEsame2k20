package it.univpm.Progetto2k20.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;


public class Tweet {
	/**
	 * Parameters
	 * @param created_at
	 * @param id
	 * @param text
	 * @param language_post
	 * @param name
	 * @param screen_name
	 * @param id_user
	 * @param location_user
	 * @param numpost_user
	 */
	 
	@JsonPropertyDescription("Data di pubblicazione del tweet")
	private String created_at;
	
	@JsonPropertyDescription("Id del tweet")
	private long id;
	
	@JsonPropertyDescription ("Testo immagine")
	private String text;

	@JsonPropertyDescription("Lingua post")
	private String language_post;
	
	@JsonPropertyDescription("Nome utente")
	private String name;
	@JsonPropertyDescription("Nome utente")
	private String screen_name;
	
	@JsonPropertyDescription("Luogo dell'utente")
	private String location_user;
	
	@JsonPropertyDescription("Id utente")
	private String id_user;
	
	@JsonPropertyDescription("Numero di post pubblicati dallo user")
	private long numpost_user;
	 
	
	/**
	 * Constructor
	 * @param created_at
	 * @param id
	 * @param text
	 * @param screen_name
	 * @param name
	 * @param location_user
	 * @param id_user
	 * @param language_post
	 * @param numpost_user
	 */
	
	public Tweet(String created_at, long id, String text,String name, String screen_name, String location_user,
			String id_user,String language_post,long numpost_user) {
		super();
		this.created_at = created_at;
		this.id = id;
		this.text = text;
		this.name=name;
		this.screen_name = screen_name;
		this.location_user = location_user;
		this.id_user = id_user;
		this.language_post= language_post;
		this.numpost_user=numpost_user;
		
	}
	


	/**
	 * Constructor without parameters
	 */
	public Tweet() {
	}
	
	

		/**
	 * Constructor without parameters
	 */
	public Tweet() {
	}
	
	

	/**
	 * Getters
	 */
	public String getCreated_at() {
		return created_at;
	}
	public String getname() {
		return name;
	}
	
    public String getScreen_name() {
		return screen_name;
	}
	public long getId() {
		return id;
	}

	
	public Object getText() {
		return text;
	}
	
	
	public String getlanguage_post() {
		return language_post;
	}
	
	public String getid_user() {
		return id_user;
	}
	
	public String getlocation_user() {
		return location_user;
	}
	
	public long getnumpost_user() {
		return numpost_user;
	}
	
	
	/**
	 * Setters
	 */
	
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public void setname(String name) {
		this.name = name;
	}

 
  public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
  
  public void setlanguage_post(String language_post) {
		this.language_post = language_post;
	}



	public void setLocation_user(String location_user) {
		this.location_user = location_user;
	}



	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	
	public void setnumpost_user(long numpost_user) {
		this.numpost_user = numpost_user;
	}
	
	
	
	
}
	

