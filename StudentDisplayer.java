package ClasseGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import ClasseDeBase.Eleve;

@SuppressWarnings("serial")
public class StudentDisplayer  extends JFrame{
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9,panneau;
	private Container conteneur;
	private Dimension screenSize;

@SuppressWarnings("static-access")
public StudentDisplayer(Eleve student){

	try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");} 
	catch (Exception e) {}
	this.setResizable(false);
	this.setVisible(true);
	this.setSize(new Dimension(350,440));
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	this.setTitle("Dossier de l'élève  n° :"+student.getNumeroTable());
	this.setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
	this.setIconImage(new ImageIcon("icones/student.png").getImage());
	conteneur=this.getContentPane();

	panel1=new JPanel();
	panel2=new JPanel();
	panel3=new JPanel();
	panel4=new JPanel();
	panel5=new JPanel();
	panel6=new JPanel();
	panel7=new JPanel();
	panel8=new JPanel();
	panel9=new JPanel();
	panneau=new JPanel();
	
	@SuppressWarnings("unused")
	LineBorder lineBorder =new LineBorder(Color.white, 2, true);

	panneau.add(panel9);
	panneau.add(panel2);
	panneau.add(panel3);
	panneau.add(panel4);
	panneau.add(panel5);
	panneau.add(panel6);
	panneau.add(panel7);
	panneau.add(panel8);
	
	panel2.setBackground(new Color(238,238,238));
	panel3.setBackground(new Color(238,238,238));
	panel4.setBackground(new Color(238,238,238));
	panel5.setBackground(new Color(238,238,238));
	panel6.setBackground(new Color(238,238,238));
	panel7.setBackground(new Color(238,238,238));
	panel8.setBackground(new Color(238,238,238));
	panel9.setBackground(new Color(238,238,238));
	panneau.setBackground(new Color(238,238,238));
	
	panel1.setPreferredSize(new Dimension(350,50));
	panel2.setPreferredSize(new Dimension(350,30));
	panel3.setPreferredSize(new Dimension(350,30));
	panel4.setPreferredSize(new Dimension(350,30));
	panel5.setPreferredSize(new Dimension(350,30));
	panel6.setPreferredSize(new Dimension(350,30));
	panel7.setPreferredSize(new Dimension(350,30));
	panel8.setPreferredSize(new Dimension(350,30));
	panel9.setPreferredSize(new Dimension(350,30));
	//panneau.setPreferredSize(new Dimension(300,30));
	panel9.add(new JLabel("<html><u style='font-size:0.8em;font-weight:bold;'>DOSSIER DE L'ELEVE N° :"+student.getNumeroTable()+"</u></html>"));
	panel2.add(new JLabel("<html><span style='font-size:1.2em;font-weight:bold;'>Nom :</span> <span style='font-size:1.2em;font-weight:bold;color:rgb(28,164,217);'>"+student.getNom()+"</span></html>"));
	panel3.add(new JLabel("<html><span style='font-size:1.2em;font-weight:bold;'>Prénom  :</span> <span style='font-size:1.2em;font-weight:bold;color:rgb(28,164,217);'>"+student.getPrenom()+"</span></html>"));
	panel4.add(new JLabel("<html><span style='font-size:1.2em;font-weight:bold;'>Date Naissance :</span> <span style='font-size:1.2em;font-weight:bold;color:rgb(28,164,217);'>"+student.getDateNaissance()+"</span></html>"));
	panel5.add(new JLabel("<html><span style='font-size:1.2em;font-weight:bold;'>Lieu Naissance :</span> <span style='font-size:1.2em;font-weight:bold;color:rgb(28,164,217);'>"+student.getLieuNaissance()+"</span></html>"));
	panel6.add(new JLabel("<html><span style='font-size:1.2em;font-weight:bold;'>Orienté en Série :</span> <span style='font-size:1.2em;font-weight:bold;color:rgb(28,164,217);'>"+student.getChoix_eleve()+"</span></html>"));
	panel7.add(new JLabel("<html><span style='font-size:1.2em;font-weight:bold;'>Passage en Seconde : </span> <span style='font-size:1.2em;font-weight:bold;color:rgb(28,164,217);'>"+student.getProfil_eleve()+"</span></html>"));
	panel8.add(new JLabel("<html><span style='font-size:1.2em;font-weight:bold;'>Moyenne Générale :</span> <span style='font-size:1.2em;font-weight:bold;color:rgb(28,164,217);'>"+student.getMoyenneClasse()+"</span></html>"));
	
	
	conteneur.add(new JLabel(new ImageIcon("icones/student.png")),new BorderLayout().NORTH);
	conteneur.add(panneau, new BorderLayout().CENTER);
	conteneur.add(panel1, new BorderLayout().SOUTH);
}
	/*public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated( true );
		JDialog.setDefaultLookAndFeelDecorated( true );
		Eleve stud=new Eleve(145, "omar", "diop", 17, "29-10-93", "mbacké","école", "d'office", "Série S");
		new StudentDisplayer(stud).setVisible(true);
	}*/
}