package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ModelTableauLigneIntervention extends AbstractTableModel{
	Vector<String> columnNames = new Vector<String>();
	Vector<model.LigneTableauLigneIntervention> contents = new Vector<model.LigneTableauLigneIntervention>();

	public ModelTableauLigneIntervention(Vector<model.LigneTableauLigneIntervention> contents) {
		setColumnNames();
		setContents(contents);
	}

	public void setColumnNames() {
		columnNames.addElement("Date");
		columnNames.addElement("Technicien");
		columnNames.addElement("Description");
		columnNames.addElement("idLigneIntervention");
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
		model.LigneTableauLigneIntervention a = contents.elementAt(row);
		switch (col) {
		case 0:
			String date, jour, mois, annee;
			annee = a.getDateLigneIntervention().substring(0, 4);
			mois = a.getDateLigneIntervention().substring(5, 7);
			jour = a.getDateLigneIntervention().substring(8, 10);
			date = jour + "-" + mois + "-" + annee;
			return date;
		case 1:
			return a.getNom();
		case 2:
			return a.getDescriptionLigneIntervention();
		case 3:
			return a.getIdLigneIntervention();
		}
		return a;
	}

	public model.LigneTableauLigneIntervention getArmeeAt(int row) {
		model.LigneTableauLigneIntervention a = contents.elementAt(row);
		return a;
	}

	public void setContents(Vector<model.LigneTableauLigneIntervention> contents) {
		this.contents = contents;
	}

}
