package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import controller.ControllerDB;

public class MajData {

	public static void MajDesactivation(String materiel) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String instructionSQL = "UPDATE Materiel SET statutMateriel = 'Désactivé' WHERE nomMateriel = '"
					+ materiel + "'";
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"Le matériel a bien été désactivé", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void MajMateriel(Materiel matos) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();
			String instructionSQL;

			if (matos.getDateInstallation().equals("null")){
				instructionSQL = "UPDATE Materiel SET numSerieMateriel = '"
						+ matos.getNumSerieMateriel() + "', adresseMac = '"
						+ matos.getAdresseMac() + "', dureeGarantie = "
						+ matos.getDureeGarantie() + ", fkImageW = '"
						+ matos.getFkImageW() + "', noteMateriel = '"
						+ matos.getNoteMateriel() + "', adresseIp = '"
						+ matos.getAdresseIp() + "', fkLocalS = "
						+ matos.getFkLocalS() + ", fkMateriel = '"
						+ matos.getFkMateriel() + "' WHERE nomMateriel = '"
						+ matos.getNomMateriel() + "'";
			}else{
				instructionSQL = "UPDATE Materiel SET numSerieMateriel = '"
					+ matos.getNumSerieMateriel() + "', dateInstallation = '"
					+ matos.getDateInstallation() + "', adresseMac = '"
					+ matos.getAdresseMac() + "', dureeGarantie = "
					+ matos.getDureeGarantie() + ", fkImageW = '"
					+ matos.getFkImageW() + "', noteMateriel = '"
					+ matos.getNoteMateriel() + "', adresseIp = '"
					+ matos.getAdresseIp() + "', fkLocalS = "
					+ matos.getFkLocalS() + ", fkMateriel = '"
					+ matos.getFkMateriel() + "' WHERE nomMateriel = '"
					+ matos.getNomMateriel() + "'";
			}	
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"La mise à jour a bien été effectuée", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void MajStatutIntervention(int idIntervention,
			String statutIntervention) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String instructionSQL = "UPDATE Intervention SET statutIntervention = '" + statutIntervention + "' WHERE idIntervention = "
					+ idIntervention;			
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"La mise à jour a bien été effectuée", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void MajStatutReparation(String nomMateriel,
			String statutReparation) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String instructionSQL = "UPDATE Materiel SET statutMateriel = '" + statutReparation + "' WHERE nomMateriel = '"
					+ nomMateriel + "'";
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"La mise à jour a bien été effectuée", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
