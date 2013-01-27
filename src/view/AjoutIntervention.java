package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class AjoutIntervention extends JPanel {
	
	private JComboBox comboBoxType, comboBoxNom;
	private Vector<model.TypeMateriel> vectType;
	private Vector<model.Materiel> vectMateriel;
	JDateChooser calendrier = new JDateChooser();
	private JTextField textFieldNom;
	private JTextField textFieldTelephone;
	private JTextField textStatut;
	private JButton buttonOK, buttonAnnule;
	private JTextPane textPane;
	private model.Intervention intervention = new model.Intervention();

	public AjoutIntervention() {
		setLayout(null);
		
		JLabel labelType = new JLabel("Type :");
		labelType.setBounds(10, 25, 46, 14);
		add(labelType);
		
		comboBoxType = new JComboBox();
		comboBoxType.setBounds(64, 22, 100, 20);
		add(comboBoxType);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 50, 46, 14);
		add(lblNom);
		
		comboBoxNom = new JComboBox();
		comboBoxNom.setBounds(64, 47, 100, 20);
		add(comboBoxNom);
		
		JLabel labeldate = new JLabel("Date de cr\u00E9ation :");
		labeldate.setBounds(10, 75, 124, 14);
		add(labeldate);
		
		calendrier.setBounds(119, 69, 110, 20);
		calendrier.setDateFormatString("dd-MM-yyyy");
		add(calendrier);
		
		JLabel labelNom = new JLabel("Nom du demandeur :");
		labelNom.setBounds(10, 100, 124, 14);
		add(labelNom);
		
		JLabel lblTlphoneDuDemandeur = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphoneDuDemandeur.setBounds(10, 125, 78, 14);
		add(lblTlphoneDuDemandeur);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setBounds(10, 150, 46, 14);
		add(lblStatut);
		
		JLabel lblDescriptionDuProblme = new JLabel("Description du probl\u00E8me : ");
		lblDescriptionDuProblme.setBounds(10, 175, 164, 14);
		add(lblDescriptionDuProblme);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(142, 97, 110, 20);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setBounds(88, 122, 100, 20);
		add(textFieldTelephone);
		textFieldTelephone.setColumns(10);
		
		textStatut = new JTextField();
		textStatut.setText("Non commenc\u00E9");
		textStatut.setEditable(false);
		textStatut.setBounds(88, 147, 100, 20);
		add(textStatut);
		textStatut.setColumns(10);
		
		textPane = new JTextPane();
		textPane.setBounds(162, 169, 295, 80);
		add(textPane);
		
		buttonOK = new JButton("OK");
		buttonOK.setBounds(47, 530, 89, 23);
		add(buttonOK);

		buttonAnnule = new JButton("Retour");
		buttonAnnule.setBounds(146, 530, 89, 23);
		add(buttonAnnule);
		
		getVectType();
		getVectNom();
		remplirCalendrier();
		
		MyButtonListener list = new MyButtonListener();
		buttonOK.addActionListener(list);
		buttonAnnule.addActionListener(list);

		MonGestionnaire itemListener = new MonGestionnaire();
		comboBoxType.addItemListener(itemListener);

	}
	
	private class MonGestionnaire implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == comboBoxType){	
				if (e.getStateChange() == ItemEvent.SELECTED)
					getVectNom();
			}
		}
	}
	
	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == buttonOK) {
				if (ajouterIntervention() == true) {

					try {

						switch (JOptionPane
								.showConfirmDialog(
										null,
										intervention
												+ "\n\nEtes-vous sur de vouloir procéder à l'ajout?",
										"RESUME",
										JOptionPane.INFORMATION_MESSAGE)) {

						case JOptionPane.YES_OPTION:
							controller.ControllerDB.addIntervention(intervention);
							controller.GestionFenetre
								.eraseContainerPanelMainJFrame();
							controller.GestionFenetre.AjoutIntervention();
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
	
	public boolean ajouterIntervention(){
		if (textPane.getText().equals("")){
			JOptionPane.showMessageDialog(null,
					"Veuillez remplir le champs 'Description du problème'", "Erreur de description",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else{
		intervention.setStatutIntervention(textStatut.getText());
		intervention.setDescriptionProbleme(textPane.getText());
		intervention.setNomDemandeurIntervention(textFieldNom.getText());
		intervention.setNumTelDemandeurIntervention(textFieldTelephone.getText());
		Date d1 = calendrier.getDate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(d1);
		intervention.setDateDemandeIntervention(date);
		intervention.setFkMateriel(comboBoxNom.getSelectedItem().toString());
		return true;
		}
	}
	
	public void remplirCalendrier(){
		Date d1 = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(d1);
		calendrier.setDate(d1);
	}
	
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
}
