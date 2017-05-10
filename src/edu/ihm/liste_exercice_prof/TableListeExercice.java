package edu.ihm.liste_exercice_prof;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Classe permettant de gérer l'affichage de la table
 * @author Aurelien
 *
 */
public class TableListeExercice extends AbstractTableModel {

	private ArrayList<Exercice> donnees; // La liste des exercices
	private Classes cl; // La classe dont on souhaite 
	private final String[] entetes = {"Nom", "Modele", "Nombre élève"}; // Les en-tête de la table

	/**
	 * Le constructeur de notre classe
	 * @param cl l'Utilisateur de l'application
	 */
	public TableListeExercice(Classes cl) {
		super();
		this.cl = cl;
		this.donnees = new ArrayList<Exercice>();
		initDonnees();
	}

	/**
	 * Initialise les données de la table
	 */
	public void initDonnees(){
		if(!donnees.isEmpty())
			donnees.removeAll(donnees);
		for(Exercice exo : cl.getExercices()){
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
	 * Permet d'ajouter un élève à notre table
	 * @param exo L'exercice à ajouter
	 */
	public void addExercice(Exercice exo) {
		donnees.add(exo);
		fireTableRowsInserted(donnees.size() -1, donnees.size() -1);
	}

	/**
	 * Permet de récupérer l'objet d'une ligne
	 * @param rowIndex Le numéro de la ligne
	 * @return L'exercice données
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
			int nombEleveTot = 0;
			int nombEleveFait = 0;
			int nombAFaire = 0;
			if(cl.containExercice(donnees.get(rowIndex))){
				nombEleveTot += cl.getNombreEleve();
				for(Eleve el : cl.getEleves()){
					for(ExerciceRealise exoR : el.getExerciceRealise()){
						if(exoR.getExerciceFait().equals(donnees.get(rowIndex))){
							nombEleveFait += 1;
							if(!exoR.isCorrect())
								nombAFaire += 1;
						}
					}
				}
			}
			if(nombEleveFait != 0 && nombAFaire != 0)
				return "<html>"+nombEleveFait+"/"+nombEleveTot+"  <span style=\"color:red\">("+nombAFaire+" à corriger)</span></html>";
			else if(nombEleveFait != 0)
				return "<html>"+nombEleveFait+"/"+nombEleveTot+"  <span style=\"color:blue\">(Aucune correction)</span></html>";
			else
				return "<html>"+nombEleveFait+"/"+nombEleveTot+"  <span style=\"color:green\">Modifiable</span></html>";
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
