package model;

import java.sql.*;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

public class GetData {

	public static Vector<TypeMateriel> getTypeModele() {
		Vector<model.TypeMateriel> v = new Vector<model.TypeMateriel>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT idTypeMateriel, NomTypeMateriel FROM typemateriel ORDER BY nomTypeMateriel";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.addElement(new TypeMateriel(donnees.getInt("idTypeMateriel"),
						donnees.getString("NomTypeMateriel")));
				// System.out.println(donnees.getString("NomTypeMateriel"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Marque> getMarque() {
		Vector<model.Marque> v = new Vector<model.Marque>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM marque ORDER BY nomMarque";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.addElement(new Marque(donnees.getInt("idNomMarque"), donnees
						.getString("nomMarque"), donnees
						.getString("siteInternetMarque")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Materiel> getMateriel(String nom) {
		Vector<model.Materiel> v = new Vector<model.Materiel>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Materiel,TypeMateriel,ModeleMateriel WHERE Materiel.fkModeleMateriel = ModeleMateriel.IdModeleMateriel AND ModeleMateriel.fkTypeMateriel = TypeMateriel.idTypeMateriel AND statutMateriel NOT LIKE 'Désactivé'";
			if (nom.equals("Tous") == false) {
				requeteSQL += " AND TypeMateriel.NomTypeMateriel = '" + nom
						+ "'";
			}
			requeteSQL += "ORDER BY nomMateriel";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new Materiel(donnees.getString("nomMateriel"),
						donnees.getString("numSerieMateriel"), donnees
								.getString("statutMateriel"), donnees
								.getString("adresseIp"), donnees
								.getString("adresseMac"), donnees
								.getString("noteMateriel"), donnees
								.getString("fkMateriel"), donnees
								.getString("fkDomaineReseau"), donnees
								.getString("fkBudget"), donnees
								.getString("fkImageW"), donnees
								.getInt("dureeGarantie"), donnees
								.getInt("fkModeleMateriel"), donnees
								.getInt("fkLocalS"), donnees
								.getString("dateAchat"), donnees
								.getString("dateInstallation"), donnees
								.getInt("fkFournisseur")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<ModeleMateriel> getModeleMateriel(String type,
			String marque) {
		Vector<model.ModeleMateriel> v = new Vector<model.ModeleMateriel>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM ModeleMateriel, TypeMateriel, Marque WHERE nomTypeMateriel = '"
					+ type
					+ "' AND nomMarque = '"
					+ marque
					+ "' AND fkTypeMateriel = idTypeMateriel AND fkMarque = idNomMarque ORDER BY nomModeleMateriel";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.addElement(new ModeleMateriel(donnees
						.getInt("idModeleMateriel"), donnees
						.getString("nomModeleMateriel"), donnees
						.getInt("fkTypeMateriel"), donnees.getInt("fkMarque")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static int getFkModeleMateriel(String modele) {
		int fk = 0;
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM ModeleMateriel WHERE nomModeleMateriel = '"
					+ modele + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				fk = donnees.getInt("idModeleMateriel");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return fk;
	}

	public static Vector<Budget> getBudget() {
		Vector<model.Budget> v = new Vector<model.Budget>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT numBudget, fkTypeBudget FROM Budget ORDER BY numBudget";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.addElement(new Budget(donnees.getString("numBudget"), donnees
						.getInt("fkTypeBudget")));
				// System.out.println(donnees.getString("NomTypeMateriel"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<SocieteExt> getFournisseur() {
		Vector<model.SocieteExt> v = new Vector<model.SocieteExt>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM SocieteExt WHERE typeSocieteExt = 'Fournisseur' ORDER BY nomSocieteExt";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.addElement(new SocieteExt(donnees.getInt("idSocieteExt"),
						donnees.getString("nomSocieteExt")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static int getFkFournisseur(String nomFournisseur) {
		int fk = 0;
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM SocieteExt WHERE nomSocieteExt = '"
					+ nomFournisseur + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				fk = donnees.getInt("idSocieteExt");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return fk;
	}

	public static Vector<model.Materiel> getMatos(String nom) {
		Vector<model.Materiel> v = new Vector<model.Materiel>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Materiel WHERE nomMateriel = '"
					+ nom + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.addElement(new Materiel(donnees.getString("nomMateriel"),
						donnees.getString("numSerieMateriel"), donnees
								.getString("statutMateriel"), donnees
								.getString("adresseIp"), donnees
								.getString("adresseMac"), donnees
								.getString("noteMateriel"), donnees
								.getString("fkMateriel"), donnees
								.getString("fkDomaineReseau"), donnees
								.getString("fkBudget"), donnees
								.getString("fkImageW"), donnees
								.getInt("dureeGarantie"), donnees
								.getInt("fkModeleMateriel"), donnees
								.getInt("fkLocalS"), donnees
								.getString("dateAchat"), donnees
								.getString("dateInstallation"), donnees
								.getInt("fkFournisseur")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<ImageWindows> getImageWr() {
		Vector<model.ImageWindows> v = new Vector<model.ImageWindows>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM ImageWindows ORDER BY nomImageW";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.addElement(new ImageWindows(donnees.getString("nomImageW"),
						donnees.getString("typeImageW")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Site> getSite() {
		Vector<model.Site> v = new Vector<model.Site>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Site ORDER BY nomSite";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new Site(donnees.getString("codeSite"), donnees
						.getString("nomSite"), donnees.getString("adresseSite")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Service> getService(String service) {
		Vector<model.Service> v = new Vector<model.Service>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Site, Service WHERE fkSite = codeSite AND nomSite = '"
					+ service + "'  ORDER BY nomService";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new Service(donnees.getString("nomService"),
						donnees.getString("libelleServiceFR"), donnees
								.getString("libelleServiceNL"), donnees
								.getString("fkSite")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Local> getLocal(String service) {
		Vector<model.Local> v = new Vector<model.Local>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Local, Service WHERE fkService = nomService AND nomService = '"
					+ service + "'  ORDER BY nomLocal";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new Local(donnees.getInt("idLocal"), donnees
						.getString("nomLocal"), donnees.getString("fkService")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<SSL> getSSL(int fkLocalS) {
		Vector<model.SSL> v = new Vector<model.SSL>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT nomSite, nomService, nomLocal FROM Site, Service, Local WHERE codeSite = fkSite AND fkService = nomService AND idLocal = "
					+ fkLocalS;
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new SSL(donnees.getString("nomSite"), donnees
						.getString("nomService"), donnees.getString("nomLocal")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static int getFkLocal(String local) {
		int fk = 0;
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Local WHERE nomLocal = '"
					+ local + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				fk = donnees.getInt("idLocal");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return fk;
	}

	public static Vector<LigneTableauIntervention> getLTI() {
		Vector<model.LigneTableauIntervention> v = new Vector<model.LigneTableauIntervention>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT Intervention.idIntervention, Intervention.statutIntervention, Intervention.descriptionProbleme, Intervention.dateDemandeIntervention, Materiel.nomMateriel, TypeMateriel.nomTypeMateriel, Site.nomSite, Service.nomService, TypeMateriel.nomTypeMateriel FROM Site, Service, Materiel, Local, ModeleMateriel, TypeMateriel, Intervention WHERE Intervention.fkMateriel = Materiel.nomMateriel AND Materiel.fkModeleMateriel = ModeleMateriel.idModeleMateriel AND TypeMateriel.idTypeMateriel = ModeleMateriel.fkTypeMateriel AND Materiel.fkLocalS = Local.idLocal AND Service.nomService = Local.fkService AND Site.codeSite = Service.fkSite AND Intervention.statutIntervention NOT LIKE 'Terminé'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new LigneTableauIntervention(donnees
						.getInt("idIntervention"), donnees
						.getString("statutIntervention"), donnees
						.getString("descriptionProbleme"), donnees
						.getString("dateDemandeIntervention"), donnees
						.getString("nomMateriel"),
						donnees.getString("nomSite"), donnees
								.getString("nomService"), donnees
								.getString("nomTypeMateriel")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static RemplirIntervention getRI(int idIntervention) {
		model.RemplirIntervention v = new model.RemplirIntervention();
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT nomMateriel, statutIntervention, descriptionProbleme, nomDemandeurIntervention, numTelDemandeurIntervention, dateDemandeIntervention, statutMateriel FROM Materiel, Intervention WHERE Intervention.fkMateriel = Materiel.nomMateriel AND idIntervention = "
					+ idIntervention;
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			donnees.next();
			v.setNomMateriel(donnees.getString("nomMateriel"));
			v.setStatutIntervention(donnees.getString("statutIntervention"));
			v.setDescriptionProbleme(donnees.getString("descriptionProbleme"));
			v.setNomDemandeurIntervention(donnees
					.getString("nomDemandeurIntervention"));
			v.setNumTelDemandeurIntervention(donnees
					.getString("numTelDemandeurIntervention"));
			v.setDateDemandeIntervention(donnees
					.getString("dateDemandeIntervention"));
			v.setStatutMateriel(donnees.getString("statutMateriel"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Technicien> getTechnicien() {
		Vector<model.Technicien> v = new Vector<model.Technicien>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Technicien WHERE actifTechnicien = 1 ORDER BY nomTechnicien";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new Technicien(donnees.getString("idTechnicien"),
						donnees.getString("nomTechnicien"), donnees
								.getString("PrenomTechnicien"), donnees
								.getString("numTelephoneTechnicien"), donnees
								.getBoolean("ActifTechnicien")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<SocieteExt> getSocRep() {
		Vector<model.SocieteExt> v = new Vector<model.SocieteExt>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM SocieteExt WHERE typeSocieteExt = 'Réparateur ' AND actifSocieteExt = 1 ORDER BY nomSocieteExt";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new SocieteExt(donnees.getInt("idSocieteExt"),
						donnees.getString("nomSocieteExt"), donnees
								.getString("adresseSocieteExt"), donnees
								.getString("numTvaSocieteExt"), donnees
								.getString("ActifSocieteExt"), donnees
								.getString("TypeSocieteExt"), donnees
								.getBoolean("siteWebSocieteExt")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<LigneIntervention> getLigneI(int idIntervention) {
		Vector<model.LigneIntervention> v = new Vector<model.LigneIntervention>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM LigneIntervention WHERE fkIntervention = "
					+ idIntervention;
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new LigneIntervention(donnees
						.getInt("idLigneIntervention"), donnees
						.getInt("fkSocieteExtLI"), donnees
						.getInt("FkIntervention"), donnees
						.getString("DescriptionLigneIntervention"), donnees
						.getString("DateLigneIntervention"), donnees
						.getString("FkTechnicien")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static String getFkTech(String fkTechnicien) {
		String fk = null;
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Technicien WHERE idTechnicien = '"
					+ fkTechnicien + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				fk = donnees.getString("nomTechnicien") + " "
						+ donnees.getString("PrenomTechnicien");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return fk;
	}

	public static String getFkSocieteExt(int fkSocieteExtLI) {
		String fk = null;
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM SocieteExt WHERE idSocieteExt = '"
					+ fkSocieteExtLI + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				fk = donnees.getString("nomSocieteExt");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return fk;
	}

	public static Vector<MaterielArbre> getMaterielArbre() {
		Vector<model.MaterielArbre> v = new Vector<model.MaterielArbre>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT NomMateriel, NumSerieMateriel, DateAchat, DateInstallation, DureeGarantie, statutMateriel, AdresseMac, AdresseIp, noteMateriel, NomService, NomSite, NomModeleMateriel, nomTypeMateriel, NomMarque, fkImageW, FkBudget, LibelleServiceFR, NomLocal FROM Materiel, Local, Service, Site, ModeleMateriel, TypeMateriel, Marque WHERE fkSite = CodeSite AND FkService = NomService AND FkLocalS = IdLocal AND FkModeleMateriel = idModeleMateriel AND fkTypeMateriel = idTypeMateriel AND fkMarque = idNomMarque AND StatutMateriel NOT LIKE 'Désactivé' ORDER BY NomSite, NomService, NomTypeMateriel, NomMateriel";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new MaterielArbre(
						donnees.getString("NomMateriel"), donnees
								.getString("NumSerieMateriel"), donnees
								.getString("DateAchat"), donnees
								.getString("DateInstallation"), donnees
								.getString("statutMateriel"), donnees
								.getString("AdresseMac"), donnees
								.getString("AdresseIp"), donnees
								.getString("noteMateriel"), donnees
								.getString("nomService"), donnees
								.getString("nomSite"), donnees
								.getString("NomModeleMateriel"), donnees
								.getString("nomTypeMateriel"), donnees
								.getString("nomMarque"), donnees
								.getString("fkImageW"), donnees
								.getString("fkBudget"), donnees
								.getString("LibelleServiceFR"), donnees
								.getString("NomLocal"), donnees
								.getInt("DureeGarantie")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static MaterielArbre getMaterielArbre(String materiel) {
		model.MaterielArbre v = new model.MaterielArbre();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT NomMateriel, NumSerieMateriel, DateAchat, DateInstallation, DureeGarantie, statutMateriel, AdresseMac, AdresseIp, noteMateriel, NomService, NomSite, NomModeleMateriel, nomTypeMateriel, NomMarque, fkImageW, FkBudget, LibelleServiceFR, NomLocal FROM Materiel, Local, Service, Site, ModeleMateriel, TypeMateriel, Marque WHERE fkSite = CodeSite AND FkService = NomService AND FkLocalS = IdLocal AND FkModeleMateriel = idModeleMateriel AND fkTypeMateriel = idTypeMateriel AND fkMarque = idNomMarque AND NomMateriel = '"
					+ materiel + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.setNomMateriel(donnees.getString("NomMateriel"));
				v.setNumSerieMateriel(donnees.getString("NumSerieMateriel"));
				v.setDateAchat(donnees.getString("DateAchat"));
				v.setDateInstallation(donnees.getString("DateInstallation"));
				v.setStatutMateriel(donnees.getString("statutMateriel"));
				v.setAdresseMac(donnees.getString("AdresseMac"));
				v.setAdresseIp(donnees.getString("AdresseIp"));
				v.setNoteMateriel(donnees.getString("noteMateriel"));
				v.setNomService(donnees.getString("nomService"));
				v.setNomSite(donnees.getString("nomSite"));
				v.setNomModeleMateriel(donnees.getString("NomModeleMateriel"));
				v.setNomTypeMateriel(donnees.getString("nomTypeMateriel"));
				v.setNomMarque(donnees.getString("nomMarque"));
				v.setFkImageW(donnees.getString("fkImageW"));
				v.setFkBudget(donnees.getString("fkBudget"));
				v.setLibelleServiceFR(donnees.getString("LibelleServiceFR"));
				v.setNomLocal(donnees.getString("NomLocal"));
				v.setDureeGarantie(donnees.getInt("DureeGarantie"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static int getFkType(String type) {
		int fk = 0;
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM TypeMateriel WHERE nomTypeMateriel = '"
					+ type + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				fk = donnees.getInt("idTypeMateriel");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return fk;
	}

	public static int getFkMarque(String marque) {
		int fk = 0;
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Marque WHERE nomMarque = '"
					+ marque + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				fk = donnees.getInt("idNomMarque");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return fk;
	}

	public static Utilisateur getUser(String nom) {
		Utilisateur user = new Utilisateur();
		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT * FROM Utilisateur WHERE codeUser = '"
					+ nom + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				user.setCodeUser(donnees.getString("codeUser"));
				user.setNomUser(donnees.getString("nomUser"));
				user.setMdpUser(donnees.getString("mdpUser"));
				user.setFonctionUser(donnees.getString("fonctionUser"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return user;
	}

	public static Vector<MaterielArbre> getMaterielTableau() {
		Vector<model.MaterielArbre> v = new Vector<model.MaterielArbre>();

		try {
			Statement stat = controller.ControllerDB.connectionDB()
					.createStatement();

			String requeteSQL = "SELECT NomMateriel, NumSerieMateriel, DateAchat, DateInstallation, DureeGarantie, statutMateriel, AdresseMac, AdresseIp, noteMateriel, NomService, NomSite, NomModeleMateriel, nomTypeMateriel, NomMarque, fkImageW, FkBudget, LibelleServiceFR, NomLocal FROM Materiel, Local, Service, Site, ModeleMateriel, TypeMateriel, Marque WHERE fkSite = CodeSite AND FkService = NomService AND FkLocalS = IdLocal AND FkModeleMateriel = idModeleMateriel AND fkTypeMateriel = idTypeMateriel AND fkMarque = idNomMarque AND StatutMateriel NOT LIKE 'Désactivé' ORDER BY NomMateriel";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.addElement(new MaterielArbre(
						donnees.getString("NomMateriel"), donnees
								.getString("NumSerieMateriel"), donnees
								.getString("DateAchat"), donnees
								.getString("DateInstallation"), donnees
								.getString("statutMateriel"), donnees
								.getString("AdresseMac"), donnees
								.getString("AdresseIp"), donnees
								.getString("noteMateriel"), donnees
								.getString("nomService"), donnees
								.getString("nomSite"), donnees
								.getString("NomModeleMateriel"), donnees
								.getString("nomTypeMateriel"), donnees
								.getString("nomMarque"), donnees
								.getString("fkImageW"), donnees
								.getString("fkBudget"), donnees
								.getString("LibelleServiceFR"), donnees
								.getString("NomLocal"), donnees
								.getInt("DureeGarantie")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
}
