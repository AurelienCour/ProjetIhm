package edu.ihm.liste_exercice_eleve;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.noyau_fonctionnel.Exercice;

public class ControlerListeExerciceEleve implements ListSelectionListener {
	
	private JTable tableExercice;
	private AcceuilEleve acceuil;

	/**
	 * Constrcuteur de notre classe permettant de controler les intéractions avec le tableau
	 * @param tableExercice Le tableau avec lequel l'utilisateur a intéragi
	 * @param acceuil L'application
	 */
	public ControlerListeExerciceEleve(JTable tableExercice, AcceuilEleve acceuil) {
		this.tableExercice = tableExercice;
		this.acceuil = acceuil;
	}

	@Override
	public void valueChanged(ListSelectionEvent act) {
		TableListeExercice modelTable = (TableListeExercice) tableExercice.getModel();
		if (act.getValueIsAdjusting())
			return;
		ListSelectionModel lsm = (ListSelectionModel)act.getSource();
		if (!lsm.isSelectionEmpty()) {
			int selectedRow = lsm.getMinSelectionIndex();
			Exercice e = modelTable.getExerciceRow(selectedRow);
			acceuil.goFicheExercice(e);
		}
	}

}
