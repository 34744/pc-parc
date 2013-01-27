package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import model.Materiel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class ModifMateriel extends JPanel {
	private JComboBox comboBoxType, comboBoxModele, comboBoxNom,
			comboBoxGarantie, comboBoxFournisseur, comboBoxImageW;
	private Vector<model.TypeMateriel> vectType;
	private Vector<model.ModeleMateriel> vectModele;
	private Vector<model.Budget> vectBudget;
	private Vector<model.Marque> vectMarque;
	private Vector<model.SocieteExt> vectFournisseur;
	private Vector<model.Materiel> vectMateriel;
	private Vector<model.ImageWindows> vectImage;
	private Vector<model.Site> vectSite;
	private Vector<model.Service> vectService;
	private Vector<model.Local> vectLocal;
	private Vector<model.SSL> vectSSL;
	private JLabel labelNomB, labelNumSerie, labelNom, labelDateInstall,
			labelGarantie, labelStatut, labelMacAdresse, labelNote;
	private MaskFormatter formatterIp, formatterMc;
	private JButton buttonOK, buttonAnnule;
	private Materiel matos = new Materiel();
	JFormattedTextField formattedTextFieldMcAdresse;
	JTextArea textAreaNote;
	JDateChooser calendrier = new JDateChooser();
	private JTextField textFieldNumSerie, textFieldNom;
	int ok = 1;
	int okSite = 1;
	private JTextField textFieldStatut;
	private JCheckBox checkBoxIP;
	private JCheckBox checkBoxPlace;
	private JComboBox comboBoxService;
	private JComboBox comboBoxSite;
	private JComboBox comboBoxLocal;
	private JLabel labelService;
	private JLabel labelLocal;
	private JComboBox comboBoxConnect;
	private JCheckBox checkBoxDesactivation;
	private JTextField formattedTextFieldIp1,formattedTextFieldIp3,formattedTextFieldIp4,formattedTextFieldIp2;

	public ModifMateriel() {
		setLayout(null);

		JLabel labelType = new JLabel("Type :");
		labelType.setBounds(10, 25, 46, 14);
		add(labelType);

		comboBoxType = new JComboBox();
		comboBoxType.setBounds(70, 22, 126, 20);
		add(comboBoxType);

		labelNomB = new JLabel("Nom :");
		labelNomB.setBounds(10, 50, 51, 14);
		add(labelNomB);

		comboBoxNom = new JComboBox();
		comboBoxNom.setBounds(70, 47, 126, 20);
		add(comboBoxNom);

		labelNumSerie = new JLabel("Num\u00E9ro de s\u00E9rie : ");
		labelNumSerie.setBounds(10, 125, 110, 14);
		add(labelNumSerie);

		labelNom = new JLabel("Nom : ");
		labelNom.setBounds(10, 100, 46, 14);
		add(labelNom);

		labelDateInstall = new JLabel("Date de l'installation: ");
		labelDateInstall.setBounds(10, 150, 126, 14);
		add(labelDateInstall);

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
		labelNote.setBounds(10, 278, 46, 14);
		add(labelNote);

		textFieldNumSerie = new JTextField();
		textFieldNumSerie.setBounds(125, 122, 110, 20);
		add(textFieldNumSerie);
		textFieldNumSerie.setColumns(10);

		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBounds(70, 97, 86, 20);
		add(textFieldNom);
		textFieldNom.setColumns(10);

		try {
			formatterMc = new MaskFormatter("HH.HH.HH.HH.HH.HH");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedTextFieldMcAdresse = new JFormattedTextField(formatterMc);
		formattedTextFieldMcAdresse.setText("HH.HH.HH.HH.HH.HH");
		formattedTextFieldMcAdresse.setBounds(101, 222, 110, 20);
		add(formattedTextFieldMcAdresse);

		textAreaNote = new JTextArea();
		textAreaNote.setLineWrap(true);
		textAreaNote.setWrapStyleWord(true);
		textAreaNote.setRows(6);
		textAreaNote.setBounds(47, 273, 478, 95);
		add(textAreaNote);

		calendrier.setBounds(125, 144, 110, 20);
		calendrier.setDateFormatString("dd-MM-yyyy");
		add(calendrier);

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

		JLabel labelImageW = new JLabel("Image install\u00E9e :");
		labelImageW.setBounds(10, 253, 98, 14);
		add(labelImageW);

		comboBoxImageW = new JComboBox();
		comboBoxImageW.setBounds(111, 250, 110, 20);
		add(comboBoxImageW);

		checkBoxIP = new JCheckBox("Adresse IP :");
		checkBoxIP.setBounds(10, 375, 98, 23);
		add(checkBoxIP);

		formattedTextFieldIp1 = new JTextField();
		formattedTextFieldIp1.setBounds(113, 376, 26, 20);
		add(formattedTextFieldIp1);

		JLabel labelConnecté = new JLabel("Connect\u00E9 \u00E0 :");
		labelConnecté.setBounds(10, 430, 98, 14);
		add(labelConnecté);

		comboBoxConnect = new JComboBox();
		comboBoxConnect.setBounds(114, 427, 138, 20);
		add(comboBoxConnect);

		textFieldStatut = new JTextField();
		textFieldStatut.setEditable(false);
		textFieldStatut.setText((String) null);
		textFieldStatut.setColumns(10);
		textFieldStatut.setBounds(101, 200, 110, 20);
		add(textFieldStatut);

		checkBoxPlace = new JCheckBox("Site :");
		checkBoxPlace.setBounds(10, 401, 59, 23);
		add(checkBoxPlace);

		comboBoxService = new JComboBox();
		comboBoxService.setBounds(288, 402, 193, 20);
		add(comboBoxService);

		comboBoxSite = new JComboBox();
		comboBoxSite.setBounds(82, 402, 129, 20);
		add(comboBoxSite);

		comboBoxLocal = new JComboBox();
		comboBoxLocal.setBounds(547, 402, 138, 20);
		add(comboBoxLocal);

		labelService = new JLabel("Service :");
		labelService.setBounds(219, 405, 72, 14);
		add(labelService);

		labelLocal = new JLabel("Local : ");
		labelLocal.setBounds(491, 405, 46, 14);
		add(labelLocal);

		checkBoxDesactivation = new JCheckBox(
				"D\u00E9sactiver le mat\u00E9riel");
		checkBoxDesactivation.setBounds(10, 481, 201, 23);
		add(checkBoxDesactivation);
		
		JLabel label = new JLabel(".");
		label.setBounds(140, 379, 9, 14);
		add(label);
		
		JLabel label_1 = new JLabel(".");
		label_1.setBounds(172, 379, 9, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel(".");
		label_2.setBounds(205, 379, 9, 14);
		add(label_2);
		
		formattedTextFieldIp2 = new JTextField();
		formattedTextFieldIp2.setBounds(146, 376, 26, 20);
		add(formattedTextFieldIp2);
		
		formattedTextFieldIp3 = new JTextField();
		formattedTextFieldIp3.setBounds(178, 376, 26, 20);
		add(formattedTextFieldIp3);
		
		formattedTextFieldIp4 = new JTextField();
		formattedTextFieldIp4.setBounds(213, 376, 26, 20);
		add(formattedTextFieldIp4);

		getVectType();
		getVectNom();
		getVectMateriel();
		getVectImage();
		getVectSite();
		getVectService();
		getVectLocal();
		getVectConnect();

		matos.setNomMateriel(textFieldNom.getText());

		MyButtonListener list = new MyButtonListener();
		buttonOK.addActionListener(list);
		buttonAnnule.addActionListener(list);

		MonGestionnaire itemListener = new MonGestionnaire();
		comboBoxType.addItemListener(itemListener);
		comboBoxNom.addItemListener(itemListener);
		comboBoxSite.addItemListener(itemListener);
		comboBoxService.addItemListener(itemListener);
		checkBoxIP.addItemListener(itemListener);
		checkBoxPlace.addItemListener(itemListener);
	}

	private class MonGestionnaire implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// on recupère l'objet
			if (e.getSource() == comboBoxType) {
				// remplir le combobox des modeles
				ok = 0;
				getVectNom();
				getVectMateriel();
				ok = 1;
			}
			if (e.getSource() == comboBoxNom && ok == 1) {
				getVectMateriel();
				getVectConnect();
			}

			if (e.getSource() == comboBoxSite) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					getVectService();
			}
			if (e.getSource() == comboBoxService) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					getVectLocal();
			}

			if (checkBoxIP.isSelected() == true) {
				formattedTextFieldIp1.setEditable(true);
				formattedTextFieldIp1.setEnabled(true);
				formattedTextFieldIp2.setEditable(true);
				formattedTextFieldIp2.setEnabled(true);
				formattedTextFieldIp3.setEditable(true);
				formattedTextFieldIp3.setEnabled(true);
				formattedTextFieldIp4.setEditable(true);
				formattedTextFieldIp4.setEnabled(true);
			} else {
				formattedTextFieldIp1.setEditable(false);
				formattedTextFieldIp1.setEnabled(false);
				formattedTextFieldIp2.setEditable(false);
				formattedTextFieldIp2.setEnabled(false);
				formattedTextFieldIp3.setEditable(false);
				formattedTextFieldIp3.setEnabled(false);
				formattedTextFieldIp4.setEditable(false);
				formattedTextFieldIp4.setEnabled(false);
			}
			if (checkBoxPlace.isSelected() == true) {
				comboBoxSite.setEnabled(true);
				comboBoxService.setEnabled(true);
				comboBoxLocal.setEnabled(true);
			} else {
				comboBoxSite.setEnabled(false);
				comboBoxService.setEnabled(false);
				comboBoxLocal.setEnabled(false);
			}
		}
	}

	public void desactivation() {
		if (checkBoxDesactivation.isSelected() == true)
			controller.ControllerDB.getDesactivation(comboBoxNom
					.getSelectedItem().toString());
	}

	public boolean ajouterMateriel() {

		matos.setNomMateriel(textFieldNom.getText());
		matos.setNumSerieMateriel(textFieldNumSerie.getText());

		if (calendrier.getDate() != null){
			Date d1 = calendrier.getDate();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = dateFormat.format(d1);
			matos.setDateInstallation(date);
		}else{
			matos.setDateInstallation("null");
		}
		matos.setDureeGarantie(Integer.valueOf(comboBoxGarantie
				.getSelectedItem().toString()));
		if (checkBoxPlace.isSelected() == true
				&& textFieldStatut.getText().equals("En stock"))
			matos.setStatutMateriel("Placé");
		else
			matos.setStatutMateriel(textFieldStatut.getText());
		if (checkBoxIP.isSelected() == true	&& formattedTextFieldIp1.getText() != null && formattedTextFieldIp2.getText() != null && formattedTextFieldIp3.getText() != null && formattedTextFieldIp4.getText() != null){
			try{
				int i = Integer.parseInt(formattedTextFieldIp1.getText());
				int j = Integer.parseInt(formattedTextFieldIp2.getText());
				int k = Integer.parseInt(formattedTextFieldIp3.getText());
				int l = Integer.parseInt(formattedTextFieldIp4.getText());
				if (i<256 && j<256 && k<256 && l<256){
					String ip = formattedTextFieldIp1.getText() + "." + formattedTextFieldIp2.getText() + "." + formattedTextFieldIp3.getText() + "." + formattedTextFieldIp1.getText();
					matos.setAdresseIp(ip);
				}
				else{
					matos.setAdresseIp(null);
					JOptionPane.showMessageDialog(null,
							"Adresse Ip incorrecte", "Adresse Ip",
							JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
			catch(Exception e){
					matos.setAdresseIp(null);
					JOptionPane.showMessageDialog(null,
							"Adresse Ip incorrecte", "Adresse Ip",
							JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
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
		if (comboBoxConnect.getSelectedItem().equals("Aucun"))
			matos.setFkMateriel(null);
		else
			matos.setFkMateriel(comboBoxConnect.getSelectedItem().toString());
		matos.setFkLocalS(getFkLocal(comboBoxLocal.getSelectedItem().toString()));
		if (comboBoxLocal.getSelectedItem().toString().equals("stock Info"))
			matos.setStatutMateriel("En stock");
		if (comboBoxImageW.getSelectedItem().equals("Aucune"))
			matos.setFkImageW(null);
		else
			matos.setFkImageW(comboBoxImageW.getSelectedItem().toString());
		return true;

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
										"Etes-vous sur de vouloir procéder à la mise à jour?",
										"RESUME",
										JOptionPane.INFORMATION_MESSAGE)) {

						case JOptionPane.YES_OPTION:
							controller.ControllerDB.ModifMateriel(matos);
							desactivation();
							controller.GestionFenetre
									.eraseContainerPanelMainJFrame();
							controller.GestionFenetre.ModifMateriel();
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

	public int getFkLocal(String local) {
		int fk = controller.ControllerDB.getFkLocal(local);
		return fk;
	}

	public int getFkFournisseur(String nomFournisseur) {
		int fk = controller.ControllerDB.getFkFournisseur(nomFournisseur);
		return fk;
	}

	// remplir le combobox des types
	public void getVectType() {
		comboBoxType.addItem("Tous");
		vectType = controller.ControllerDB.getTypeMateriel();
		for (int i = 0; i < this.vectType.size(); i++) {
			comboBoxType.addItem(vectType.elementAt(i).getNomTypeMateriel());
		}
	}

	public void getVectNom() {
		comboBoxNom.removeAllItems();
		vectMateriel = controller.ControllerDB.getNom(comboBoxType
				.getSelectedItem().toString());
		for (int i = 0; i < this.vectMateriel.size(); i++) {
			comboBoxNom.addItem(vectMateriel.elementAt(i).getNomMateriel());
		}
	}

	public void getVectImage() {
		comboBoxImageW.addItem("Aucune");
		vectImage = controller.ControllerDB.getImage();
		for (int i = 0; i < vectImage.size(); i++) {
			comboBoxImageW.addItem(vectImage.elementAt(i).getNomImageW());
		}
	}

	public void getVectSite() {
		vectSite = controller.ControllerDB.getSite();
		for (int i = 0; i < vectSite.size(); i++) {
			comboBoxSite.addItem(vectSite.elementAt(i).getNomSite());
		}
	}

	public void getVectService() {
		comboBoxService.removeAllItems();
		vectService = controller.ControllerDB.getService(comboBoxSite
				.getSelectedItem().toString());
		for (int i = 0; i < vectService.size(); i++) {
			comboBoxService.addItem(vectService.elementAt(i).getNomService());
		}
	}

	public void getVectLocal() {
		comboBoxLocal.removeAllItems();
		vectLocal = controller.ControllerDB.getLocal(comboBoxService
				.getSelectedItem().toString());
		for (int i = 0; i < vectLocal.size(); i++) {
			comboBoxLocal.addItem(vectLocal.elementAt(i).getNomLocal());
		}
	}

	public void getVectConnect() {
		comboBoxConnect.removeAllItems();
		comboBoxConnect.addItem("Aucun");
		vectMateriel = controller.ControllerDB.getNom("Tous");
		for (int i = 0; i < this.vectMateriel.size(); i++) {
			if (vectMateriel.elementAt(i).getNomMateriel()
					.equals(comboBoxNom.getSelectedItem().toString()) != true)
				comboBoxConnect.addItem(vectMateriel.elementAt(i)
						.getNomMateriel());
		}
	}

	public void getVectSSL(int i) {
		vectSSL = controller.ControllerDB.getSSL(i);
	}

	public void getVectMateriel() {
		vectMateriel = controller.ControllerDB.getMateriel(comboBoxNom
				.getSelectedItem().toString());
		int i = 0;
		textFieldNom.setText(vectMateriel.elementAt(i).getNomMateriel());
		textFieldNumSerie.setText(vectMateriel.elementAt(i)
				.getNumSerieMateriel());
		if (vectMateriel.elementAt(i).getDateInstallation() != null) {
			Date d1 = null;
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				d1 = (Date) formatter.parse(vectMateriel.elementAt(i)
						.getDateInstallation());

			} catch (ParseException e) {
				e.printStackTrace();
			}
			calendrier.setDate(d1);
		}else
			calendrier.setDate(null);
		formattedTextFieldMcAdresse.setText(vectMateriel.elementAt(i)
				.getAdresseMac());
		textFieldStatut.setText(vectMateriel.elementAt(i).getStatutMateriel());
		if (vectMateriel.elementAt(i).getAdresseIp() != null && vectMateriel.elementAt(i).getAdresseIp().equals("null")!= true) {
			checkBoxIP.setSelected(true);
			formattedTextFieldIp1.setEditable(true);
			formattedTextFieldIp1.setEnabled(true);
			formattedTextFieldIp2.setEditable(true);
			formattedTextFieldIp2.setEnabled(true);
			formattedTextFieldIp3.setEditable(true);
			formattedTextFieldIp3.setEnabled(true);
			formattedTextFieldIp4.setEditable(true);
			formattedTextFieldIp4.setEnabled(true);
			String TabIp[] = vectMateriel.elementAt(i).getAdresseIp().split("\\.");
			formattedTextFieldIp1.setText(TabIp[0]);
			formattedTextFieldIp2.setText(TabIp[1]);
			formattedTextFieldIp3.setText(TabIp[2]);
			formattedTextFieldIp4.setText(TabIp[3]);
		} else {
			checkBoxIP.setSelected(false);
			formattedTextFieldIp1.setEditable(false);
			formattedTextFieldIp2.setEditable(false);
			formattedTextFieldIp3.setEditable(false);
			formattedTextFieldIp4.setEditable(false);
			formattedTextFieldIp1.setEnabled(false);
			formattedTextFieldIp2.setEnabled(false);
			formattedTextFieldIp3.setEnabled(false);
			formattedTextFieldIp4.setEnabled(false);
			formattedTextFieldIp1.setText("");
			formattedTextFieldIp2.setText("");
			formattedTextFieldIp3.setText("");
			formattedTextFieldIp4.setText("");
		}
		textAreaNote.setText(vectMateriel.elementAt(i).getNoteMateriel());
		if (vectMateriel.elementAt(i).getFkImageW() != null) {
			comboBoxImageW.setSelectedItem(vectMateriel.elementAt(i)
					.getFkImageW());
		}
		else
			comboBoxImageW.setSelectedItem("Aucune");
		/*if (vectMateriel.elementAt(i).getFkMateriel() == null)
			comboBoxConnect.setSelectedItem("Aucun");
		else*/
			comboBoxConnect.setSelectedItem(vectMateriel.elementAt(i)
					.getFkMateriel());		
		getVectSSL(vectMateriel.elementAt(i).getFkLocalS());
		if (vectSSL.elementAt(0).getNomLocal().equals("stock Info")) {
			checkBoxPlace.setSelected(false);
			comboBoxSite.setEnabled(false);
			comboBoxService.setEnabled(false);
			comboBoxLocal.setEnabled(false);
		} else {
			checkBoxPlace.setSelected(true);
			comboBoxSite.setEnabled(true);
			comboBoxService.setEnabled(true);
			comboBoxLocal.setEnabled(true);
		}		
		comboBoxGarantie.setSelectedItem(String.valueOf(vectMateriel.elementAt(i).getDureeGarantie()));
		comboBoxSite.setSelectedItem(vectSSL.elementAt(0).getNomSite());
		comboBoxService.setSelectedItem(vectSSL.elementAt(0).getNomService());
		comboBoxLocal.setSelectedItem(vectSSL.elementAt(0).getNomLocal());
		comboBoxConnect.setSelectedItem(vectMateriel.elementAt(i)
				.getFkMateriel());
		comboBoxGarantie.setSelectedItem(vectMateriel.elementAt(i)
				.getDureeGarantie());
	}
}
