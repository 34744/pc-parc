package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import model.LigneIntervention;
import model.LigneTableauLigneIntervention;
import model.ModelTableauIntervention;
import model.ModelTableauLigneIntervention;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

import controller.ControllerDB;
import java.awt.Checkbox;
import javax.swing.JTextPane;

public class ModifIntervention extends JPanel {
	private JTextField textFieldNom;
	private JTextField textFieldDemandeur;
	private JTextField textFieldTel;
	private JTextField textFieldDate;
	private JTable tableLti;
	private JScrollPane JSP;
	private Vector<model.LigneTableauLigneIntervention> vectLti = new Vector<model.LigneTableauLigneIntervention>(
			50);
	private ModelTableauLigneIntervention modelLti;
	private JButton buttonOk;
	private JButton buttonRetour;
	private int idIntervention;
	private JLabel lblDateDeLintervention;
	private JRadioButton radioButtonTech, radioButtonSociete;
	private ButtonGroup buttongroup = new ButtonGroup();
	private JLabel lblNote;
	private JComboBox comboBoxTechnicien, comboBoxSociete;
	private JDateChooser calendrier = new JDateChooser();
	private JLabel lblStatut;
	private JTextField textFieldStatut;
	private JRadioButton radioButtonStatutSE;
	private JRadioButton radioButtonStatutEC;
	private JRadioButton radioButtonStatutT;
	private ButtonGroup buttongroupStatut = new ButtonGroup();
	private JRadioButton radioButtonStatutSuspendu;
	private model.RemplirIntervention intervention;
	private Vector<model.Technicien> vectTech;
	private Vector<model.SocieteExt> vectSocExt;
	private Vector<model.LigneIntervention> vectLigneI;
	private LigneTableauLigneIntervention LigneVectLti = new LigneTableauLigneIntervention();
	private String statutIntervention;
	private Checkbox checkboxReparation;
	private model.LigneIntervention ligneIntervention = new model.LigneIntervention();
	private JTextArea textAreaNote;
	private String statutReparation;
	private JTextPane textPaneNoteInter;

	public ModifIntervention(int idIntervention) {
		this.idIntervention = idIntervention;
		
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 25, 46, 14);
		add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBounds(56, 22, 86, 20);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblDemandeur = new JLabel("Demandeur :");
		lblDemandeur.setBounds(10, 50, 86, 14);
		add(lblDemandeur);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setBounds(10, 75, 86, 14);
		add(lblTlphone);
		
		JLabel lblDateDeLa = new JLabel("Date de la demande : ");
		lblDateDeLa.setBounds(10, 100, 132, 14);
		add(lblDateDeLa);
		
		textFieldDemandeur = new JTextField();
		textFieldDemandeur.setEditable(false);
		textFieldDemandeur.setBounds(88, 47, 86, 20);
		add(textFieldDemandeur);
		textFieldDemandeur.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setEditable(false);
		textFieldTel.setBounds(88, 72, 86, 20);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setEditable(false);
		textFieldDate.setBounds(138, 97, 86, 20);
		add(textFieldDate);
		textFieldDate.setColumns(10);

		vectLigneI = controller.ControllerDB.getLigneI(idIntervention);
		String fk, nom;
		for(int i = 0; i< vectLigneI.size(); i++){
			if (vectLigneI.elementAt(i).getFkTechnicien().equals("null"))
				nom = ControllerDB.getFkSocieteExt(vectLigneI.elementAt(i).getFkSocieteExtLI());
			else
				nom = ControllerDB.getFkTech(vectLigneI.elementAt(i).getFkTechnicien());
			vectLti.addElement(new LigneTableauLigneIntervention(vectLigneI.elementAt(i).getIdLigneIntervention(),vectLigneI.elementAt(i).getDateLigneIntervention(),nom, vectLigneI.elementAt(i).getDescriptionLigneIntervention()));	
	}

		modelLti = new ModelTableauLigneIntervention(vectLti);
	
		tableLti = new JTable(modelLti);
		tableLti.setAutoscrolls(true);
		tableLti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableLti.setAutoCreateRowSorter(true);
	
		JSP = new JScrollPane(tableLti);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(25, 150, 753, 180);
		tableLti.getColumn("idLigneIntervention").setMinWidth(0);
		tableLti.getColumn("idLigneIntervention").setMaxWidth(0);
		tableLti.getColumn("Date").setMinWidth(150);
		tableLti.getColumn("Date").setMaxWidth(150);
		tableLti.getColumn("Technicien").setMinWidth(150);
		tableLti.getColumn("Technicien").setMaxWidth(150);
	
		this.add(JSP);
		
		buttonOk = new JButton("OK");
		buttonOk.setBounds(25, 554, 89, 23);
		add(buttonOk);
		
		buttonRetour = new JButton("Retour");
		buttonRetour.setBounds(135, 554, 89, 23);
		add(buttonRetour);
		
		lblDateDeLintervention = new JLabel("Date de l'intervention :");
		lblDateDeLintervention.setBounds(25, 354, 130, 14);
		add(lblDateDeLintervention);
		
		radioButtonTech = new JRadioButton("Technicien :");
		radioButtonTech.setSelected(true);
		radioButtonTech.setBounds(25, 381, 97, 23);
		add(radioButtonTech);
		
		radioButtonSociete = new JRadioButton("Soci\u00E9t\u00E9 :");
		radioButtonSociete.setBounds(25, 412, 86, 23);
		add(radioButtonSociete);
		this.setVisible(true);
		
		buttongroup.add(radioButtonTech);
		buttongroup.add(radioButtonSociete);
		
		lblNote = new JLabel("Note : ");
		lblNote.setBounds(25, 447, 46, 14);
		add(lblNote);
		
		textAreaNote = new JTextArea();
		textAreaNote.setBounds(68, 442, 429, 101);
		add(textAreaNote);
		
		if (vectLti.size() == 0){
			radioButtonSociete.setEnabled(false);
		}
		
		comboBoxTechnicien = new JComboBox();
		comboBoxTechnicien.setBounds(128, 382, 125, 20);
		add(comboBoxTechnicien);
		
		comboBoxSociete = new JComboBox();
		comboBoxSociete.setEnabled(false);
		comboBoxSociete.setBounds(128, 413, 125, 20);
		add(comboBoxSociete);
		
		calendrier.setBounds(155, 348, 110, 20);
		calendrier.setDateFormatString("dd-MM-yyyy");
		add(calendrier);
		Date d1 = new Date();
		calendrier.setDate(d1);
		
		lblStatut = new JLabel("Statut :");
		lblStatut.setBounds(10, 125, 46, 14);
		add(lblStatut);
		
		textFieldStatut = new JTextField();
		textFieldStatut.setEditable(false);
		textFieldStatut.setBounds(56, 122, 118, 20);
		add(textFieldStatut);
		textFieldStatut.setColumns(10);
		
		radioButtonStatutSE = new JRadioButton("Avis Soci\u00E9t\u00E9 ext\u00E9rieur");
		radioButtonStatutSE.setBounds(537, 463, 195, 23);
		add(radioButtonStatutSE);
		
		radioButtonStatutEC = new JRadioButton("En cours");
		radioButtonStatutEC.setBounds(537, 443, 109, 23);
		add(radioButtonStatutEC);
		
		radioButtonStatutT = new JRadioButton("Termin\u00E9");
		radioButtonStatutT.setBounds(537, 511, 109, 23);
		add(radioButtonStatutT);
		
		radioButtonStatutSuspendu = new JRadioButton("Suspendu");
		radioButtonStatutSuspendu.setBounds(537, 485, 109, 23);
		add(radioButtonStatutSuspendu);
		
		buttongroupStatut.add(radioButtonStatutEC);
		buttongroupStatut.add(radioButtonStatutSE);
		buttongroupStatut.add(radioButtonStatutT);
		buttongroupStatut.add(radioButtonStatutSuspendu);
		
		checkboxReparation = new Checkbox("En r\u00E9paration");
		checkboxReparation.setBounds(537, 382, 95, 22);
		add(checkboxReparation);
		
		textPaneNoteInter = new JTextPane();
		textPaneNoteInter.setEditable(false);
		textPaneNoteInter.setBounds(289, 19, 366, 95);
		add(textPaneNoteInter);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(205, 25, 86, 14);
		add(lblDescription);
		
		getIntervention(idIntervention);
		
		MonGestionnaire itemListener = new MonGestionnaire();
		radioButtonSociete.addItemListener(itemListener);
		radioButtonTech.addItemListener(itemListener);
		
		MyButtonListener list = new MyButtonListener();
		buttonOk.addActionListener(list);
		buttonRetour.addActionListener(list);

	}

	private void getIntervention(int idIntervention) {
		intervention = ControllerDB.getRIntervention(idIntervention);
		textFieldNom.setText(intervention.getNomMateriel());
		textFieldDemandeur.setText(intervention.getNomDemandeurIntervention());
		textFieldTel.setText(intervention.getNumTelDemandeurIntervention());
		textPaneNoteInter.setText(intervention.getDescriptionProbleme());
		String date, jour, mois, annee;
		annee = intervention.getDateDemandeIntervention().substring(0, 4);
		mois = intervention.getDateDemandeIntervention().substring(5, 7);
		jour = intervention.getDateDemandeIntervention().substring(8, 10);
		date = jour + "-" + mois + "-" + annee;
		textFieldDate.setText(date);
		textFieldStatut.setText(intervention.getStatutIntervention());

		if (intervention.getStatutIntervention().equals("En cours"))
			radioButtonStatutEC.setSelected(true);
		if (intervention.getStatutIntervention().equals(
				"Avis Société extérieur"))
			radioButtonSociete.setSelected(true);
		if (intervention.getStatutIntervention().equals("Suspendu"))
			radioButtonStatutSuspendu.setSelected(true);
		if (intervention.getStatutIntervention().equals("Terminé"))
			radioButtonStatutT.setSelected(true);

		if (intervention.getStatutMateriel().equals("En réparation"))
			checkboxReparation.setState(true);

		remplirComboTech();
		remplirComboSocExt();
	}

	private void remplirComboSocExt() {
		vectSocExt = controller.ControllerDB.getSocExt();
		for (int i = 0; i < this.vectSocExt.size(); i++) {
			comboBoxSociete.addItem(vectSocExt.elementAt(i).getNomSocieteExt());
		}

	}

	private void remplirComboTech() {
		vectTech = controller.ControllerDB.getTechnicien();
		for (int i = 0; i < this.vectTech.size(); i++) {
			comboBoxTechnicien.addItem(vectTech.elementAt(i).getNomTechnicien()
					+ " " + vectTech.elementAt(i).getPrenomTechnicien());
		}

	}

	private class MonGestionnaire implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// on recupère l'objet
			if (e.getSource() == radioButtonSociete
					|| e.getSource() == radioButtonTech) {
				// remplir le combobox des modeles
				if (radioButtonTech.isSelected() == true) {
					comboBoxTechnicien.enable(true);
					comboBoxSociete.enable(false);
				} else {
					comboBoxTechnicien.enable(false);
					comboBoxSociete.enable(true);
				}

			}
		}
	}

	private boolean modifierIntervention() {
		if (textAreaNote.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Veuillez remplir le champs 'Note'", "Erreur de note",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			int positionFin;
			int longueurCaractere="'".length();
			String resultat="";
			String chaine = textAreaNote.getText();

			while( (positionFin=chaine.indexOf("\'"))!=(-1)) {
			resultat=resultat+chaine.substring(0,positionFin)+"\\'";
			chaine=chaine.substring(positionFin+longueurCaractere);
			}
			resultat=resultat+chaine;	
			ligneIntervention.setDescriptionLigneIntervention(resultat);
			Date d1 = calendrier.getDate();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = dateFormat.format(d1);
			ligneIntervention.setDateLigneIntervention(date);
			ligneIntervention.setFkIntervention(idIntervention);
			if (radioButtonTech.isSelected() == true) {
				String fkTech = vectTech.elementAt(
						comboBoxTechnicien.getSelectedIndex())
						.getIdTechnicien();
				ligneIntervention.setFkTechnicien(fkTech);
			} else {
				int fkSociete = vectSocExt.elementAt(
						comboBoxTechnicien.getSelectedIndex())
						.getIdSocieteExt();
				ligneIntervention.setFkSocieteExtLI(fkSociete);
				ligneIntervention.setFkTechnicien("null");
			}
			statutIntervention = "En cours";
			if (radioButtonStatutSE.isSelected() == true)
				statutIntervention = "Avis Société extérieur";
			if (radioButtonStatutEC.isSelected() == true)
				statutIntervention = "En cours";
			if (radioButtonStatutSuspendu.isSelected() == true)
				statutIntervention = "Suspendu";
			if (radioButtonStatutT.isSelected() == true)
				statutIntervention = "Terminé";
			if (checkboxReparation.getState() == true)
				statutReparation = "En réparation";
			else
				statutReparation = "Placé";
			return true;

		}
	}

	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == buttonOk) {
				if (modifierIntervention() == true) {
					try {

						switch (JOptionPane
								.showConfirmDialog(
										null,
										"Etes-vous sur de vouloir procéder à l'ajout de la ligne d'intervention?",
										"RESUME",
										JOptionPane.INFORMATION_MESSAGE)) {

						case JOptionPane.YES_OPTION:
							controller.ControllerDB
									.addLigneIntervention(ligneIntervention);
							controller.ControllerDB.updateStatutIntervention(
									idIntervention, statutIntervention);
							controller.ControllerDB.updateStatutReparation(
									intervention.getNomMateriel(),
									statutReparation);
							controller.GestionFenetre
									.eraseContainerPanelMainJFrame();
							controller.GestionFenetre
									.ModifIntervention(idIntervention);
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
			if (source == buttonRetour) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.ListIntervention();
			}

		}
	}
}
