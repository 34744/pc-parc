package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import controller.ExceptionComboType;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import model.Materiel;

public class AjoutMateriel extends JPanel {

	private JComboBox comboBoxType, comboBoxModele, comboBoxMarque,
			comboBoxGarantie, comboBoxFournisseur, comboBoxBudget;
	private Vector<model.TypeMateriel> vectType;
	private Vector<model.ModeleMateriel> vectModele;
	private Vector<model.Budget> vectBudget;
	private Vector<model.Marque> vectMarque;
	private Vector<model.SocieteExt> vectFournisseur;
	private JLabel labelMarque, labelNumSerie, labelNom, labelDateAchat,
			labelGarantie, labelStatut, labelMacAdresse, labelNote;
	private JTextField textFieldNumSerie, textFieldNom, textFieldStatut;
	MaskFormatter formatterIp;
	private JButton buttonOK, buttonAnnule;
	private Materiel matos = new Materiel();
	JFormattedTextField formattedTextFieldMcAdresse;
	JTextArea textAreaNote;
	JDateChooser calendrier = new JDateChooser();

	public AjoutMateriel() {
		setLayout(null);

		JLabel labelType = new JLabel("Type :");
		labelType.setBounds(10, 25, 46, 14);
		add(labelType);

		comboBoxType = new JComboBox();
		comboBoxType.setBounds(70, 22, 126, 20);
		add(comboBoxType);

		JLabel labelModele = new JLabel("Mod\u00E8le :");
		labelModele.setBounds(10, 75, 70, 14);
		add(labelModele);

		comboBoxModele = new JComboBox();
		comboBoxModele.setBounds(70, 72, 253, 20);
		add(comboBoxModele);

		labelMarque = new JLabel("Marque :");
		labelMarque.setBounds(10, 50, 51, 14);
		add(labelMarque);

		comboBoxMarque = new JComboBox();
		comboBoxMarque.setBounds(70, 47, 126, 20);
		add(comboBoxMarque);

		labelNumSerie = new JLabel("Num\u00E9ro de s\u00E9rie : ");
		labelNumSerie.setBounds(10, 125, 110, 14);
		add(labelNumSerie);

		labelNom = new JLabel("Nom : ");
		labelNom.setBounds(10, 100, 46, 14);
		add(labelNom);

		labelDateAchat = new JLabel("Date de l'achat : ");
		labelDateAchat.setBounds(10, 150, 98, 14);
		add(labelDateAchat);

		labelGarantie = new JLabel("Dur\u00E9e de la garantie : ");
		labelGarantie.setBounds(10, 175, 126, 14);
		add(labelGarantie);

		labelStatut = new JLabel("Statut : ");
		labelStatut.setBounds(10, 200, 46, 14);
		add(labelStatut);

		labelMacAdresse = new JLabel("Mac adresse : ");
		labelMacAdresse.setBounds(10, 225, 98, 14);
		add(labelMacAdresse);

		labelNote = new JLabel("Note : ");
		labelNote.setBounds(10, 300, 46, 14);
		add(labelNote);

		textFieldNumSerie = new JTextField();
		textFieldNumSerie.setBounds(125, 122, 110, 20);
		add(textFieldNumSerie);
		textFieldNumSerie.setColumns(10);

		textFieldNom = new JTextField();
		textFieldNom.setBounds(70, 97, 86, 20);
		add(textFieldNom);
		textFieldNom.setColumns(10);

		textFieldStatut = new JTextField();
		textFieldStatut.setEditable(false);
		textFieldStatut.setText("En stock");
		textFieldStatut.setBounds(60, 197, 86, 20);
		add(textFieldStatut);
		textFieldStatut.setColumns(10);

		try {
			formatterIp = new MaskFormatter("HH.HH.HH.HH.HH.HH");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedTextFieldMcAdresse = new JFormattedTextField(formatterIp);
		formattedTextFieldMcAdresse.setText("00.00.00.00.00.00.");
		formattedTextFieldMcAdresse.setBounds(101, 222, 110, 20);
		add(formattedTextFieldMcAdresse);

		textAreaNote = new JTextArea();
		textAreaNote.setLineWrap(true);
		textAreaNote.setWrapStyleWord(true);
		textAreaNote.setRows(6);
		textAreaNote.setBounds(50, 300, 478, 95);
		add(textAreaNote);

		calendrier.setBounds(125, 144, 110, 20);
		calendrier.setDateFormatString("dd-MM-yyyy");
		add(calendrier);
		Date d1 = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = dateFormat.format(d1);
		calendrier.setDate(d1);

		buttonOK = new JButton("OK");
		buttonOK.setBounds(47, 530, 89, 23);
		add(buttonOK);

		buttonAnnule = new JButton("Retour");
		buttonAnnule.setBounds(146, 530, 89, 23);
		add(buttonAnnule);

		comboBoxGarantie = new JComboBox();
		comboBoxGarantie.setBounds(134, 172, 52, 20);
		comboBoxGarantie.addItem("0");
		comboBoxGarantie.addItem("1");
		comboBoxGarantie.addItem("3");
		comboBoxGarantie.addItem("6");
		comboBoxGarantie.addItem("12");
		comboBoxGarantie.addItem("24");
		add(comboBoxGarantie);

		JLabel labelFournisseur = new JLabel("Fournisseur :");
		labelFournisseur.setBounds(10, 250, 86, 14);
		add(labelFournisseur);

		JLabel labelBudget = new JLabel("Budget :");
		labelBudget.setBounds(10, 275, 51, 14);
		add(labelBudget);

		comboBoxFournisseur = new JComboBox();
		comboBoxFournisseur.setBounds(101, 247, 126, 20);
		add(comboBoxFournisseur);

		comboBoxBudget = new JComboBox();
		comboBoxBudget.setBounds(101, 269, 126, 20);
		add(comboBoxBudget);

		getVectType();
		getVectMarque();
		remplirCombo();
		remplirFournisseur();
		remplirBudget();

		matos.setNomMateriel(textFieldNom.getText());

		MyButtonListener list = new MyButtonListener();
		buttonOK.addActionListener(list);
		buttonAnnule.addActionListener(list);

		MonGestionnaire itemListener = new MonGestionnaire();
		comboBoxType.addItemListener(itemListener);
		comboBoxMarque.addItemListener(itemListener);
	}

	private class MonGestionnaire implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// on recupère l'objet
			if (e.getSource() == comboBoxType
					|| e.getSource() == comboBoxMarque) {
				// remplir le combobox des modeles
				remplirCombo();

			}
		}
	}

	public boolean ajouterMateriel() {

		if (comboBoxModele.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null,
					"Veuillez remplir le champs 'modèle'", "Erreur de modèle",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			if (textFieldNom.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Veuillez remplir le champs 'nom'", "Erreur de nom",
						JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
				matos.setNomMateriel(textFieldNom.getText());
				matos.setNumSerieMateriel(textFieldNumSerie.getText());

				Date d1 = calendrier.getDate();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(d1);
				matos.setDateAchat(date);

				matos.setDateInstallation("0000-00-00");
				matos.setDureeGarantie(Integer.parseInt(comboBoxGarantie
						.getSelectedItem().toString()));
				matos.setStatutMateriel(textFieldStatut.getText());
				matos.setAdresseIp(null);
				matos.setAdresseMac(formattedTextFieldMcAdresse.getText());
				int positionFin;
				int longueurCaractere="'".length();
				String resultat="";
				String chaine = textAreaNote.getText();

				while( (positionFin=chaine.indexOf("\'"))!=(-1)) {
				resultat=resultat+chaine.substring(0,positionFin)+"\\'";
				chaine=chaine.substring(positionFin+longueurCaractere);
				}
				resultat=resultat+chaine;	
				matos.setNoteMateriel(resultat);
				matos.setFkMateriel(null);
				matos.setFkLocalS(1);
				matos.setFkBudget(comboBoxBudget.getSelectedItem().toString());
				matos.setFkDomaineReseau(null);
				matos.setFkImageW(null);
				// recup l'id du modeleMateriel
				matos.setFkModeleMateriel(getFkModeleMateriel(String
						.valueOf(comboBoxModele.getItemAt(comboBoxModele
								.getSelectedIndex()))));
				matos.setFkSocieteExt(getFkFournisseur(comboBoxFournisseur
						.getSelectedItem().toString()));
				return true;
			}
		}
	}

	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == buttonOK) {
				if (ajouterMateriel() == true) {

					try {

						switch (JOptionPane
								.showConfirmDialog(
										null,
										"Etes-vous sur de vouloir procéder à l'ajout du matériel?",
										"RESUME",
										JOptionPane.INFORMATION_MESSAGE)) {

						case JOptionPane.YES_OPTION:
							controller.ControllerDB.addMateriel(matos);
							controller.GestionFenetre
									.eraseContainerPanelMainJFrame();
							controller.GestionFenetre.AjoutMateriel();
							break;

						case JOptionPane.NO_OPTION:
							JOptionPane.showMessageDialog(null,
									"Abandon de l'operation");
							break;
						case JOptionPane.CANCEL_OPTION:
							controller.GestionFenetre
									.eraseContainerPanelMainJFrame();
							controller.GestionFenetre.initAccueil();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}
			if (source == buttonAnnule) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.initAccueil();
			}

		}
	}

	public int getFkModeleMateriel(String nomModele) {
		int fk = controller.ControllerDB.getFkModeleMateriel(nomModele);
		return fk;
	}

	public int getFkFournisseur(String nomFournisseur) {
		int fk = controller.ControllerDB.getFkFournisseur(nomFournisseur);
		return fk;
	}

	// remplir le combobox des types
	public void getVectType() {
		// comboBoxType.addItem("");
		vectType = controller.ControllerDB.getTypeMateriel();
		for (int i = 0; i < this.vectType.size(); i++) {
			comboBoxType.addItem(vectType.elementAt(i).getNomTypeMateriel());
		}
	}

	public void getVectMarque() {
		// comboBoxMarque.addItem("");
		vectMarque = controller.ControllerDB.getMarque();
		for (int i = 0; i < this.vectMarque.size(); i++) {
			comboBoxMarque.addItem(vectMarque.elementAt(i).getNomMarque());
		}
	}

	public void getVectModele(String type, String marque) {
		comboBoxModele.removeAllItems();
		vectModele = controller.ControllerDB.getModeleMateriel(type, marque);
		for (int i = 0; i < this.vectModele.size(); i++)
			comboBoxModele.addItem(vectModele.elementAt(i)
					.getNomModeleMateriel());
	}

	public void remplirCombo() {
		String idType, idMarque;
		idType = comboBoxType.getSelectedItem().toString();
		idMarque = comboBoxMarque.getSelectedItem().toString();
		getVectModele(idType, idMarque);
	}

	public void remplirFournisseur() {
		vectFournisseur = controller.ControllerDB.getFournisseur();
		for (int i = 0; i < this.vectFournisseur.size(); i++)
			comboBoxFournisseur.addItem(vectFournisseur.elementAt(i)
					.getNomSocieteExt());
	}

	public void remplirBudget() {
		vectBudget = controller.ControllerDB.getBudget();
		for (int i = 0; i < this.vectBudget.size(); i++)
			comboBoxBudget.addItem(vectBudget.elementAt(i).getNumBudget());
	}
}
