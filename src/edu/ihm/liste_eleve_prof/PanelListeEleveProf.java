package edu.ihm.liste_eleve_prof;


import java.awt.Color;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.renderer.ImageCellRenderer;

/**
 * Panel permettant à un professeur de visualiser la liste des élèves
 * @author Aurelien
 *
 */
public class PanelListeEleveProf extends JPanel{
	
	private Professeur prof; // Le professeur souhaitant la liste de ses élèves
	private Classes cl; // La classe contenant les élèves
	private AcceuilProf acceuil; // L'acceuil pour la redirection
	private JTable tableEleve; // La table contenant la liste des différents élèves
	private TableListeEleve modeleTable; // Le modele pour la structure de la table
	
	/**
	 * Constructeur de la classe
	 * @param acceuil L'acceuil de notre application
	 * @param cl la classe dont on souhaite les élèves
	 */
	public PanelListeEleveProf(AcceuilProf acceuil, Classes cl){
		this.cl = cl;
		this.acceuil = acceuil;
		this.setLayout(new GridLayout());
		initComposantClasse();
	}
	
	/**
	 * Constructeur de la classe 
	 * @param acceuil L'acceuil de notre application
	 */
	public PanelListeEleveProf(AcceuilProf acceuil){
		this.prof = (Professeur) acceuil.getUser();
		this.acceuil = acceuil;
		this.setLayout(new GridLayout());
		initComposant();
	}

	/**
	 * Permet l'initialisation des composants du JPanel
	 */
	private void initComposant() {
		modeleTable = new TableListeEleve(prof);
		initJTable();
		this.add(new JScrollPane(tableEleve));
	}
	
	/**
	 * Permet l'initialisation des composants du JPanel
	 */
	private void initComposantClasse() {
		modeleTable = new TableListeEleve(cl);
		initJTable();
		this.add(new JScrollPane(tableEleve));
	}
	
	/**
	 * Permet d'initialiser la JTable
	 */
	private void initJTable(){
		this.tableEleve = new JTable(modeleTable);
		tableEleve.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEleve.setRowHeight(80);
		tableEleve.setDefaultRenderer(URL.class, new ImageCellRenderer());
		tableEleve.setDefaultRenderer(String.class, new ImageCellRenderer());
		ListSelectionModel listSelectionModel = tableEleve.getSelectionModel();        
		listSelectionModel.addListSelectionListener(new ControlerListeEleve(tableEleve, acceuil));
	}

}
