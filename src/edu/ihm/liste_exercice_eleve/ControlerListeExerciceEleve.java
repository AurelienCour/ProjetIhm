package edu.ihm.liste_exercice_eleve;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.noyau_fonctionnel.Exercice;

/**
 * Classe permettant de controler les intéraction avec la table
 * @author Aurelien
 *
 */
public class ControlerListeExerciceEleve implements ListSelectionListener {
	
	private JTable tableExercice; // La table avec laquel l'utilisateur intéragit
	private AcceuilEleve acceuil; // L'acceuil pour les redirections

	/**
	 * Constrcuteur de notre classe permettant de controler les intéractions avec le tableau
	 * @param tableExercice Le tableau avec lequel l'utilisateur a intéragi
	 * @param acceuil L'application
	 */
	public ControlerListeExerciceEleve(JTable tableExercice, AcceuilEleve acceuil) {
		this.tableExercice = tableExercice;
		this.acceuil = acceuil;
	}

	/**
	 * Permet de gérer les intéractions avec la table
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
