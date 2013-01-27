package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDB;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.MaterielArbre;
import javax.swing.JTextPane;

public class ListerMateriel extends JPanel {

	private JTree tree;
	private Vector<model.MaterielArbre> vectMatos = new Vector<model.MaterielArbre>();
	private MaterielArbre materielArbre = new MaterielArbre();
	private JButton btnRetour;
	private JTextField textFieldNom;
	private JLabel lblNom;
	private JLabel lblNumroDeSrie;
	private JTextField textFieldNumSerie;
	private JLabel lblDateDeLachat;
	private JTextField textFieldDateAchat;
	private JLabel lblDureDeLa;
	private JTextField textFieldGarantie;
	private JLabel lblMois;
	private JLabel lblDateDeLinstallation;
	private JTextField textFieldDateInstall;
	private JLabel lblStatutmateriel;
	private JTextField textFieldStatut;
	private JLabel lblAdresseMac;
	private JLabel lblAdresseIp;
	private JTextField textFieldAdresseMac;
	private JTextField textFieldAdresseIP;
	private JLabel lblType;
	private JTextField textFieldType;
	private JLabel lblModle;
	private JTextField textFieldModele;
	private JLabel lblMarque;
	private JTextField textFieldMarque;
	private JLabel lblSite;
	private JLabel lblService;
	private JLabel lblLocal;
	private JTextField textFieldSite;
	private JTextField textFieldService;
	private JTextField textFieldLocal;
	private JLabel lblNote;
	private JTextPane textPaneNote;

	public ListerMateriel() {
		setLayout(null);

		buildTree();

		btnRetour = new JButton("Retour");
		btnRetour.setBounds(135, 554, 89, 23);
		add(btnRetour);

		lblNom = new JLabel("Nom :");
		lblNom.setBounds(342, 12, 37, 14);
		add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBounds(380, 9, 127, 20);
		add(textFieldNom);
		textFieldNom.setColumns(10);

		lblNumroDeSrie = new JLabel("Num\u00E9ro de s\u00E9rie:");
		lblNumroDeSrie.setBounds(342, 38, 101, 14);
		add(lblNumroDeSrie);

		textFieldNumSerie = new JTextField();
		textFieldNumSerie.setEditable(false);
		textFieldNumSerie.setBounds(441, 35, 127, 20);
		add(textFieldNumSerie);
		textFieldNumSerie.setColumns(10);

		lblDateDeLachat = new JLabel("Date de l'achat:");
		lblDateDeLachat.setBounds(342, 64, 101, 14);
		add(lblDateDeLachat);

		textFieldDateAchat = new JTextField();
		textFieldDateAchat.setEditable(false);
		textFieldDateAchat.setBounds(434, 61, 101, 20);
		add(textFieldDateAchat);
		textFieldDateAchat.setColumns(10);

		lblDureDeLa = new JLabel("Garantie :");
		lblDureDeLa.setBounds(342, 89, 58, 14);
		add(lblDureDeLa);

		textFieldGarantie = new JTextField();
		textFieldGarantie.setEditable(false);
		textFieldGarantie.setBounds(401, 86, 30, 20);
		add(textFieldGarantie);
		textFieldGarantie.setColumns(10);

		lblMois = new JLabel("mois");
		lblMois.setBounds(444, 89, 46, 14);
		add(lblMois);

		lblDateDeLinstallation = new JLabel("Date de l'installation :");
		lblDateDeLinstallation.setBounds(342, 114, 139, 14);
		add(lblDateDeLinstallation);

		textFieldDateInstall = new JTextField();
		textFieldDateInstall.setEditable(false);
		textFieldDateInstall.setBounds(464, 111, 86, 20);
		add(textFieldDateInstall);
		textFieldDateInstall.setColumns(10);

		lblStatutmateriel = new JLabel("Statut:");
		lblStatutmateriel.setBounds(342, 139, 46, 14);
		add(lblStatutmateriel);

		textFieldStatut = new JTextField();
		textFieldStatut.setEditable(false);
		textFieldStatut.setBounds(388, 136, 119, 20);
		add(textFieldStatut);
		textFieldStatut.setColumns(10);

		lblAdresseMac = new JLabel("Adresse Mac :");
		lblAdresseMac.setBounds(342, 164, 83, 14);
		add(lblAdresseMac);

		lblAdresseIp = new JLabel("Adresse IP :");
		lblAdresseIp.setBounds(342, 189, 83, 14);
		add(lblAdresseIp);

		textFieldAdresseMac = new JTextField();
		textFieldAdresseMac.setEditable(false);
		textFieldAdresseMac.setBounds(436, 161, 114, 20);
		add(textFieldAdresseMac);
		textFieldAdresseMac.setColumns(10);

		textFieldAdresseIP = new JTextField();
		textFieldAdresseIP.setEditable(false);
		textFieldAdresseIP.setBounds(433, 186, 117, 20);
		add(textFieldAdresseIP);
		textFieldAdresseIP.setColumns(10);

		lblType = new JLabel("Type :");
		lblType.setBounds(590, 12, 37, 14);
		add(lblType);

		textFieldType = new JTextField();
		textFieldType.setEditable(false);
		textFieldType.setBounds(626, 9, 139, 20);
		add(textFieldType);
		textFieldType.setColumns(10);

		lblModle = new JLabel("Mod\u00E8le : ");
		lblModle.setBounds(590, 38, 58, 14);
		add(lblModle);

		textFieldModele = new JTextField();
		textFieldModele.setEditable(false);
		textFieldModele.setBounds(650, 35, 115, 20);
		add(textFieldModele);
		textFieldModele.setColumns(10);

		lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(590, 64, 58, 14);
		add(lblMarque);

		textFieldMarque = new JTextField();
		textFieldMarque.setEditable(false);
		textFieldMarque.setBounds(646, 61, 119, 20);
		add(textFieldMarque);
		textFieldMarque.setColumns(10);

		lblSite = new JLabel("Site :");
		lblSite.setBounds(590, 89, 37, 14);
		add(lblSite);

		lblService = new JLabel("Service :");
		lblService.setBounds(590, 114, 58, 14);
		add(lblService);

		lblLocal = new JLabel("Local :");
		lblLocal.setBounds(590, 139, 37, 14);
		add(lblLocal);

		textFieldSite = new JTextField();
		textFieldSite.setEditable(false);
		textFieldSite.setBounds(626, 86, 139, 20);
		add(textFieldSite);
		textFieldSite.setColumns(10);

		textFieldService = new JTextField();
		textFieldService.setEditable(false);
		textFieldService.setBounds(649, 111, 116, 20);
		add(textFieldService);
		textFieldService.setColumns(10);

		textFieldLocal = new JTextField();
		textFieldLocal.setEditable(false);
		textFieldLocal.setBounds(634, 136, 131, 20);
		add(textFieldLocal);
		textFieldLocal.setColumns(10);

		lblNote = new JLabel("Note :");
		lblNote.setBounds(342, 212, 37, 14);
		add(lblNote);

		textPaneNote = new JTextPane();
		textPaneNote.setEditable(false);
		textPaneNote.setBounds(380, 214, 339, 118);
		add(textPaneNote);

		MyButtonListener list = new MyButtonListener();
		btnRetour.addActionListener(list);

	}

	private void remplirMateriel(String materiel) {
		String date, jour, mois, annee;
		materielArbre = ControllerDB.getMaterielArbre(materiel);
		textFieldNom.setText(materielArbre.getNomMateriel());
		textFieldNumSerie.setText(materielArbre.getNumSerieMateriel());
		if (materielArbre.getDateAchat() != null) {
			annee = materielArbre.getDateAchat().substring(0, 4);
			mois = materielArbre.getDateAchat().substring(5, 7);
			jour = materielArbre.getDateAchat().substring(8, 10);
			date = jour + "-" + mois + "-" + annee;
			textFieldDateAchat.setText(date);
		}
		textFieldGarantie.setText(String.valueOf(materielArbre
				.getDureeGarantie()));
		if (materielArbre.getDateInstallation() != null) {
			annee = materielArbre.getDateInstallation().substring(0, 4);
			mois = materielArbre.getDateInstallation().substring(5, 7);
			jour = materielArbre.getDateInstallation().substring(8, 10);
			date = jour + "-" + mois + "-" + annee;
			textFieldDateInstall.setText(date);
		}
		textFieldStatut.setText(materielArbre.getStatutMateriel());
		textFieldAdresseMac.setText(materielArbre.getAdresseMac());
		if (materielArbre.getAdresseIp() != null) {
			if (materielArbre.getAdresseIp().equals("null") != true)
				textFieldAdresseIP.setText(materielArbre.getAdresseIp());
		} else
			textFieldAdresseIP.setText("");
		textPaneNote.setText(materielArbre.getNoteMateriel());
		textFieldType.setText(materielArbre.getNomTypeMateriel());
		textFieldModele.setText(materielArbre.getNomModeleMateriel());
		textFieldMarque.setText(materielArbre.getNomMarque());
		textFieldSite.setText(materielArbre.getNomSite());
		textFieldService.setText(materielArbre.getNomService());
		textFieldLocal.setText(materielArbre.getNomLocal());
	}

	private void buildTree() {
		vectMatos = ControllerDB.getMaterielArbre();
		String tpsSite, tpsService, tpsType;
		// Création d'une racine
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("HIS");
		int i = 0;
		while (i < vectMatos.size()) {
			tpsSite = vectMatos.elementAt(i).getNomSite();
			DefaultMutableTreeNode rep = new DefaultMutableTreeNode(vectMatos
					.elementAt(i).getNomSite());
			while (i < vectMatos.size()
					&& tpsSite.equals(vectMatos.elementAt(i).getNomSite())) {
				tpsService = vectMatos.elementAt(i).getNomService();
				DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode(
						vectMatos.elementAt(i).getNomService() + " ("
								+ vectMatos.elementAt(i).getLibelleServiceFR()
								+ ")");
				while (i < vectMatos.size()
						&& tpsSite.equals(vectMatos.elementAt(i).getNomSite())
						&& tpsService.equals(vectMatos.elementAt(i)
								.getNomService())) {
					tpsType = vectMatos.elementAt(i).getNomTypeMateriel();
					DefaultMutableTreeNode rep3 = new DefaultMutableTreeNode(
							vectMatos.elementAt(i).getNomTypeMateriel());
					while (i < vectMatos.size()
							&& tpsSite.equals(vectMatos.elementAt(i)
									.getNomSite())
							&& tpsService.equals(vectMatos.elementAt(i)
									.getNomService())
							&& tpsType.equals(vectMatos.elementAt(i)
									.getNomTypeMateriel())) {
						rep3.add(new DefaultMutableTreeNode(vectMatos
								.elementAt(i).getNomMateriel()));
						i++;
					}
					rep2.add(rep3);
				}
				rep.add(rep2);
			}
			racine.add(rep);
		}
		tree = new JTree(racine);
		tree.setBounds(10, 11, 308, 486);		

		//this.add(tree);
		
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(10, 11, 308, 486);

		this.add(JSP);

		tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent event) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();
				if (node.isLeaf()) {
					remplirMateriel(tree.getLastSelectedPathComponent()
							.toString());
				}
			}
		});
	}

	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == btnRetour) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.initAccueil();
			}

		}
	}
}
