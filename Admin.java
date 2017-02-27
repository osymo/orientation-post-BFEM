package ClasseDeBase;

public class Admin {
	private String prenom;
	private String nom;
	private String password;
	private String login;
	public Admin(String prenom, String nom, String password, String login) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.login = login;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	

}
