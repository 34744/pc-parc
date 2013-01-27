package model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ModelTableauIntervention extends AbstractTableModel{
	
	Vector<String> columnNames = new Vector<String>();
	Vector<model.LigneTableauIntervention> contents = new Vector<model.LigneTableauIntervention>();

	public ModelTableauIntervention(Vector<model.LigneTableauIntervention> contents) {
		setColumnNames();
		setContents(contents);
	}

	public void setColumnNames() {
		columnNames.addElement("Statut");
		columnNames.addElement("Date de création");
		columnNames.addElement("Type de matériel");
		columnNames.addElement("Nom du matériel");
		columnNames.addElement("Site");
		columnNames.addElement("Service");
		columnNames.addElement("Description");
		columnNames.addElement("idIntervention");
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public int getRowCount() {
		return contents.size();
	}

	public String getColumnName(int col) {
		return columnNames.elementAt(col);
	}

	public Object getValueAt(int row, int col) {
		model.LigneTableauIntervention a = contents.elementAt(row);
		switch (col) {
		case 0:
			return a.getStatutIntervention();
		case 1:;
			String date, jour, mois, annee;
			annee = a.getDateIntervention().substring(0, 4);
			mois = a.getDateIntervention().substring(5, 7);
			jour = a.getDateIntervention().substring(8, 10);
			date = jour + "-" + mois + "-" + annee;
			return date;
		case 2:
			return a.getTypeMateriel();
		case 3:
			return a.getNomMateriel();
		case 4:
			return a.getNomSite();
		case 5:
			return a.getNomService();
		case 6:
			return a.getDescriptionProbleme();
		case 7:
			return a.getIdIntervention();
		}
		return a;
	}

	public model.LigneTableauIntervention getArmeeAt(int row) {
		model.LigneTableauIntervention a = contents.elementAt(row);
		return a;
	}

	public void setContents(Vector<model.LigneTableauIntervention> contents) {
		this.contents = contents;
	}

}
