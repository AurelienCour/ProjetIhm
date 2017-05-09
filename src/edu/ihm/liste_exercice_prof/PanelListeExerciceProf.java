package edu.ihm.liste_exercice_prof;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;
import edu.ihm.renderer.ImageCellRenderer;

/**
 * Panel de visualisation des Exercices pour un professeur
 * Affiche une liste des Exercices pour une classe donnée
 * Va utiliser un objet de type professeur
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelListeExerciceProf extends JPanel{
	
	private Classes cl;
	private AcceuilProf acceuil;
	private JTable tableExercice;
	private TableListeExercice modeleTable;
	
	/**
	 * Constructeur de notre classe
	 * @param cl La classe dont on souhaite les différents exercices
	 * @param acceuil L'acceuil de notre application
	 */
	public PanelListeExerciceProf(Classes cl, AcceuilProf acceuil){
		this.setBackground(new Color(225, 206, 154));
		
		
		this.acceuil = acceuil;
		this.cl = cl;
		this.setLayout(new BorderLayout());
		JButton boutonCreation = new JButton("Creer un exercice");
		boutonCreation.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelListeExerciceProf.this.acceuil.goCreationExercice(PanelListeExerciceProf.this.cl);
			}
			
		});
		this.add(boutonCreation, BorderLayout.NORTH);
		initComposant();
	}
	
	/**
	 * Permet d'initialiser les composants de notre JPanel
	 */
	public void initComposant(){
		modeleTable = new TableListeExercice(cl);
		initJTable();
		this.add(new JScrollPane(tableExercice), BorderLayout.CENTER);
	}
	
	/**
	 * Permet d'initialiser la JTable
	 */
	private void initJTable(){
		this.tableExercice = new JTable(modeleTable);
		tableExercice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableExercice.setRowHeight(80);
		tableExercice.setDefaultRenderer(URL.class, new ImageCellRenderer());
		tableExercice.setDefaultRenderer(String.class, new ImageCellRenderer());
		ListSelectionModel listSelectionModel = tableExercice.getSelectionModel();        
		listSelectionModel.addListSelectionListener(new ControlerListeExerciceProf(tableExercice, acceuil));
	}
}
