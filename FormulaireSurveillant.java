package ClasseGraphique;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ClasseDeBase.Surveillant;
import ClasseDeRequete.AdminStatement;

@SuppressWarnings("serial")
public class FormulaireSurveillant extends JFrame implements ActionListener{
	private Font police;
	private JButton send;
	private JLabel indication;
	private Container conteneur;
	private JPanel panelTop,panelMiddle,panelBottom;
	private JTextField prenomField,nomField,loginField,phoneField,emailField,ecoleField,nossField;
	private JPasswordField passwordField;
	private Dimension screenSize;
	public FormulaireSurveillant(){
		
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
		catch (Exception e) {}
		
		this.setResizable(false);
		this.setSize(new Dimension(400,400));	
		this.setTitle("Ajout d'un nouvel établissement");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setIconImage(new ImageIcon("toolBarIconesAdmin/addSup.png").getImage());
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
		
		indication=new JLabel();
		police=new Font("Tahoma", Font.BOLD, 16);
		send=new JButton("valider");
		send.addActionListener(this);
		
		conteneur=this.getContentPane();
		panelTop=new JPanel();
		panelMiddle=new JPanel();
		panelBottom=new JPanel();
		
		prenomField=new JTextField();
		nomField=new JTextField();
		loginField=new JTextField();
		passwordField=new JPasswordField();
		phoneField=new JTextField();
		emailField=new JTextField();
		ecoleField=new JTextField();
		nossField=new JTextField();
		
		indication.setFont(police);
		indication.setForeground(Color.gray);
		indication.setText("Inscription d'un nouvel établissement");
		
		panelTop.add(indication);
		panelTop.add(new JLabel(new ImageIcon("toolBarIconesAdmin/addSup.png")));
		panelTop.setPreferredSize(new Dimension(this.getWidth(),60));
		
		panelMiddle.setLayout(new GridLayout(8,2));
		panelMiddle.add(new JLabel("Prénom"));
		panelMiddle.add(prenomField);
		panelMiddle.add(new JLabel("Nom"));
		panelMiddle.add(nomField);
		panelMiddle.add(new JLabel("Login"));
		panelMiddle.add(loginField);
		panelMiddle.add(new JLabel("Password"));
		panelMiddle.add(passwordField);
		panelMiddle.add(new JLabel("N ° CNI"));
		panelMiddle.add(nossField);
		panelMiddle.add(new JLabel("Téléphone"));
		panelMiddle.add(phoneField);
		panelMiddle.add(new JLabel("E-mail"));
		panelMiddle.add(emailField);
		panelMiddle.add(new JLabel("Etablissement"));
		panelMiddle.add(ecoleField);
		panelMiddle.setBackground(new Color(238,238,238));
		panelMiddle.setPreferredSize(new Dimension(300,195));
		
		panelBottom.add(send);
		//panelBottom.setBackground(new Color(238,238,238));
		panelBottom.setPreferredSize(new Dimension(300,35));
	
		conteneur.setLayout(new FlowLayout());
		conteneur.add(panelTop);
		conteneur.add(panelMiddle);
		conteneur.add(panelBottom);
		conteneur.setBackground(new Color(238,238,238));
		this.setVisible(true);	
		
		prenomField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e){
				boolean b=false;
				String str=prenomField.getText(),baseDecimal="abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				for(int i=0; i< str.length();i++){
					if(baseDecimal.indexOf(str.charAt(i))==-1)
						b=true;
				}
				if(b==true) prenomField.setForeground(Color.red);
				else prenomField.setForeground(Color.green);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {}
			@Override
			public void insertUpdate(DocumentEvent e) {
				String str=prenomField.getText(),baseDecimal="abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if(baseDecimal.indexOf( str.charAt(str.length()-1))==-1)
					prenomField.setForeground(Color.red);
			}
		});
		
		nomField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e){
				boolean b=false;
				String str=nomField.getText(),baseDecimal="abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				for(int i=0; i< str.length();i++){
					if(baseDecimal.indexOf(str.charAt(i))==-1)
						b=true;
				}
				if(b==true) nomField.setForeground(Color.red);
				else nomField.setForeground(Color.green);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {}
			@Override
			public void insertUpdate(DocumentEvent e) {
				String str=nomField.getText(),baseDecimal="abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if(baseDecimal.indexOf( str.charAt(str.length()-1))==-1)
					nomField.setForeground(Color.red);
			}
		});
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated( true );
		JDialog.setDefaultLookAndFeelDecorated( true );
	new FormulaireSurveillant().setVisible(true);

	}
	private boolean testeurAlaphabétique(String str){
		boolean b=true;
		String dico="abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<str.length();i++){
			if(dico.indexOf(str.charAt(i))==-1)
				b=false;
		}
		return b;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent action) {
	if(action.getSource()==send){

		String pnom,nom,mail,phone,login,ets,noss,pwd;
		pnom=prenomField.getText();
		nom=nomField.getText();
		mail=emailField.getText();
		login=loginField.getText();
		pwd=passwordField.getText();
		phone=phoneField.getText();
		ets=ecoleField.getText();
		noss=nossField.getText();
		
		if(pnom.length() >0 && nom.length()>0 &&  mail.length()>0 && login.length()>0 &&
				pwd.length() >0 	&& phone.length() > 0 && ets.length()>0 && noss.length()>0){
			
			if(testeurAlaphabétique(pnom) && testeurAlaphabétique(nom)){
				
				if(Pattern.matches("77[0-9]{7}|76[0-9]{7}|78[0-9]{7}|70[0-9]{7}", phone)){
				
						if(Pattern.matches("1[0-9]{12}|2[0-9]{12}", noss)){
							if(AdminStatement.addSurveillant(new Surveillant(pnom, nom, pwd, login, phone, mail, noss, ets))==true)
								 JOptionPane.showMessageDialog(FormulaireSurveillant.this, "Enregistrement réussi ", "Succès !", JOptionPane.INFORMATION_MESSAGE);
							else
								 JOptionPane.showMessageDialog(FormulaireSurveillant.this, "Le numero de carte d'identité existe déja", "Erreur !", JOptionPane.ERROR_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(FormulaireSurveillant.this, "Le format  du numero de carte d'identité est incorrect", "Erreur !", JOptionPane.ERROR_MESSAGE);
						}
				}
				else{
					JOptionPane.showMessageDialog(this, "le format du numéro de téléphone est incorrect !!", "Alerte", JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "le nom et le prénom doivent être formés de lettres !!", "Alerte", JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "veuillez remplir tous les chmaps !!", "Alerte", JOptionPane.WARNING_MESSAGE);
		}	
	}	
	}
}
