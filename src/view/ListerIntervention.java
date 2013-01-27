package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.ModelTableauIntervention;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;


public class ListerIntervention extends JPanel {
	private JTable tableLti;
	private JScrollPane JSP;
	private Vector<model.LigneTableauIntervention> vectLti = new Vector<model.LigneTableauIntervention>();
	private ModelTableauIntervention modelLti;
	private JButton buttonOk;
	private JButton buttonRetour;
	
	public ListerIntervention() {
		setLayout(null);
		
		vectLti = controller.ControllerDB.getLti();

		modelLti = new ModelTableauIntervention(vectLti);
	
		tableLti = new JTable(modelLti);
		tableLti.setAutoscrolls(true);
		tableLti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableLti.setAutoCreateRowSorter(true);
	
		JSP = new JScrollPane(tableLti);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(25, 100, 750, 400);
		tableLti.getColumn("idIntervention").setMinWidth(0);
		tableLti.getColumn("idIntervention").setMaxWidth(0);
	
		this.add(JSP);
		
		buttonOk = new JButton("OK");
		buttonOk.setBounds(25, 536, 89, 23);
		add(buttonOk);
		
		buttonRetour = new JButton("Retour");
		buttonRetour.setBounds(135, 536, 89, 23);
		add(buttonRetour);
		this.setVisible(true);
		
		MyButtonListener list = new MyButtonListener();
		buttonOk.addActionListener(list);
		buttonRetour.addActionListener(list);

	}
	
	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == buttonOk) {
				if (tableLti.getSelectedRow() != -1){
					int id;
					controller.GestionFenetre.eraseContainerPanelMainJFrame();
					id = tableLti.getValueAt(tableLti.getSelectedRow(), 7).hashCode();
					controller.GestionFenetre.ModifIntervention(id);
					
				}
				
			}
			if (source == buttonRetour) {
				controller.GestionFenetre.eraseContainerPanelMainJFrame();
				controller.GestionFenetre.initAccueil();
			}

		}
	}
}
