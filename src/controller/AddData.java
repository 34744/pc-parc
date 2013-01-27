package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Intervention;
import model.LigneIntervention;
import model.Materiel;
import model.ModeleMateriel;

public class AddData {

	public static void addMateriel(Materiel matos) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String instructionSQL = "INSERT INTO Materiel "
					+ "(nomMateriel,"
					+ "numSerieMateriel, dateAchat, dureeGarantie, statutMateriel, adresseMac, noteMateriel, fkModeleMateriel, fkLocalS, fkBudget, fkFournisseur) "
					+ " VALUES ('"
					+ matos.getNomMateriel()
					+ "','"
					+ matos.getNumSerieMateriel()
					+ "','"
					+ matos.getDateAchat()
					+ "',"
					+ matos.getDureeGarantie()
					+ ",'"
					+ matos.getStatutMateriel()
					+ "','"
					+ matos.getAdresseMac()
					+ "','"
					+ matos.getNoteMateriel()
					+ "',"
					+ matos.getFkModeleMateriel()
					+ ","
					+ matos.getFkLocalS()
					+ ",'"
					+ matos.getFkBudget()
					+ "',"
					+ matos.getFkSocieteExt() + ")";
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"L'enregistrement a bien été effectué", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void addIntervention(Intervention intervention) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String instructionSQL = "INSERT INTO Intervention "
					+ "(StatutIntervention,"
					+ "DescriptionProbleme, nomDemandeurIntervention, numTelDemandeurIntervention, dateDemandeIntervention, fkMateriel) "
					+ " VALUES ('" + intervention.getStatutIntervention()
					+ "','" + intervention.getDescriptionProbleme() + "','"
					+ intervention.getNomDemandeurIntervention() + "','"
					+ intervention.getNumTelDemandeurIntervention() + "','"
					+ intervention.getDateDemandeIntervention() + "','"
					+ intervention.getFkMateriel() + "')";
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"L'enregistrement a bien été effectué", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void AddLigneIntervention(LigneIntervention ligneIntervention) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String instructionSQL = "INSERT INTO LigneIntervention "
					+ "(descriptionLigneIntervention,"
					+ "dateLigneIntervention, fkIntervention, fkTechnicien, fkSocieteExtLI) "
					+ " VALUES ('"
					+ ligneIntervention.getDescriptionLigneIntervention()
					+ "','" + ligneIntervention.getDateLigneIntervention()
					+ "'," + ligneIntervention.getFkIntervention() + ",'"
					+ ligneIntervention.getFkTechnicien() + "',";
			if ( ligneIntervention.getFkSocieteExtLI() == 0){
				instructionSQL +=  "NULL)";
			}else{
				instructionSQL += ligneIntervention.getFkSocieteExtLI() + ")";
			}
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"L'enregistrement a bien été effectué", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void addModele(ModeleMateriel modele) {
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String instructionSQL = "INSERT INTO ModeleMateriel "
					+ "(NomModeleMateriel,"
					+ "FkTypeMateriel, fkMarque) "
					+ " VALUES ('" + modele.getNomModeleMateriel()
					+ "'," + modele.getFkTypeMateriel() + ","
					+ modele.getFkMarque() + ")";
			int nbIns = stat.executeUpdate(instructionSQL);
			JOptionPane.showMessageDialog(null,
					"L'enregistrement a bien été effectué", "Enregistrement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
