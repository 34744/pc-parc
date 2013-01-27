package model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ModelTableauMateriel extends AbstractTableModel{
	
	Vector<String> columnNames = new Vector<String>();
	Vector<model.MaterielArbre> contents = new Vector<model.MaterielArbre>();

	public ModelTableauMateriel(Vector<model.MaterielArbre> contents) {
		setColumnNames();
		setContents(contents);
	}

	public void setColumnNames() {
		columnNames.addElement("Nom");
		columnNames.addElement("Type");
		columnNames.addElement("Modèle");
		columnNames.addElement("Site");
		columnNames.addElement("Service");
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
		model.MaterielArbre a = contents.elementAt(row);
		switch (col) {
		case 0:
			return a.getNomMateriel();
		case 1:;
			return a.getNomTypeMateriel();
		case 2:
			return a.getNomModeleMateriel();
		case 3:
			return a.getNomSite();
		case 4:
			return a.getNomService();
		}
		return a;
	}

	public model.MaterielArbre getArmeeAt(int row) {
		model.MaterielArbre a = contents.elementAt(row);
		return a;
	}

	public void setContents(Vector<model.MaterielArbre> contents) {
		this.contents = contents;
	}

}
