package ClasseDeBase;

public class Serie {
private double dominante1;
private double dominante2;
private double mc;
private String serie;

public Serie(double dominante1, double dominante2,String serie) {
	super();
	this.dominante1 = dominante1;
	this.dominante2 = dominante2;
	this.serie = serie;
}
public double getDominante1() {
	return dominante1;
}
public void setDominante1(double dominante1) {
	this.dominante1 = dominante1;
}
public double getDominante2() {
	return dominante2;
}
public void setDominante2(double dominante2) {
	this.dominante2 = dominante2;
}
public String getSerie() {
	return serie;
}
public void setSerie(String serie) {
	this.serie = serie;
}
public double getMc() {
	return mc;
}
public void setMc(double mc) {
	this.mc = mc;
}
public double somDominante(){
	return dominante1+dominante2;
}



}
