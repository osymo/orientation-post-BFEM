package ClasseGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import ClasseDeBase.Eleve;
import ClasseDeBase.Surveillant;
import ClasseDeRequete.AdminStatement;
import ClasseDeRequete.ConnectionStatement;
import ClasseDeRequete.SurveillantStatement;
import ClasseDeRequete.SurveillantStatement.AllData;

@SuppressWarnings("serial")
public class ConnexionPage extends JFrame implements ActionListener{
	private JPanel homePanel;
	
/*<----------------------@#                     Omar
  							**********SidyMoctarDiop*****************
  				*************Troisème année informatique***************	
  		***************Université de thès, galsen,sénégal****************
 *****************Projet final Java Swing,28 juin 2016**************************/
	@SuppressWarnings("unused")
	private int whoIsOnline=0;
	private Dimension screenSize;
	private JButton connexion,goToAdminButton;
	private JSplitPane split1,split2;
	private JPanel centralPanel1,centralPanel2,centralPanel3,centralPanel3Panel,JTableTitlePanel;
	private JPanel middlePanel,panelTop,panelBottom,panelButton,goToAdminPanel,anonymousPanel;
	private JLabel centralPanel1Label,centralPanel3PanelLabel1,centralPanel3PanelLabel2,centralPanel3PanelLabel3,centralPanel1Label2;
	private JLabel  loginSupervisorLabel,passwordSupervisorLabel,iconeSupervisor,indications,mesInformations,JTableTitleLabel;
	private JTextField loginSupervisorField;
	private JPasswordField passwordSupervisorField;
	private Container conteneur;
	private JToolBar toolBar,toolBarAdmin;
	private Surveillant surveillant;
	private JTable tab;
	private Date today;
	private SimpleDateFormat formater;
	private JButton add,del,edit,find,about,state,params,deconnect;
	@SuppressWarnings("unused")
	private JButton addSup,delSup,editSup,findSup,aboutSup,stateSup,paramsSup,deconnectSup;

	
	public ConnexionPage(){
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");} 
		catch (Exception e) {}
		this.setTitle("Page de connexion");
		this.setSize(1100, 700);
		this.setResizable(false);
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setIconImage(new ImageIcon("icones/home1.png").getImage());
		conteneur=this.getContentPane();
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				frameClosingHandler();
				}
		});
		/* ----------------------------gestions de la date d'aujourd'hui------------------------------------*/
		today=new Date();
		formater=new SimpleDateFormat("EEEE, d MMM yyyy");
		
		/*<----------------------------------------------Panel d'accueil de l'application : page de connexion des surveillants--------------------------------------------------->*/
		connexion=new JButton(new ImageIcon("icones/btnconnexion.jpg"));
		connexion.setForeground(new Color(28,164,217));
		connexion.setFont(new Font("Tahoma", Font.BOLD, 13));
		connexion.addActionListener(this);
	
		
		indications=new JLabel("Interface de connexion des surveillants");
		indications.setFont(new Font("Tahoma", Font.BOLD, 22));
		indications.setForeground(new Color(28,164,217));
		
		@SuppressWarnings("unused")
		LineBorder lineBorder =new LineBorder(Color.white, 2, true);
		
		loginSupervisorLabel=new JLabel("Login du surveillant");
		loginSupervisorLabel.setFont(new Font("Arial", Font.BOLD, 12));
		loginSupervisorLabel.setForeground(new Color(28,164,217));
		passwordSupervisorLabel=new JLabel("Password du surveillant");
		passwordSupervisorLabel.setFont(new Font("Arial", Font.BOLD, 12));
		passwordSupervisorLabel.setForeground(new Color(28,164,217));
		loginSupervisorField=new JTextField();
		//loginAdminField.setBorder(lineBorder);
		passwordSupervisorField=new JPasswordField();
		//passwordAdminField.setBorder(lineBorder);
		
		
		goToAdminButton=new JButton(new ImageIcon("icones/tn_admin.png"));
		goToAdminButton.setPreferredSize(new Dimension(30,30));
		goToAdminButton.addActionListener(this);
		goToAdminButton.setToolTipText("Se connecter en tant qu'Admin");
		goToAdminPanel=new JPanel();
		goToAdminPanel.add(goToAdminButton);
		goToAdminPanel.setBackground(new Color(238,238,238));
		goToAdminPanel.setPreferredSize(new Dimension(700,75));
		
		panelTop=new JPanel();
		panelTop.add(indications);
		panelTop.add(new JLabel(new ImageIcon("icones/security.png")));
		panelTop.setPreferredSize(new Dimension(this.getWidth(),120));
		panelTop.add(goToAdminButton);
		
		iconeSupervisor=new JLabel(new ImageIcon("icones/admin2.png"));
		middlePanel=new JPanel();
		middlePanel.add(iconeSupervisor);
		middlePanel.setBackground(new Color(238,238,238));
		middlePanel.setPreferredSize(new Dimension(this.getWidth(),260));
		
		panelBottom=new JPanel();
		panelBottom.setLayout(new GridLayout(2, 2));
		panelBottom.add(loginSupervisorLabel);
		panelBottom.add(loginSupervisorField);
		panelBottom.add(passwordSupervisorLabel);
		panelBottom.add(passwordSupervisorField);
		panelBottom.setPreferredSize(new Dimension(280,70));
		panelBottom.setBackground(new Color(238,238,238));
		
		panelButton=new JPanel();
		panelButton.add(connexion);
		panelButton.setBackground(new Color(238,238,238));
		panelButton.setPreferredSize(new Dimension(this.getWidth(),80));
		

		
		
		homePanel=new JPanel();
		homePanel.add(panelTop);
		homePanel.add(goToAdminButton);
		homePanel.add(middlePanel);
		homePanel.add(panelBottom);
		homePanel.add(panelButton);
		
		homePanel.setBackground(new Color(238,238,238));
		conteneur.add(homePanel);
		/*<----------------------------------------------------Gestion du panel central--------------------------------------------------------------->*/

		JTableTitlePanel=new JPanel();
		JTableTitleLabel=new JLabel();
		JTableTitlePanel.add(JTableTitleLabel);
		JTableTitleLabel.setForeground(new Color(28,164,217));
		JTableTitleLabel.setFont(new Font("Tahoma",Font.BOLD,15));
		
		centralPanel1=new JPanel();
		centralPanel1.setBackground(new Color(238,238,238));
		centralPanel1Label=new JLabel();
		centralPanel1Label2=new JLabel("<html><span style='font-weight:bold;'>"+formater.format(today)+"</span></html>");
		anonymousPanel=new JPanel();
		anonymousPanel.setPreferredSize(new Dimension(700,25));
		anonymousPanel.add(centralPanel1Label2);
		//anonymousPanel.setBackground(new Color(238,238,238));
	
		centralPanel2=new JPanel();
		centralPanel2.setLayout(new BorderLayout());
		centralPanel2.setBackground(new Color(238,238,238));
		
		centralPanel3=new JPanel();
		centralPanel3.setBackground(Color.white);
		centralPanel3.add(new JLabel(new ImageIcon("toolbarIcones/sup.png")));
		mesInformations=new JLabel("<html>--------<u  style='font-weight:bold;font-size:1.1em;'>mes informations</u>--------</html>");
	//	mesInformations.setForeground(new Color(28,164,217));
		//mesInformations.setFont(new Font("Arial", Font.BOLD, 16));

		centralPanel3Panel=new JPanel();
		centralPanel3Panel.setBackground(new Color(238,238,238));
		centralPanel3Panel.setPreferredSize(new Dimension(150,110));
		
		GridLayout gridlayout=new GridLayout(3, 1);
		gridlayout.setHgap(15);
		centralPanel3PanelLabel1=new JLabel();
		centralPanel3PanelLabel2=new JLabel();
		centralPanel3PanelLabel3=new JLabel();
		centralPanel3Panel.setLayout(gridlayout);
		centralPanel3Panel.add(centralPanel3PanelLabel1);
		centralPanel3Panel.add(centralPanel3PanelLabel2);
		centralPanel3Panel.add(centralPanel3PanelLabel3);
		
		split1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,centralPanel1,centralPanel2);
		split1.setDividerLocation(100);
		split2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,centralPanel3,split1);
		split2.setDividerLocation(230);
		
	/*<---------------------------------------------------Gestion de la barre des tâches du surveillant-------------------------------------------------------------->*/
		toolBar=new JToolBar();
		add=new JButton(new ImageIcon("toolbarIcones/add.png"));
		add.setToolTipText("Ajouter un élève");
		add.setText("Nouveau");
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormulaireEleve(surveillant.getEtablissement());
				tabRefresher(0, surveillant.getEtablissement());
			}
		});						
		edit=new JButton(new ImageIcon("toolbarIcones/edit.png"));
		edit.setToolTipText("Editer le dossier d'un élève");
		edit.setText("Editer");
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String numberToEdit=JOptionPane.showInputDialog(null, "Entrer un numéro de table", "Editer un élève",JOptionPane.QUESTION_MESSAGE);
				if(numberToEdit!=null){
					if(numberToEdit.length()!=0 && testeurNumerique(numberToEdit)){
						Eleve e = SurveillantStatement.findStudent(Integer.parseInt(numberToEdit));
						new StudentUpdater(e);
					}
					else{
						JOptionPane.showMessageDialog(null,"Un numéro de table est composé uniquement de chiffres", "Information", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		find=new JButton(new ImageIcon("toolbarIcones/find.png"));
		find.setToolTipText("Rechercher un élève");
		find.setText("Rechercher");
		find.setHorizontalTextPosition(SwingConstants.CENTER);
		find.setVerticalTextPosition(SwingConstants.BOTTOM);
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numberToSearch=JOptionPane.showInputDialog(null, "Entrer un numéro de table", "Rechercher un élève",JOptionPane.QUESTION_MESSAGE);
				if(numberToSearch!=null){
					if(numberToSearch.length()!=0 && testeurNumerique(numberToSearch)){
						Eleve e = SurveillantStatement.findStudent(Integer.parseInt(numberToSearch));
							if(e!=null){
								new StudentDisplayer(e);
							}
							else{
								JOptionPane.showMessageDialog(null,"Un tel numéro de table n'existe pas", "Information", JOptionPane.WARNING_MESSAGE,new ImageIcon("toolbarIcones/find.png"));
							}
					}
					else{
						JOptionPane.showMessageDialog(null,"Un numéro de table est composé uniquement de chiffres", "Information", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		about=new JButton(new ImageIcon("toolbarIcones/about.png"));
		about.setToolTipText("Informations sur l'application");
		about.setText("A propos");
		about.setHorizontalTextPosition(SwingConstants.CENTER);
		about.setVerticalTextPosition(SwingConstants.BOTTOM);
		about.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
			new AboutApp();
			}
		});
		
		
		state=new JButton(new ImageIcon("toolbarIcones/state.png"));
		state.setToolTipText("Quelques chiffres utiles");
		state.setText("Statistiques");
		state.setHorizontalTextPosition(SwingConstants.CENTER);
		state.setVerticalTextPosition(SwingConstants.BOTTOM);
		state.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Statistiques(surveillant.getEtablissement()).setVisible(true);
				
			}
		});

		params=new JButton(new ImageIcon("toolbarIcones/params.png"));
		params.setToolTipText("Modfier mes données");
		params.setText("paramètres");
		params.setHorizontalTextPosition(SwingConstants.CENTER);
		params.setVerticalTextPosition(SwingConstants.BOTTOM);
		params.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new Parameter(surveillant.getNoss()).setVisible(true);		
			}
		});
		
		del=new JButton(new ImageIcon("toolbarIcones/del.png"));
		del.setToolTipText("Supprimer un dossier");
		del.setText("Supprimer ");
		del.setHorizontalTextPosition(SwingConstants.CENTER);
		del.setVerticalTextPosition(SwingConstants.BOTTOM);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numberToRemove=JOptionPane.showInputDialog(null, "Entrer un numéro de table", "Supprimer un élève",JOptionPane.QUESTION_MESSAGE);
				if(numberToRemove!=null  ){
					if( numberToRemove.length() !=0 && testeurNumerique(numberToRemove)){
						Eleve e = SurveillantStatement.findStudent(Integer.parseInt(numberToRemove));
						SurveillantStatement.removeStudent(Integer.parseInt(numberToRemove));
						SurveillantStatement.decrementNbrPlacee(e.getChoix_eleve());
						tabRefresher(0, e.getEtablissement());	
					}
					else{
						JOptionPane.showMessageDialog(null,"Un numéro de table est composé uniquement de chiffres", "Information", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		deconnect=new JButton(new ImageIcon("toolbarIcones/deconnect.png"));
		deconnect.setToolTipText("Se deconnecter");
		deconnect.setText("Deconnexion ");
		deconnect.setHorizontalTextPosition(SwingConstants.CENTER);
		deconnect.setVerticalTextPosition(SwingConstants.BOTTOM);
		deconnect.addActionListener(this);
		
		toolBar.add(add);
		toolBar.add(edit);
		toolBar.add(find);
		toolBar.addSeparator();
		toolBar.add(about);
		toolBar.add(state);
		toolBar.add(params);
		toolBar.add(del);
		toolBar.addSeparator();
		toolBar.add(deconnect);
		toolBar.setBackground(new Color(255,255,255));
		toolBar.setOpaque(true);
		/*<---------------------------------------------------Gestion de la barre des tâches de l'administrateur------------------------------------------------------------>*/
		toolBarAdmin=new JToolBar();
		
		delSup=new JButton(new ImageIcon("toolBarIconesAdmin/delSup.png"));
		delSup.setToolTipText("Supprimer un surveillant");
		delSup.setText("Supprimer");
		delSup.setHorizontalTextPosition(SwingConstants.CENTER);
		delSup.setVerticalTextPosition(SwingConstants.BOTTOM);
		delSup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nossremove = JOptionPane.showInputDialog(null,"Numero de carte d'identité");
				AdminStatement.removeSurveillant(nossremove);
				JOptionPane.showMessageDialog(null,"Suppression réussit");
			}
		});
		
		addSup=new JButton(new ImageIcon("toolBarIconesAdmin/addSup.png"));
		addSup.setToolTipText("Ajouter  un surveillant");
		addSup.setText("Nouveau");
		addSup.setHorizontalTextPosition(SwingConstants.CENTER);
		addSup.setVerticalTextPosition(SwingConstants.BOTTOM);
		addSup.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
			new FormulaireSurveillant();
			}
		});
		
		stateSup=new JButton(new ImageIcon("toolBarIconesAdmin/stateSup.png"));
		stateSup.setToolTipText("Statistiques générales");
		stateSup.setText("Données");
		stateSup.setHorizontalTextPosition(SwingConstants.CENTER);
		stateSup.setVerticalTextPosition(SwingConstants.BOTTOM);
		stateSup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AdminState().setVisible(true);
				
			}
		});
		
		deconnectSup=new JButton(new ImageIcon("toolBarIconesAdmin/logout.png"));
		deconnectSup.setToolTipText("Déconnexion");
		deconnectSup.setText("Déconnexion");
		deconnectSup.setHorizontalTextPosition(SwingConstants.CENTER);
		deconnectSup.setVerticalTextPosition(SwingConstants.BOTTOM);
		deconnectSup.addActionListener(this);
		
		toolBarAdmin.add(addSup);
		toolBarAdmin.add(stateSup);
		toolBarAdmin.add(delSup);	
		toolBarAdmin.add(deconnectSup);
		toolBarAdmin.setBackground(new Color(255,255,255));
		toolBarAdmin.setOpaque(true);
				
		/*<-----------------------------------------------------Fin de la gestion de la barre des tâches---------------------------------------------------------->*/
	}

	/*<-----------------------------------------------------Gestion de la connexion et de la déconnexion------------------------------------------------------------>*/
	@Override
	public void actionPerformed(ActionEvent action) {
		if(action.getSource()==goToAdminButton){
			indications.setText("Interface de connexion des Administrateurs");
			loginSupervisorLabel.setText("Login de l'administrateur");	
			loginSupervisorLabel.setForeground(new Color(254,175,21));
			passwordSupervisorLabel.setText("Password de l'administrateur");
			passwordSupervisorLabel.setForeground(new Color(254,175,21));
			panelBottom.setPreferredSize(new Dimension(310,70));
			panelBottom.revalidate();
			iconeSupervisor.setVisible(false);
			middlePanel.add(new JLabel(new ImageIcon("icones/admin.png")));
			middlePanel.setPreferredSize(new Dimension(this.getWidth(),400));
			goToAdminButton.setVisible(false);
			middlePanel.revalidate();
		}
		else if(action.getSource()==connexion){
		conteneur.add(split2, BorderLayout.CENTER);
			
			@SuppressWarnings("deprecation")
			String lgn=loginSupervisorField.getText(),pwd=passwordSupervisorField.getText();
							surveillant=ConnectionStatement.survIsRight(lgn, pwd);
								if(surveillant!=null){
								this.setTitle("Interface de travail du surveillant");
												homePanel.setVisible(false);
												toolBar.setVisible(true);
												split2.setVisible(true);
												conteneur.add(toolBar,BorderLayout.NORTH);
												
												centralPanel1Label.setText("<html><span style='font-size:2.8em;font-weight:bold;'> Collège :</span> <span style='color:rgb(28,164,217);font-size:3.6em;font-weight:bold;'>"+surveillant.getEtablissement()+"</span></html>");
												centralPanel3PanelLabel1.setText("<html><span style='font-size:1em;font-weight:bold;'>Prénom :</span> <span style='font-weight:bold;color:rgb(28,164,217);'>"+surveillant.getPrenom()+"</span></html>");
												centralPanel3PanelLabel2.setText("<html><span style='font-size:1em;font-weight:bold;'>Nom :</span><span style='font-weight:bold;color:rgb(28,164,217);'>"+surveillant.getNom()+"</span> </html>");
												centralPanel3PanelLabel3.setText("<html><span style='font-size:1em;font-weight:bold;'>Etablissement :</span><span style='font-weight:bold;color:rgb(28,164,217);'>"+surveillant.getEtablissement()+" </span></html>");
											
												centralPanel1.add(centralPanel1Label);
												centralPanel1.add(anonymousPanel);
												
												centralPanel3.add(mesInformations);
												centralPanel3.add(centralPanel3Panel);
												centralPanel3.add(new JLabel(new ImageIcon("icones/hss.png")));
												
												AllData data = SurveillantStatement.SelectAllStudent(surveillant.getEtablissement());
											    tab = new JTable(data.getTableau(),data.getTitle());
											    centralPanel2.add(JTableTitlePanel,BorderLayout.NORTH);
												centralPanel2.add(new JScrollPane(tab),BorderLayout.CENTER);
												JTableTitleLabel.setText("<html><span style='font-size:1.9em;'>Liste des élèves  de votre établissement déjà orientés</span></html>");
												tab.revalidate();
												centralPanel2.revalidate();
											
											
							}
								else if(ConnectionStatement.adminIsRight(lgn, pwd)){
									this.setTitle("Interface de travail de l'administrateur");
									centralPanel1Label.setText("<html><span style='font-size:2.8em;font-weight:bold;'>Espace :</span> <span style='color:orange;font-size:3.6em;font-weight:bold;'>Admin</span></html>");
									homePanel.setVisible(false);
									split2.setVisible(true);
									toolBarAdmin.setVisible(true);
									new BorderLayout();
									conteneur.add(toolBarAdmin,BorderLayout.NORTH);
									
									centralPanel1.add(centralPanel1Label);
									centralPanel1.add(anonymousPanel);
									
									AllData dat = AdminStatement.SelectAllSurveillant();
								    tab = new JTable(dat.getTableau(),dat.getTitle());
								    centralPanel2.add(JTableTitlePanel,BorderLayout.NORTH);
									centralPanel2.add(new JScrollPane(tab),BorderLayout.CENTER);
									JTableTitleLabel.setText("<html><span style='color:orange;font-size:1.9em;font-weight:bold;'>Liste des surveillants  et de leurs  établissements </span></html>");
									 tab.revalidate();
									centralPanel2.revalidate();
								}
			else{
				 JOptionPane.showMessageDialog(ConnexionPage.this, "Login ou mot de passe incorrecte", "Erreur !", JOptionPane.INFORMATION_MESSAGE);
			}		
		}
		else if(action.getSource()==deconnect){
			this.setTitle("Page de connexion");
			loginSupervisorField.setText("");
			passwordSupervisorField.setText("");
			centralPanel2.removeAll();
			toolBar.setVisible(false);
			split2.setVisible(false);
			homePanel.setVisible(true);	
			centralPanel1.removeAll();
			centralPanel3.removeAll();
		}
		else if(action.getSource()==deconnectSup){
			loginSupervisorField.setText("");
			passwordSupervisorField.setText("");	
			centralPanel2.removeAll();
			toolBarAdmin.setVisible(false);
			split2.setVisible(false);
			homePanel.setVisible(true);
			centralPanel2.removeAll();
		}
	}
/* <-----------------------------------------------------------------Quelques  méthodes d'aide -----------------------------------------------------------------------> */
	private boolean testeurNumerique(String str){
		boolean b=true;
		String dico="0123456789.";
		for(int i=0;i<str.length();i++){
			if(dico.indexOf(str.charAt(i))==-1)
				b=false;
		}
		return b;
	}
	public void frameClosingHandler() {
		int reponse = JOptionPane.showConfirmDialog(this,
                "Voulez-vous quitter l'application ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
		if(reponse == JOptionPane.YES_OPTION ){
			dispose();
		}
	}
	public void tabRefresher(int i,String str){
		AllData dat=null;
		if(i==0)
			dat = SurveillantStatement.SelectAllStudent(str);   
		if(i==1)
			dat=AdminStatement.SelectAllSurveillant();
		centralPanel2.removeAll();
		tab = new JTable(dat.getTableau(),dat.getTitle());
	    centralPanel2.add(JTableTitlePanel,BorderLayout.NORTH);
	    centralPanel2.add(new JScrollPane(tab),BorderLayout.CENTER);
	    centralPanel2.revalidate();
		
	}
	/* <-----------------------------------------------------------------La méthode principale main -----------------------------------------------------------------------> */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated( true );
		JDialog.setDefaultLookAndFeelDecorated( true );
			new ConnexionPage().setVisible(true);
	}
	/*new JLabel().setText("<html><u>titre</u></html>");*/
}
