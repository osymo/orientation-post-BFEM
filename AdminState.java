package ClasseGraphique;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import ClasseDeRequete.AdminStatement;
import ClasseDeRequete.SurveillantStatement;

public class AdminState extends JFrame{

	private Container conteneur;
	private JPanel panel1;

		public AdminState(){
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
			conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre d'élèves Total</span>:<span style='color:orange;font-size:1.3em;'>"+AdminStatement.studentCount()+"</span></html>"));
			conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre de Surveillant total</span>:<span style='color:orange;font-size:1.3em;'>"+AdminStatement.surveillantCount()+"</span></html>"));
			conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre d'éleves en serie S</span>:<span style='color:orange;font-size:1.3em;'>"+AdminStatement.studentCount("s")+"</span></html>"));
			conteneur.add(new JLabel("<html><span style='font-size:1.3em;'>Nombre d'élèves en série G</span>:<span style='color:orange;font-size:1.3em;'>"+AdminStatement.studentCount("g")+"</span></html>"));		
			conteneur.add(new JLabel("<html><u style='font-size:1.3em;'> Nombre d'élèves en série T:</u>:<span style='color:orange;font-size:1.3em;'>"+AdminStatement.studentCount("t")+"</span></html>"));		
			conteneur.add(new JLabel("<html><u style='font-size:1.3em;'>Nombre d'élèves en série L :</u>:<span style='color:orange;font-size:1.3em;'>"+AdminStatement.studentCount("l")+"</span></html>"));		

			conteneur.setBackground(Color.white);
		}
}
