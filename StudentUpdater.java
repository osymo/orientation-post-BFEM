package ClasseGraphique;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import ClasseDeBase.Eleve;
import ClasseDeBase.Serie;
import ClasseDeRequete.SurveillantStatement;

@SuppressWarnings("serial")
public class StudentUpdater extends JFrame implements ActionListener {
	private JButton envoyer;
	@SuppressWarnings("rawtypes")
	private JComboBox choix1, choix2, choix3;
	private String[] serie = { "Série S", "Série L", "Série T ", "Série G" };
	private ButtonGroup rdg;
	private JRadioButton pTour, sTour, moyenne;
	@SuppressWarnings("unused")
	private JLabel consigneLabel, indications, choixLabel1, choixLabel2, choixLabel3;
	private Container conteneur;
	@SuppressWarnings("unused")
	private JPanel panneau, panneau2, topPanneau, botPanneau, comboPanel;
	private JDateChooser dateChooser;
	private JLabel prenomLabel, nomLabel, dnaissanceLabel, lnaissanceLabel, ecoleLabel, numTableLabel, moyenneClasse,
			dominante1, dominante2, dominante3, dominante4, dominante5, dominante6, consigneChoixLabel;
	private JTextField prenomField, nomField, lnaissanceField, ecoleField, numTableField, moyenneClasseField,
			dominanteField1, dominanteField2, dominanteField3, dominanteField4, dominanteField5, dominanteField6;
	private Dimension dim;
	private JPanel panelChoix1, panelChoix2, panelChoix3;
	private Eleve studentToUpdate;

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public StudentUpdater(Eleve student) {
		/*
		 * <----------------------@# Omar SidyMoctarDiop*****************
		 ************* Troisème année informatique*************** Université de thès,
		 * galsen,sénégal**************** Projet final Java Swing,28 juin 2016
		 **************************/

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}

		studentToUpdate = student;
		this.setTitle("Enregitrement d'un élève");
		this.setSize(new Dimension(480, 745));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		conteneur = this.getContentPane();
		dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
		this.setIconImage(new ImageIcon("icones/sac.PNG").getImage());
		// conteneur.setBackground(Color.white);

		panneau = new JPanel();
		GridLayout gridLayout = new GridLayout(7, 2);
		gridLayout.setHgap(15);
		// gridLayout.setVgap(2);
		panneau.setLayout(gridLayout);

		panneau2 = new JPanel();
		panneau2.setLayout(new FlowLayout());
		topPanneau = new JPanel();
		topPanneau.setLayout(new GridLayout(1, 2));
		botPanneau = new JPanel();
		panelChoix1 = new JPanel();
		panelChoix2 = new JPanel();
		panelChoix3 = new JPanel();

		comboPanel = new JPanel();

		rdg = new ButtonGroup();
		envoyer = new JButton("Envoyer");
		envoyer.addActionListener(this);
		envoyer.setForeground(new Color(28, 164, 217));

		consigneLabel = new JLabel("Veuillez renseigner les champs ci-dessous");
		consigneLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		consigneLabel.setForeground(new Color(28, 164, 217));

		indications = new JLabel("Indiquer ci-dessous comment l'élève est passé au lycée");
		indications.setFont(new Font("Tahoma", Font.BOLD, 13));
		indications.setForeground(Color.red);

		consigneChoixLabel = new JLabel("Choisir 3 séries dans l'ordre de préférence de l'élève à orienter");
		consigneChoixLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		consigneChoixLabel.setForeground(Color.red);

		choix1 = new JComboBox(serie);
		choix2 = new JComboBox(serie);
		choix3 = new JComboBox(serie);

		numTableLabel = new JLabel("Numéro de Table");
		prenomLabel = new JLabel("Prénom");
		nomLabel = new JLabel("Nom");
		dnaissanceLabel = new JLabel("Date Naissance");
		lnaissanceLabel = new JLabel("Lieu Naissance");
		ecoleLabel = new JLabel("Etablissement");
		moyenneClasse = new JLabel("Moyenne classe");
		dominante1 = new JLabel("Dominante 1");
		dominante2 = new JLabel("Dominante 2");
		dominante3 = new JLabel("Dominante 1");
		dominante4 = new JLabel("Dominante 2");
		dominante5 = new JLabel("Dominante 1");
		dominante6 = new JLabel("Dominante 2");

		numTableField = new JTextField(21);
		numTableField.setForeground(Color.green);
		numTableField.setText(new String().valueOf(student.getNumeroTable()));

		prenomField = new JTextField(21);
		prenomField.setText(student.getPrenom());

		nomField = new JTextField(21);
		nomField.setText(student.getNom());

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");

		lnaissanceField = new JTextField(21);
		lnaissanceField.setText(student.getLieuNaissance());

		ecoleField = new JTextField(21);
		ecoleField.setText(student.getEtablissement());
		ecoleField.setEditable(false);
		ecoleField.setBackground(new Color(28, 164, 217));

		moyenneClasseField = new JTextField(2);
		moyenneClasseField.setText(new String().valueOf(student.getMoyenneClasse()));

		dominanteField1 = new JTextField(2);
		dominanteField2 = new JTextField(2);
		dominanteField3 = new JTextField(2);
		dominanteField4 = new JTextField(2);
		dominanteField5 = new JTextField(2);
		dominanteField6 = new JTextField(2);

		pTour = new JRadioButton("Premier tour :");
		sTour = new JRadioButton("Second tour");
		moyenne = new JRadioButton("Moyenne 10");

		rdg.add(pTour);
		rdg.add(sTour);
		rdg.add(moyenne);

		topPanneau.setBackground(new Color(238, 238, 238));
		topPanneau.setPreferredSize(new Dimension(300, 26));

		panneau.add(numTableLabel);
		panneau.add(numTableField);
		panneau.add(prenomLabel);
		panneau.add(prenomField);
		panneau.add(nomLabel);
		panneau.add(nomField);
		panneau.add(dnaissanceLabel);
		panneau.add(dateChooser);
		panneau.add(lnaissanceLabel);
		panneau.add(lnaissanceField);
		panneau.add(ecoleLabel);
		panneau.add(ecoleField);
		panneau.setBackground(new Color(238, 238, 238));
		panneau.setPreferredSize(new Dimension(300, 170));

		panneau2.add(moyenneClasse);
		panneau2.add(moyenneClasseField);
		panneau2.add(dominante1);
		panneau2.add(dominanteField1);
		panneau2.add(dominante2);
		panneau2.add(dominanteField2);
		panneau2.setBackground(new Color(238, 238, 238));
		panneau2.setPreferredSize(new Dimension(400, 50));

		botPanneau.add(indications);
		botPanneau.add(pTour);
		botPanneau.add(sTour);
		botPanneau.add(moyenne);
		botPanneau.setBackground(new Color(238, 238, 238));
		botPanneau.setPreferredSize(new Dimension(400, 50));

		panelChoix1.add(new JLabel("Options"));
		panelChoix1.add(choix1);
		panelChoix1.add(dominante1);
		panelChoix1.add(dominanteField1);
		panelChoix1.add(dominante2);
		panelChoix1.add(dominanteField2);
		panelChoix1.setBackground(new Color(238, 238, 238));
		panelChoix1.setPreferredSize(new Dimension(150, 150));
		panelChoix1.setBorder(BorderFactory.createTitledBorder("Premier choix"));

		panelChoix2.add(new JLabel("Options"));
		panelChoix2.add(choix2);
		panelChoix2.add(dominante3);
		panelChoix2.add(dominanteField3);
		panelChoix2.add(dominante4);
		panelChoix2.add(dominanteField4);
		panelChoix2.setBackground(new Color(238, 238, 238));
		panelChoix2.setPreferredSize(new Dimension(150, 150));
		panelChoix2.setBorder(BorderFactory.createTitledBorder("Second choix"));

		panelChoix3.add(new JLabel("Options"));
		panelChoix3.add(choix3);
		panelChoix3.add(dominante5);
		panelChoix3.add(dominanteField5);
		panelChoix3.add(dominante6);
		panelChoix3.add(dominanteField6);
		panelChoix3.setBackground(new Color(238, 238, 238));
		panelChoix3.setPreferredSize(new Dimension(150, 150));
		panelChoix3.setBorder(BorderFactory.createTitledBorder("Dernier choix"));

		conteneur.setLayout(new FlowLayout());
		conteneur.add(consigneLabel);
		// conteneur.add(topPanneau);
		conteneur.add(panneau);
		conteneur.add(panneau2);
		conteneur.add(consigneChoixLabel);
		// conteneur.add(comboPanel);
		conteneur.add(panelChoix1);
		conteneur.add(panelChoix2);
		conteneur.add(panelChoix3);
		conteneur.add(botPanneau);

		conteneur.add(envoyer);
		conteneur.setBackground(new Color(238, 238, 238));
		conteneur.add(new JLabel(new ImageIcon("icones/sac.PNG")));

		/*
		 * <-----------------------------------Gestion et Contrôle des saisies
		 * des données tay mou nekh--------------------------->
		 */
		prenomField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = prenomField.getText(),
						baseDecimal = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					prenomField.setForeground(Color.red);
				else
					prenomField.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = prenomField.getText(),
						baseDecimal = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					prenomField.setForeground(Color.red);
			}
		});

		nomField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = nomField.getText(), baseDecimal = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					nomField.setForeground(Color.red);
				else
					nomField.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = nomField.getText(), baseDecimal = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					nomField.setForeground(Color.red);
			}
		});

		numTableField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = numTableField.getText(), baseDecimal = "0123456789";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					numTableField.setForeground(Color.red);
				else
					numTableField.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = numTableField.getText(), baseDecimal = "0123456789";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					numTableField.setForeground(Color.red);
			}
		});

		moyenneClasseField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = moyenneClasseField.getText(), baseDecimal = "0123456789.";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					moyenneClasseField.setForeground(Color.red);
				else
					moyenneClasseField.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = moyenneClasseField.getText(), baseDecimal = "0123456789.";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					moyenneClasseField.setForeground(Color.red);
			}
		});

		dominanteField1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = dominanteField1.getText(), baseDecimal = "0123456789.";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					dominanteField1.setForeground(Color.red);
				else
					dominanteField1.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = dominanteField1.getText(), baseDecimal = "0123456789.";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					dominanteField1.setForeground(Color.red);
			}
		});

		dominanteField2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = dominanteField2.getText(), baseDecimal = "0123456789.";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					dominanteField2.setForeground(Color.red);
				else
					dominanteField2.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = dominanteField2.getText(), baseDecimal = "0123456789.";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					dominanteField2.setForeground(Color.red);
			}
		});

		dominanteField3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = dominanteField3.getText(), baseDecimal = "0123456789.";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					dominanteField3.setForeground(Color.red);
				else
					dominanteField3.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = dominanteField3.getText(), baseDecimal = "0123456789.";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					dominanteField3.setForeground(Color.red);
			}
		});

		dominanteField4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = dominanteField4.getText(), baseDecimal = "0123456789.";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					dominanteField4.setForeground(Color.red);
				else
					dominanteField4.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = dominanteField4.getText(), baseDecimal = "0123456789.";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					dominanteField4.setForeground(Color.red);
			}
		});

		dominanteField5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = dominanteField5.getText(), baseDecimal = "0123456789.";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					dominanteField5.setForeground(Color.red);
				else
					dominanteField5.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = dominanteField5.getText(), baseDecimal = "0123456789.";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					dominanteField5.setForeground(Color.red);
			}
		});
		dominanteField6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				boolean b = false;
				String str = dominanteField6.getText(), baseDecimal = "0123456789.";
				for (int i = 0; i < str.length(); i++) {
					if (baseDecimal.indexOf(str.charAt(i)) == -1)
						b = true;
				}
				if (b == true)
					dominanteField6.setForeground(Color.red);
				else
					dominanteField6.setForeground(Color.green);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = dominanteField6.getText(), baseDecimal = "0123456789.";
				if (baseDecimal.indexOf(str.charAt(str.length() - 1)) == -1)
					dominanteField6.setForeground(Color.red);
			}
		});
	}

	/*
	 * <------------------------------------------Gestion du click sur le
	 * boutton envoie----------------------------------->
	 */
	@Override
	public void actionPerformed(ActionEvent bouton) {

		if (bouton.getSource() == envoyer) {
			char profil;
			int numTable;
			double mGenerale, note1, note2, note3, note4, note5, note6;
			String prenom, nom, lnaissance, ets, dnaissance;

			if (prenomField.getText().length() > 0 && nomField.getText().length() > 0
					&& lnaissanceField.getText().length() > 0 && dateChooser.getDate()!=null && ecoleField.getText().length() > 0
					&& numTableField.getText().length() > 0 && moyenneClasseField.getText().length() > 0
					&& dominanteField1.getText().length() > 0 && dominanteField2.getText().length() > 0
					&& dominanteField3.getText().length() > 0 && dominanteField4.getText().length() > 0
					&& dominanteField5.getText().length() > 0 && dominanteField6.getText().length() > 0
					&& (pTour.isSelected() || sTour.isSelected() || moyenne.isSelected())) {

				if (testeurAlaphabétique(prenomField.getText()) && testeurAlaphabétique(nomField.getText())
						&& testeurNumerique(moyenneClasseField.getText()) && testeurNumerique(dominanteField1.getText())
						&& testeurNumerique(dominanteField2.getText()) && testeurNumerique(dominanteField3.getText())
						&& testeurNumerique(dominanteField4.getText()) && testeurNumerique(dominanteField5.getText())
						&& testeurNumerique(dominanteField6.getText()) && testeurNumerique(numTableField.getText())
						&& (choix1.getSelectedItem() != choix2.getSelectedItem()
								&& choix1.getSelectedItem() != choix3.getSelectedItem()
								&& choix2.getSelectedItem() != choix3.getSelectedItem())) {

					numTable = Integer.valueOf(numTableField.getText()).intValue();
					note1 = Double.valueOf(dominanteField1.getText()).doubleValue();
					note2 = Double.valueOf(dominanteField2.getText()).doubleValue();
					note3 = Double.valueOf(dominanteField3.getText()).doubleValue();
					note4 = Double.valueOf(dominanteField4.getText()).doubleValue();
					note5 = Double.valueOf(dominanteField5.getText()).doubleValue();
					note6 = Double.valueOf(dominanteField6.getText()).doubleValue();
					mGenerale = Double.valueOf(moyenneClasseField.getText()).doubleValue();

					if (rangeChecker(note1) && rangeChecker(note2) && rangeChecker(note3) && rangeChecker(note4)
							&& rangeChecker(note5) && rangeChecker(note6)) {
						prenom = prenomField.getText();
						nom = nomField.getText();
						lnaissance = lnaissanceField.getText();
						String helper = dateChooser.getDate().toString();
						dnaissance = helper.substring(0, 10) + helper.substring(23, 28);
						ets = ecoleField.getText();
						if (pTour.isSelected())
							profil = 'A';
						else if (sTour.isSelected())
							profil = 'B';
						else
							profil = 'C';

						Serie[] optionTab = new Serie[3];
						optionTab[0] = new Serie(note1, note2, (String) choix1.getSelectedItem());
						optionTab[1] = new Serie(note3, note4, (String) choix2.getSelectedItem());
						optionTab[2] = new Serie(note4, note6, (String) choix3.getSelectedItem());
						for (int k = 0; k < 3; k++) {
							switch (optionTab[k].getSerie()) {
							case "Série S":
								optionTab[k].setSerie("s");
								break;
							case "Série T":
								optionTab[k].setSerie("t");
								break;
							case "Série L":
								optionTab[k].setSerie("l");
								break;
							case "Série G":
								optionTab[k].setSerie("g");
								break;

							}
						}
						
						Eleve unEleve = new Eleve(numTable, prenom, nom, mGenerale, dnaissance, lnaissance, ets, profil,optionTab);
						String oldSerie=studentToUpdate.getChoix_eleve(),newSerie=unEleve.orienter();
						System.out.println("***********"+oldSerie);
						int oldNumber=studentToUpdate.getNumeroTable();
						
					SurveillantStatement.UpdateEleve(oldSerie, oldNumber, unEleve);
					} else {
						JOptionPane.showMessageDialog(null, "Une note doit être entre 0 et 20", "Attention !",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez vérifier votre saisie", "Attention !",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JDialog.setDefaultLookAndFeelDecorated(true);
				JOptionPane.showMessageDialog(null, "Veuillez remplir tous champs svp", "Information !",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	private boolean testeurNumerique(String str) {
		boolean b = true;
		String dico = "0123456789.";
		for (int i = 0; i < str.length(); i++) {
			if (dico.indexOf(str.charAt(i)) == -1)
				b = false;
		}
		return b;
	}

	private boolean testeurAlaphabétique(String str) {
		boolean b = true;
		String dico = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < str.length(); i++) {
			if (dico.indexOf(str.charAt(i)) == -1)
				b = false;
		}
		return b;
	}

	private boolean rangeChecker(double d) {
		return (d >= 0 && d <= 20) ? true : false;
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * JFrame.setDefaultLookAndFeelDecorated( true );
	 * JDialog.setDefaultLookAndFeelDecorated( true );
	 * 
	 * new FormulaireEleve("écoleTeste").setVisible(true); }
	 */
}