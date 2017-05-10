package edu.ihm.liste_eleve_prof;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Professeur;

/**
 * La classe correspondant à la liste des élèves
 * @author Aurelien
 *
 */
public class TableListeEleve extends AbstractTableModel {

	private ArrayList<Eleve> donnees; // La liste des élèves
	private Professeur prof; // Le professeur voulant la liste de ses élèves
	private Classes cl; // La classe contenant les élèves
	private final String[] entetes = {"Icone", "Nom", "Prenom"}; // La liste des en-tête de la table
	
	/**
	 * Le constructeur de la classe
	 * @param prof Le prof dont on souhaite les élèves
	 */
	public TableListeEleve(Professeur prof) {
		super();
		this.prof = prof;
		this.donnees = new ArrayList<Eleve>();
		initDonnees();
	}

	/**
	 * Le constructeur de la classe pour avoir les élèves d'une classe donnée
	 * @param cl La classe dont on souhaite les élèves
	 */
	public TableListeEleve(Classes cl) {
		super();
		this.cl = cl;
		this.donnees = new ArrayList<Eleve>();
		initDonneesClasse();
	}

	/**
	 * Initialise les données de la table si une classe précise est choisis
	 */
	private void initDonneesClasse() {
		if(!donnees.isEmpty())
			donnees.removeAll(donnees);
		for(Eleve el : cl.getEleves()){
			donnees.add(el);
		}
		reload();
	}

	/**
	 * Initialise les données de la table
	 */
	public void initDonnees(){
		if(!donnees.isEmpty())
			donnees.removeAll(donnees);
		for (Classes cl : prof.getClasses()) {
			for(Eleve el : cl.getEleves()){
				donnees.add(el);
			}
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
	 * Permet de récupérer le nombre de ligne de la table
	 */
	public int getRowCount() {
		return donnees.size();
	}

	/**
	 * Permet de récupérer le nombre de colonne
	 */
	public int getColumnCount() {
		return entetes.length;
	}

	/**
	 * Permet de récupérer le nom d'une colonne
	 */
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	/**
	 * Permet de récupérer la valeur d'une case donnée
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return donnees.get(rowIndex).getPhoto();
		case 1:
			return donnees.get(rowIndex).getNom();
		case 2:
			return donnees.get(rowIndex).getPrenom();
		default:
			return null; //Ne devrait jamais arriver
		}
	}

	/**
	 * Permet de savoir si une cellule est modifiable
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * Permet de modifier la valeur d'une cellule
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	/**
	 * Permet de connaitre la classe d'objet d'une colonne donné
	 */
	@Override
	public Class getColumnClass(int columnIndex){
		return getValueAt(0, columnIndex).getClass();
	}

	/**
	 * Permet d'ajouter un élève à notre table
	 * @param eleve l'élève à ajouter
	 */
	public void addEleve(Eleve eleve) {
		donnees.add(eleve);
		fireTableRowsInserted(donnees.size() -1, donnees.size() -1);
	}

	/**
	 * Permet de récupérer l'objet d'une ligne
	 * @param rowIndex La ligne dont on souhaite l'objet
	 * @return L'élève de la ligne donnée
	 */
	public Eleve getEleveRow(int rowIndex){
		return donnees.get(rowIndex);
	}

	/**
	 * Supprime l'eleve de la table
	 * @param rowIndex Le numéro de la ligne
	 */
	public void removeEleve(int rowIndex) {
		donnees.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
