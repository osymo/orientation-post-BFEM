package ClasseDeBase;

import java.util.Arrays;

import ClasseDeRequete.SurveillantStatement;

public class Eleve {
private int numeroTable;
private String prenom;
private String nom;
private double moyenneClasse;
private String dateNaissance;
private String lieuNaissance;
private String etablissement;
private char profil;
private Serie[] choix;

private String profil_eleve;
private String choix_eleve;

	public Eleve(int numeroTable, String prenom, String nom, double moyenneClasse, String dateNaissance,
		String lieuNaissance, String etablissement, char profil,Serie[] choix) {
	super();
	this.numeroTable = numeroTable;
	this.prenom = prenom;
	this.nom = nom;
	this.moyenneClasse = moyenneClasse;
	this.dateNaissance = dateNaissance;
	this.lieuNaissance = lieuNaissance;
	this.etablissement = etablissement;
	this.profil=profil;
	this.choix = choix;
}
	public Eleve(int numeroTable, String prenom, String nom, double moyenneClasse, String dateNaissance,
			String lieuNaissance, String etablissement, String profil_eleve,String choix_eleve) {
		super();
		this.numeroTable = numeroTable;
		this.prenom = prenom;
		this.nom = nom;
		this.moyenneClasse = moyenneClasse;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.etablissement = etablissement;
		this.profil_eleve=profil_eleve;
		this.choix_eleve = choix_eleve;
	}
	
	public String getProfil_eleve() {
		return profil_eleve;
	}
	public void setProfil_eleve(String profil_eleve) {
		this.profil_eleve = profil_eleve;
	}
	public String getChoix_eleve() {
		return choix_eleve;
	}
	public void setChoix_eleve(String choix_eleve) {
		this.choix_eleve = choix_eleve;
	}
	public int getNumeroTable() {
		return numeroTable;
	}

	public void setNumeroTable(int numeroTable) {
		this.numeroTable = numeroTable;
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

	public double getMoyenneClasse() {
		return moyenneClasse;
	}

	public void setMoyenneClasse(double moyenneClasse) {
		this.moyenneClasse = moyenneClasse;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public Serie[] getChoix() {
		return choix;
	}

	public void setChoix(Serie[] choix) {
		this.choix = choix;
	}

	public char getProfil() {
		return profil;
	}

	public void setProfil(char profil) {
		this.profil = profil;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Eleve [numeroTable=" + numeroTable + ", prenom=" + prenom + ", nom=" + nom + ", moyenneClasse="
				+ moyenneClasse + ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance
				+ ", etablissement=" + etablissement + ", choix="
				+ (choix != null ? Arrays.asList(choix).subList(0, Math.min(choix.length, maxLen)) : null) + "]";
	}

	public String  orienter(){
		Serie tempon;
			for(int i=0;i<3; i++){
				choix[i].setMc(choix[i].somDominante()+moyenneClasse);
				if(profil=='A')
					choix[i].setMc(choix[i].getMc()+2.5);
				else if (profil=='B')
					choix[i].setMc(choix[i].getMc()+1.25);
				else
					choix[i].setMc(choix[i].getMc()+0.75);
			}	
			for(int i=0; i< 2; i++){
				for(int j=i+1; j<3; j++){
					if(choix[i].getMc()<choix[j].getMc()){
						tempon=choix[i];
						choix[i]=choix[j];
						choix[j]=tempon;
					}
				}
			}
			//int k=0;
			//	while(k<3 && SurveillantStatement.getMaxPlace(choix[k])==false)
			//	k++;
			//if( k<3)
			//return choix[k].getSerie();
			//else
			//return "plein";
			if(SurveillantStatement.getMaxPlace(choix[0])==true)
				return choix[0].getSerie();
			else if(SurveillantStatement.getMaxPlace(choix[1])==true)
				return choix[1].getSerie();
			else if(SurveillantStatement.getMaxPlace(choix[2])==true)
				return choix[2].getSerie();
			else
				return "plein";
	}

/*	// <------------------------------------------Fonction main provisoir pour tester------------------------------------------->
public static void main(String[] args) {
	Serie[] tabTest=new Serie[3];
	tabTest[0]=new Serie(15, 15, "s");
	tabTest[1]=new Serie(12, 15, "t");
	tabTest[2]=new Serie(15, 17, "g");
	Eleve unEleve=new Eleve(12, "om", "dp", 15, "15, 25-04-02","touba", "école",'A', tabTest);
	
	System.out.println(unEleve.orienter());
	for(Serie uneSerie:tabTest)
		System.out.println("Moyenne choix Série "+uneSerie.getSerie()+" :" +uneSerie.getMc());
	
}*/
}
