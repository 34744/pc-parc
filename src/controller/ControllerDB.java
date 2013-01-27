package controller;

import java.sql.Connection;
import java.util.StringTokenizer;
import java.util.Vector;

import model.Budget;
import model.GetData;
import model.ImageWindows;
import model.Intervention;
import model.LigneIntervention;
import model.LigneTableauIntervention;
import model.LigneTableauLigneIntervention;
import model.Local;
import model.MajData;
import model.Marque;
import model.Materiel;
import model.MaterielArbre;
import model.ModeleMateriel;
import model.SSL;
import model.Service;
import model.Site;
import model.SocieteExt;
import model.Technicien;
import model.TypeMateriel;
import model.Utilisateur;

public class ControllerDB {

	public static Connection connectionDB() {
		return model.AccesDB.GetInstance();		
	}
	
	public static void fermetureDB(){
		model.AccesDB.closeBD();
	}

	public static Vector<TypeMateriel> getTypeMateriel() {
		return model.GetData.getTypeModele();
	}
	
	public static Vector<Marque> getMarque(){
		return model.GetData.getMarque();
	}
	
	public static Vector<Materiel> getNom(String nom){
		return model.GetData.getMateriel(nom);
	}

	public static Vector<ModeleMateriel> getModeleMateriel(String type, String marque) {
		return model.GetData.getModeleMateriel(type, marque);
	}
	
	public static int getFkModeleMateriel(String modele){
		return model.GetData.getFkModeleMateriel(modele);
	}

	public static void addMateriel(Materiel matos) {
		AddData.addMateriel(matos);
		
	}

	public static Vector<Budget> getBudget() {
		return model.GetData.getBudget();
	}

	public static Vector<SocieteExt> getFournisseur() {
		return model.GetData.getFournisseur();
	}

	public static int getFkFournisseur(String nomFournisseur) {
		return model.GetData.getFkFournisseur(nomFournisseur);
	}
	public static Vector<model.Materiel> getMateriel(String nom){
		return model.GetData.getMatos(nom);
	}

	public static Vector<ImageWindows> getImage() {
		return model.GetData.getImageWr();
	}

	public static Vector<Site> getSite() {
		return  model.GetData.getSite();
	}

	public static Vector<Service> getService(String site) {
		return model.GetData.getService(site);
	}

	public static Vector<Local> getLocal(String service) {
		return model.GetData.getLocal(service);
	}

	public static Vector<SSL> getSSL(int fkLocalS) {
		return model.GetData.getSSL(fkLocalS);
	}

	public static int getFkLocal(String local) {
		return model.GetData.getFkLocal(local);
	}

	public static void addIntervention(Intervention intervention) {
		AddData.addIntervention(intervention);	
	}

	public static Vector<LigneTableauIntervention> getLti() {
		return model.GetData.getLTI();
	}
	
	public static model.RemplirIntervention getRIntervention(int idIntervention) {
		return model.GetData.getRI(idIntervention);
	}

	public static Vector<SocieteExt> getSocExt() {
		return model.GetData.getSocRep();
	}

	public static Vector<Technicien> getTechnicien() {
		return model.GetData.getTechnicien();
	}

	public static Vector<LigneIntervention> getLigneI(int idIntervention) {
		return model.GetData.getLigneI(idIntervention);
	}

	public static String getFkTech(String fkTechnicien) {
		return model.GetData.getFkTech(fkTechnicien);		
	}

	public static String getFkSocieteExt(int fkSocieteExtLI) {
		return model.GetData.getFkSocieteExt(fkSocieteExtLI);
	}

	public static void getDesactivation(String materiel) {
		MajData.MajDesactivation(materiel);	
	}

	public static void ModifMateriel(Materiel matos) {
		MajData.MajMateriel(matos);
	}

	public static void addLigneIntervention(LigneIntervention ligneIntervention) {
		AddData.AddLigneIntervention(ligneIntervention);
	}

	public static void updateStatutIntervention(int idIntervention,
			String statutIntervention) {
		MajData.MajStatutIntervention(idIntervention, statutIntervention);
	}

	public static void updateStatutReparation(String nomMateriel,
			String statutReparation) {
		MajData.MajStatutReparation(nomMateriel, statutReparation);
	}

	public static Vector<MaterielArbre> getMaterielArbre() {
		return model.GetData.getMaterielArbre();
	}

	public static MaterielArbre getMaterielArbre(String materiel) {
		return model.GetData.getMaterielArbre(materiel);
	}

	public static int getFkMarque(String marque) {
		return model.GetData.getFkMarque(marque);
	}

	public static int getFkType(String type) {
		return model.GetData.getFkType(type);
	}

	public static void addModele(ModeleMateriel modele) {
		AddData.addModele(modele);
	}

	public static Utilisateur getUser(String nom) {
		return GetData.getUser(nom);
	}

	public static Vector<MaterielArbre> getMaterielTableau() {
		return model.GetData.getMaterielTableau();
	}

}
