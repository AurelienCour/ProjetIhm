package edu.ihm.liste_exercice_eleve;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.renderer.ImageCellRenderer;

/**
 * Panel permettant à un élève de voir la liste des Exercices actuels
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelListeExerciceEleve extends JPanel{
	
	private AcceuilEleve acceuil;
	private JTable tableExercice;
	private TableListeExercice modeleTable;
	
	/**
	 * Constructeur de notre classe
	 * @param acceuil L'acceuil de notre application
	 */
	public PanelListeExerciceEleve(AcceuilEleve acceuil){
		this.acceuil = acceuil;
		this.setLayout(new BorderLayout());
		initComposant();
	}
	
	/**
	 * Permet d'initialiser les composants de notre JPanel
	 */
	public void initComposant(){
		modeleTable = new TableListeExercice((Eleve) acceuil.getUser());
		initJTable();
		this.add(new JScrollPane(tableExercice),BorderLayout.CENTER);
	}
	
	/**
	 * Permet d'initialiser la JTable
	 */
	private void initJTable(){
		this.tableExercice = new JTable(modeleTable);
		tableExercice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableExercice.setRowHeight(70);
		tableExercice.setDefaultRenderer(URL.class, new ImageCellRenderer());
		tableExercice.setDefaultRenderer(String.class, new ImageCellRenderer());
		ListSelectionModel listSelectionModel = tableExercice.getSelectionModel();        
		listSelectionModel.addListSelectionListener(new ControlerListeExerciceEleve(tableExercice, acceuil));
	}

}
