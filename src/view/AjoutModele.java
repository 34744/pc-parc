package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.ControllerDB;

import model.ModeleMateriel;

public class AjoutModele extends JPanel {
	
	private JComboBox comboBoxType, comboBoxMarque;
	private Vector<model.TypeMateriel> vectType;
	private Vector<model.Marque> vectMarque;
	private JTextField textField;
	private JButton btnValider, btnRetour;
	private ModeleMateriel modele = new ModeleMateriel();

	public AjoutModele() {
		setLayout(null);

		JLabel labelType = new JLabel("Type :");
		labelType.setBounds(10, 25, 46, 14);
		add(labelType);

		comboBoxType = new JComboBox();
		comboBoxType.setBounds(70, 22, 126, 20);
		add(comboBoxType);
		
		JLabel labelMarque = new JLabel("Marque :");
		labelMarque.setBounds(10, 50, 51, 14);
		add(labelMarque);

		comboBoxMarque = new JComboBox();
		comboBoxMarque.setBounds(70, 47, 126, 20);
		add(comboBoxMarque);
		
		JLabel labelModele = new JLabel("Mod\u00E8le :");
		labelModele.setBounds(10, 75, 70, 14);
		add(labelModele);
		
		textField = new JTextField();
		textField.setBounds(70, 72, 126, 20);
		add(textField);
		textField.setColumns(10);
		
		btnValider = new JButton("OK");
		btnValider.setBounds(37, 252, 89, 23);
		add(btnValider);
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(136, 252, 89, 23);
		add(btnRetour);
		
		getVectType();
		getVectMarque();
		
		MyButtonListener list = new MyButtonListener();
		btnValider.addActionListener(list);
		btnRetour.addActionListener(list);

	}
	
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
	
	private boolean ajouterModele(){
		if (textField.getText() == null){
			JOptionPane.showMessageDialog(null,
					"Veuillez remplir le champs 'modèle'", "Erreur de nom",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}else{
			modele.setNomModeleMateriel(textField.getText());
			modele.setFkMarque(ControllerDB.getFkMarque(comboBoxMarque.getSelectedItem().toString()));
			modele.setFkTypeMateriel(ControllerDB.getFkType(comboBoxType.getSelectedItem().toString()));
			return true;
		}
	}
	
	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == btnValider) {
				if (ajouterModele() == true) {

					try {

						switch (JOptionPane
								.showConfirmDialog(
										null,
										"Etes-vous sur de vouloir procéder à l'ajout du modèle?",
										"RESUME",
										JOptionPane.INFORMATION_MESSAGE)) {

						case JOptionPane.YES_OPTION:
							controller.ControllerDB.addModele(modele);
							controller.GestionFenetre
									.eraseContainerPanelMainJFrame();
							controller.GestionFenetre.AjoutModele();
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
			if (source == btnRetour) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.initAccueil();
			}

		}
	}

}
