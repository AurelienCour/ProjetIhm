package edu.ihm.liste_eleve_prof;


import java.awt.GridLayout;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Professeur;

/**
 * Panel permettant à un professeur de visualiser la liste des élèves
 * Va utiliser un objet de type Classe
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelListeEleveProf extends JPanel{
	
	private Professeur prof;
	private AcceuilProf acceuil;
	private JTable tableEleve;
	private TableListeEleve modeleTable;
	
	public PanelListeEleveProf(AcceuilProf acceuil){
		this.prof = (Professeur) acceuil.getUser();
		this.acceuil = acceuil;
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
		tableEleve.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEleve.setRowHeight(70);
		tableEleve.setDefaultRenderer(URL.class, new ImageCellRenderer());
		//tableEleve.setDefaultRenderer(URL.class, new DefaultTableCellRenderer());
		ListSelectionModel listSelectionModel = tableEleve.getSelectionModel();        
		listSelectionModel.addListSelectionListener(new ControlerListeEleve(tableEleve, acceuil));
	}

}
