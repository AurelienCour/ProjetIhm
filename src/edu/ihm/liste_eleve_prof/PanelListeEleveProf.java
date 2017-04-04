package edu.ihm.liste_eleve_prof;


import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.ihm.noyau_fonctionnel.Professeur;

/**
 * Panel permettant à un professeur de visualiser la liste des élèves
 * Va utiliser un objet de type Classe
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelListeEleveProf extends JPanel{
	
	private Professeur prof;
	private JTable tableEleve;
	private TableListeEleve modeleTable;
	
	public PanelListeEleveProf(Professeur prof){
		this.prof = prof;
		this.setLayout(new GridLayout());
		initcomposant();
	}

	private void initcomposant() {
		modeleTable = new TableListeEleve(prof);
		initJTable();
		this.add(new JScrollPane(tableEleve));
	}
	
	/**
	 * Permet d'initialiser la JTable
	 */
	private void initJTable(){
		this.tableEleve = new JTable(modeleTable);
		/*tableEleve.setDefaultRenderer(Boolean.class, new SexeCellRenderer());
		tableEleve.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel listSelectionModel = tableClasse.getSelectionModel();        
		listSelectionModel.addListSelectionListener(new JTableControler(tableEleve, this));*/
	}

}
