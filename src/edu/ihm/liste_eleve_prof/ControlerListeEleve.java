package edu.ihm.liste_eleve_prof;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Eleve;

public class ControlerListeEleve implements ListSelectionListener{
	
	private JTable tableEleve;
	private AcceuilProf acceuil;

	public ControlerListeEleve(JTable tableEleve, AcceuilProf acceuil) {
		this.tableEleve = tableEleve;
		this.acceuil = acceuil;
	}

	@Override
	public void valueChanged(ListSelectionEvent act) {
		TableListeEleve modelTable = (TableListeEleve) tableEleve.getModel();
		if (act.getValueIsAdjusting())
			return;
		ListSelectionModel lsm = (ListSelectionModel)act.getSource();
		if (!lsm.isSelectionEmpty()) {
			int selectedRow = lsm.getMinSelectionIndex();
			Eleve e = modelTable.getEleveRow(selectedRow);
			acceuil.goFicheEleve(e);
		}
	}

	
}
