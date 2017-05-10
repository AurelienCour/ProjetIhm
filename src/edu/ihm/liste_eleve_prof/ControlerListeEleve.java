package edu.ihm.liste_eleve_prof;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Eleve;

/**
 * Class permettant la gestion des intéractions entre l'utilisateur et la liste des élèves
 * @author Aurelien
 *
 */
public class ControlerListeEleve implements ListSelectionListener{
	
	private JTable tableEleve; // La table contenant la liste des élèves
	private AcceuilProf acceuil; // L'acceuil pour la redirection

	/**
	 * Le constructeur de notre classe
	 * @param tableEleve La table concerné
	 * @param acceuil L'acceuil de notre application
	 */
	public ControlerListeEleve(JTable tableEleve, AcceuilProf acceuil) {
		this.tableEleve = tableEleve;
		this.acceuil = acceuil;
	}

	/**
	 * La fonction permettant la gestion des intéractions avec les boutons
	 */
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
