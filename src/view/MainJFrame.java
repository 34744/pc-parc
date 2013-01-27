package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.*;

public class MainJFrame extends JFrame {

	private static JPanel contentPane;
	private Container cont;
	JMenuItem menuFichierQuitter;
	private JMenu menuMateriel, menuIntervention;
	private JMenuItem menuInsertMateriel, menuModifMateriel,
			menuInsertIntervention;
	private JMenuItem menuListIntervention;
	private JMenuItem menuListMateriel;
	private JMenuItem menuListMaterielTab;
	private JMenu menuModle;
	private JMenuItem menuNouveauModle;
	private JMenu menuAide;
	private JMenuItem menuIAide;

	// private Utilisateur user = new Utilisateur();

	public MainJFrame(Utilisateur user) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// connexion a la db
		// controller.ControllerDB.connectionDB();

		// titre de la fenêtre
		setTitle("InfoParc");
		// récupère le container
		cont = this.getContentPane();
		setBounds(200, 50, 800, 650);
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFichier = new JMenu("Fichier");
		menuBar.add(menuFichier);

		menuFichierQuitter = new JMenuItem("Quitter");
		menuFichier.add(menuFichierQuitter);

		menuMateriel = new JMenu("Mat\u00E9riel");

		menuInsertMateriel = new JMenuItem("Nouveau Mat\u00E9riel");

		menuModifMateriel = new JMenuItem("Modifier Mat\u00E9riel");

		menuListMateriel = new JMenuItem("Lister Mat\u00E9riel (Arbre)");
		
		menuListMaterielTab = new JMenuItem("Lister Mat\u00E9riel");

		menuIntervention = new JMenu("Intervention");

		menuInsertIntervention = new JMenuItem("Nouvelle Intervention");

		menuListIntervention = new JMenuItem("Lister Interventions");

		menuModle = new JMenu("Mod\u00E8le");

		menuNouveauModle = new JMenuItem("Nouveau mod\u00E8le");

		menuAide = new JMenu("?");

		menuIAide = new JMenuItem("Aide");

		if (user.getFonctionUser().equals("technique")) {
			menuBar.add(menuMateriel);
			menuMateriel.add(menuInsertMateriel);
			menuMateriel.add(menuModifMateriel);
			menuMateriel.add(menuListMaterielTab);
			menuMateriel.add(menuListMateriel);
			menuBar.add(menuIntervention);
			menuIntervention.add(menuInsertIntervention);
			menuIntervention.add(menuListIntervention);
			menuBar.add(menuModle);
			menuModle.add(menuNouveauModle);
			menuBar.add(menuAide);
			menuAide.add(menuIAide);
		}
		if (user.getFonctionUser().equals("helpdesk")) {
			menuBar.add(menuMateriel);
			menuMateriel.add(menuListMateriel);
			menuMateriel.add(menuListMaterielTab);
			menuBar.add(menuIntervention);
			menuIntervention.add(menuInsertIntervention);
			menuIntervention.add(menuListIntervention);
			menuBar.add(menuAide);
			menuAide.add(menuIAide);
		}

		// panel principal
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		// gestion de [X]
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				clotApplication();
			}
		});

		cont.add(contentPane);

		controller.GestionFenetre.initAccueil();

		this.setVisible(true);

		MyActionListener listener = new MyActionListener();

		menuFichierQuitter.addActionListener(listener);
		menuInsertMateriel.addActionListener(listener);
		menuModifMateriel.addActionListener(listener);
		menuInsertIntervention.addActionListener(listener);
		menuListIntervention.addActionListener(listener);
		menuListMateriel.addActionListener(listener);
		menuListMaterielTab.addActionListener(listener);
		menuNouveauModle.addActionListener(listener);
		menuIAide.addActionListener(listener);
	}

	private class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == menuFichierQuitter)
				clotApplication();
			if (source == menuInsertMateriel) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.AjoutMateriel();
			}
			if (source == menuModifMateriel) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.ModifMateriel();
			}
			if (source == menuListMateriel) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.ListMateriel();
			}
			if (source == menuListMaterielTab) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.ListMaterielTab();
			}
			if (source == menuInsertIntervention) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.AjoutIntervention();
			}
			if (source == menuListIntervention) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.ListIntervention();
			}
			if (source == menuNouveauModle) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.AjoutModele();
			}
			if (source == menuIAide) {
				try {

					Runtime.getRuntime().exec(
							"explorer.exe " + ".\\aide\\aide.pdf");
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		}
	}

	public static void refreshPanelPrincipal() {
		contentPane.repaint();
		contentPane.setVisible(false);
		contentPane.setVisible(true);
	}

	public static void eraseContainerPanel() {
		try {
			contentPane.remove(contentPane.getComponent(0));
			refreshPanelPrincipal();

		} catch (ArrayIndexOutOfBoundsException error) {
			JOptionPane.showMessageDialog(null, error,
					"Erreur ArrayIndexOutOfBoundsException",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void setContainerPanel(Component arg0) {
		contentPane.add(arg0);
	}

	public void clotApplication() {
		if (model.AccesDB.getConnection() != null)
			controller.ControllerDB.fermetureDB();
		System.exit(0);
	}

}
