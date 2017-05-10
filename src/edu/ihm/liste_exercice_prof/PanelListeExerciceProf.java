package edu.ihm.liste_exercice_prof;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import edu.ihm.renderer.ImageCellRenderer;

/**
 * Panel de visualisation des Exercices pour un professeur
 * Affiche une liste des Exercices pour une classe donnée
 * Va utiliser un objet de type professeur
 * @author Aurelien
 *
 */
public class PanelListeExerciceProf extends JPanel{
	
	private Classes cl; // La classe dont on souhaite les exercices
	private AcceuilProf acceuil; // L'acceuil pour les redirections
	private JTable tableExercice; // La table contenant les informations
	private TableListeExercice modeleTable; // Le modele de notre table
	
	/**
	 * Constructeur de notre classe
	 * @param cl La classe dont on souhaite les différents exercices
	 * @param acceuil L'acceuil de notre application
	 */
	public PanelListeExerciceProf(Classes cl, AcceuilProf acceuil){
		this.acceuil = acceuil;
		this.cl = cl;
		this.setLayout(new BorderLayout());
		JButton boutonCreation = new JButton("Creer un exercice");
		boutonCreation.setFont(new Font("Arial", Font.BOLD, 17));
		boutonCreation.setBackground(Color.lightGray);
		boutonCreation.setPreferredSize(new Dimension(2,40));
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
		modeleTable = new TableListeExercice(cl, (Professeur) this.acceuil.getUser());
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
