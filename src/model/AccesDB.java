package model;

import java.sql.*;

import javax.swing.JOptionPane;

public class AccesDB {

	private static Connection connexion;

	public static Connection GetInstance() {
		// si la connection n'a pas encore ete cree alors on appele la fenetre
		// de connection
		// sinon on retourne l'object deja cree
		if (connexion == null) {
			accessDB();
		}

		return connexion;
	}

	public static Connection getConnection() {
		return connexion;
	}

	public static void closeBD() {
		try {
			GetInstance().close();

		} catch (SQLException sqlE) {
			JOptionPane.showMessageDialog(null, sqlE, "Erreur Fermeture BD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void accessDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException classNotFound) {
			JOptionPane.showMessageDialog(null, classNotFound, "Erreur Driver",
					JOptionPane.ERROR_MESSAGE);
		}

		try {

			connexion = DriverManager.getConnection("jdbc:mysql://localhost/pcparc",
					"root", "");

		} catch (SQLException sqlE) {
			JOptionPane.showMessageDialog(null, sqlE, "Erreur Ouverture BD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
