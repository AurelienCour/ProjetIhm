package edu.ihm.liste_exercice_eleve;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Class permetant la gestion de la liste des éxercices
 * @author Aurelien
 *
 */
public class TableListeExercice extends AbstractTableModel {

	private ArrayList<Exercice> donnees; // La liste des exercices 
	private Eleve el; // L'eleve qui souhaite la liste des exercices
	private final String[] entetes = {"Nom", "Modele", "Statut"}; // L'en-tête de la table

	/**
	 * Le constructeur de notre classe
	 * @param el l'Utilisateur de l'application
	 */
	public TableListeExercice(Eleve el) {
		super();
		this.el = el;
		this.donnees = new ArrayList<Exercice>();
		initDonnees();
	}

	/**
	 * Initialise les données de la table
	 */
	public void initDonnees(){
		if(!donnees.isEmpty())
			donnees.removeAll(donnees);
		for(Exercice exo : el.getClasse().getExercices()){
			donnees.add(exo);
		}
		reload();
	}

	/**
	 * Permet de recharger la table
	 */
	public void reload(){
		fireTableDataChanged();
	}
	
	/**
	 * Permet d'ajouter un exercice à notre table
	 * @param exo L'exercice à ajouter
	 */
	public void addExercice(Exercice exo) {
		donnees.add(exo);
		fireTableRowsInserted(donnees.size() -1, donnees.size() -1);
	}

	/**
	 * Permet de récupérer l'objet d'une ligne
	 * @param rowIndex Le numéro de la ligne
	 * @return L'exercice à la ligne données
	 */
	public Exercice getExerciceRow(int rowIndex){
		return donnees.get(rowIndex);
	}

	/**
	 * Supprime l'eleve de la table
	 * @param rowIndex Le numéro de la ligne
	 */
	public void removeExercice(int rowIndex) {
		donnees.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public int getRowCount() {
		return donnees.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return donnees.get(rowIndex).getNomEx();
		case 1:
			return donnees.get(rowIndex).getModele();
		case 2:
			for (ExerciceRealise exerciceR : el.getExerciceRealise()) {
				if(exerciceR.getExerciceFait().equals(donnees.get(rowIndex))){
					if(exerciceR.getResultat() != null)
						return "Corrigé";
					return "Fait";
				}
			}
			return "A faire";
		default:
			return null; //Ne devrait jamais arriver
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	@Override
	public Class getColumnClass(int columnIndex){
		return getValueAt(0, columnIndex).getClass();
	}
}
