package edu.ihm.liste_eleve_prof;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Professeur;

public class TableListeEleve extends AbstractTableModel {

	private ArrayList<Eleve> donnees;
	private Professeur prof;
	private final String[] entetes = {"Icone", "Nom", "Prenom"};

	/**
	 * Le constructeur de notre classe
	 * @param model Le model contenant nos données
	 * @param fenetreInfo 
	 */
	public TableListeEleve(Professeur prof) {
		super();
		this.prof = prof;
		this.donnees = new ArrayList<Eleve>();
		initDonnees();
	}

	/**
	 * Initialise les données de la table
	 * @param cl La classe a importer au sein de la table
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
			return donnees.get(rowIndex).getPhoto();
		case 1:
			return donnees.get(rowIndex).getNom();
		case 2:
			return donnees.get(rowIndex).getPrenom();
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

	/**
	 * Permet d'ajouter un élève à notre table
	 * @param eleve
	 */
	public void addEleve(Eleve eleve) {
		donnees.add(eleve);
		fireTableRowsInserted(donnees.size() -1, donnees.size() -1);
	}
	
	/**
	 * Permet de récupérer l'objet d'une ligne
	 * @param rowIndex
	 * @return
	 */
	public Eleve getEleveRow(int rowIndex){
		return donnees.get(rowIndex);
	}

	/**
	 * Supprime l'eleve de la table
	 * @param rowIndex
	 */
	public void removeEleve(int rowIndex) {
		donnees.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

}
