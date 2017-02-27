package ClasseGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import ClasseDeRequete.SurveillantStatement;

public class Statistiques extends JFrame {
private Container conteneur;
private JPanel panel1;

	public Statistiques(String etablissement){
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");} 
		catch (Exception e) {}
		this.setSize(new Dimension(400,500));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Quelques éléments statistiques");
		conteneur=this.getContentPane();
		this.setResizable(false);
		this.setIconImage(new ImageIcon("icones/state.png").getImage());
		
		panel1=new JPanel();
		panel1.setBackground(new Color(250,250,250));
		panel1.setPreferredSize(new Dimension(400,105));
		panel1.add(new JLabel(new ImageIcon("icones/state2.png")));
		conteneur.setLayout(new FlowLayout());
		conteneur.add(panel1);
		conteneur.add(new JLabel("<html>----------------------------<u>Statistiques</u>---------------------------</html>"));
		conteneur.add(new JLabel("<html><span style='font-size:1.4em; font-weight:bold;'>Nombre total d'élèves du lycée</span></html>"));
		conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre d'élèves en série S</span>:<span style='color:rgb(28,164,217);font-size:1.3em;'>"+SurveillantStatement.numberOfStudent(etablissement, "s")+"</span></html>"));
		conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre d'élèves en série L</span>:<span style='color:rgb(28,164,217);font-size:1.3em;'>"+SurveillantStatement.numberOfStudent(etablissement, "l")+"</span></html>"));
		conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre d'élèves en série G</span>:<span style='color:rgb(28,164,217);font-size:1.3em;'>"+SurveillantStatement.numberOfStudent(etablissement, "g")+"</span></html>"));
		conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre d'élèves en série T</span>:<span style='color:rgb(28,164,217);font-size:1.3em;'>"+SurveillantStatement.numberOfStudent(etablissement, "t")+"</span></html>"));		
		conteneur.add(new JLabel("<html><u style='font-size:1.3em;'>Le nombre totale d'éléves est de :</u>:<span style='color:rgb(28,164,217);font-size:1.3em;'>"+SurveillantStatement.studentCount(etablissement)+"</span></html>"));		
		conteneur.setBackground(Color.white);
	}
	

}
