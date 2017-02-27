package ClasseGraphique;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import ClasseDeBase.Eleve;
import ClasseDeRequete.AdminStatement;
import ClasseDeRequete.SurveillantStatement;

@SuppressWarnings("serial")
public class Parameter extends JDialog{

	private JTextField noss,log,pass;
	private JButton valider;
	private JPanel panel;
	private Container conteneur;
	private Dimension screenSize;
	
	public Parameter(String n){
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");} 
		catch (Exception e) {}
		this.setTitle("Parametre de modification");
		this.setSize(390, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		conteneur=this.getContentPane();
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//this.setLocation(this.getWidth()/2-screenSize.width/2,this.getHeight()/2-screenSize.height/2);
		
		
		initComponent(n);
	}
	public  void initComponent(String p){
		panel = new JPanel(new GridLayout(3, 2));
		panel.setBackground(new Color(238,238,238));
		panel.setPreferredSize(new Dimension(365,70));
		noss=new JTextField(30);
		log=new JTextField(30);
		pass=new JTextField(30);
		valider=new JButton("soumettre");
		panel.add(new JLabel("numero CNI"));
		panel.add(noss);
		panel.add(new JLabel("nouveau login"));
		panel.add(log);
		panel.add(new JLabel("nouveau mot de pass"));
		panel.add(pass);
		conteneur.add(panel);
		conteneur.add(valider);
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nossAuthen=noss.getText();
				if(nossAuthen.equals(p)){
				AdminStatement.changeProfile(nossAuthen,log.getText(),pass.getText());
				}else{
					JOptionPane.showMessageDialog(null,"l'authentification n'as pas réussit:veuillez réessayer");
				}
				Parameter.this.dispose();
			}
		});
	}
	public static void main(String[] args) {
		new Parameter("lala").setVisible(true);
	}
}
