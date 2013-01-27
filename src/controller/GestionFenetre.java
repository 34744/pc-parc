package controller;

public class GestionFenetre {
	
	public static void eraseContainerPanelMainJFrame() {
		view.MainJFrame.eraseContainerPanel();
	}

	public static void initAccueil() {
		view.Accueil acc = new view.Accueil();
		view.MainJFrame.setContainerPanel(acc);		
	}

	public static void AjoutMateriel() {
		view.AjoutMateriel acc = new view.AjoutMateriel();
		view.MainJFrame.setContainerPanel(acc);	
	}

	public static void ModifMateriel() {
		view.ModifMateriel acc = new view.ModifMateriel();
		view.MainJFrame.setContainerPanel(acc);
		
	}
	
	public static void ListMateriel(){
		view.ListerMateriel acc = new view.ListerMateriel();
		view.MainJFrame.setContainerPanel(acc);
	}
	
	public static void AjoutIntervention(){
		view.AjoutIntervention acc = new view.AjoutIntervention();
		view.MainJFrame.setContainerPanel(acc);
	}

	public static void ListIntervention() {
		view.ListerIntervention acc = new view.ListerIntervention();
		view.MainJFrame.setContainerPanel(acc);
	}
	
	public static void ModifIntervention(int idIntervention){
		view.ModifIntervention acc = new view.ModifIntervention(idIntervention);
		view.MainJFrame.setContainerPanel(acc);
	}

	public static void AjoutModele() {
		view.AjoutModele acc = new view.AjoutModele();
		view.MainJFrame.setContainerPanel(acc);
	}

	public static void ListMaterielTab() {
		view.ListerMaterielTab acc = new view.ListerMaterielTab();
		view.MainJFrame.setContainerPanel(acc);
	}

}
