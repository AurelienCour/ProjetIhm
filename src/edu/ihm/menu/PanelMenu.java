package edu.ihm.menu;


import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * Panel contenant le menu sous la forme d'un JTree
 * Va utiliser un objet de type Utilisateur
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelMenu{
	
	private Utilisateur user;
	private JTree tree;

	public PanelMenu(Utilisateur user){
		this.user = user;
		buildTree();
	}

	public void buildTree() {
		if(user instanceof Professeur){
			Professeur pr = (Professeur) user;
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Classes");
			for (Classes cl : pr.getClasses()) {
				DefaultMutableTreeNode classe = new DefaultMutableTreeNode(cl);
				DefaultMutableTreeNode eleves = new DefaultMutableTreeNode("Eleves");
				for (Eleve el : cl.getEleves()) {
					DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
					eleves.add(eleve);
				}
				classe.add(eleves);
				
				DefaultMutableTreeNode exercices = new DefaultMutableTreeNode("Exercices");
				for(Exercice ex : cl.g)
				
				racine.add(classe);
			}
			
			tree = new JTree(racine);
			tree.setRootVisible(true);
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			tree.addTreeSelectionListener(new JTreeControler(this,this.model));
			tree.setCellRenderer(new TreeRenderer());
		}
		else if(user instanceof Eleve){
			Eleve el = (Eleve) user;
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Exercice");
		}
		
		

	}
	
	public JTree getJTree(){
		return this.tree;
	}

}
