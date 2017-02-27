package ClasseDeBase;

public class Surveillant extends Admin {
	private String phone;
	private String email;
	private String noss;
	private String etablissement ;
	
	public Surveillant(String prenom, String nom, String password, String login, String phone, String email,
			String noss,String etablissement) {
		super(prenom, nom, password, login);
		this.phone = phone;
		this.email = email;
		this.noss = noss;
		this.etablissement=etablissement;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNoss() {
		return noss;
	}

	public void setNoss(String noss) {
		this.noss = noss;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
}
