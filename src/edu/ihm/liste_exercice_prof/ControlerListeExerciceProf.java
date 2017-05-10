package edu.ihm.liste_exercice_prof;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Exercice;

/**
 * Classe permettant de gérer les intéraction avec la liste des exercices
 * @author Aurelien
 *
 */
public class ControlerListeExerciceProf implements ListSelectionListener {
	
	private JTable tableExercice; // La table contenant la liste des exercices
	private AcceuilProf acceuil; // L'acceuil pour les redirections

	/**
	 * Constrcuteur de notre classe permettant de controler les intéractions avec le tableau
	 * @param tableExercice Le tableau avec lequel l'utilisateur a intéragi
	 * @param acceuil L'application
	 */
	public ControlerListeExerciceProf(JTable tableExercice, AcceuilProf acceuil) {
		this.tableExercice = tableExercice;
		this.acceuil = acceuil;
	}

	/**
	 * Fonction permettant la gestion des intéractions
	 */
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
