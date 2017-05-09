package edu.ihm.menu;


import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import edu.ihm.acceuil.Acceuil;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * Panel contenant le menu sous la forme d'un JTree
 * Va utiliser un objet de type Utilisateur
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelMenu{
	
	private Acceuil acceuil;
	private JTree tree;

	public PanelMenu(Acceuil acceuil){
		this.acceuil = acceuil;
		buildTree();
	}

	public void buildTree() {
		DefaultMutableTreeNode racine;
		if(acceuil.getUser() instanceof Professeur){
			Professeur pr = (Professeur) acceuil.getUser();
			racine = new DefaultMutableTreeNode("Classes");
			for (Classes cl : pr.getClasses()) {
				DefaultMutableTreeNode classe = new DefaultMutableTreeNode(cl);
				DefaultMutableTreeNode eleves = new DefaultMutableTreeNode("Eleves");
				for (Eleve el : cl.getEleves()) {
					DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
					eleves.add(eleve);
				}
				classe.add(eleves);
				
				DefaultMutableTreeNode exercices = new DefaultMutableTreeNode("Exercices");
				for(Exercice ex : cl.getExercices()){
					DefaultMutableTreeNode exo = new DefaultMutableTreeNode(ex);
					exercices.add(exo);
				}
				classe.add(exercices);
				racine.add(classe);
			}
		}
		else{
			Eleve el = (Eleve) acceuil.getUser();
			racine = new DefaultMutableTreeNode("Exercices");
			for(Exercice ex : el.getClasse().getExercices()){
				DefaultMutableTreeNode exo = new DefaultMutableTreeNode(ex);
				racine.add(exo);
			}
		}
		tree = new JTree(racine);
		tree.setRootVisible(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setCellRenderer(new TreeRenderer());
		tree.addTreeSelectionListener(new ControlerMenu(this));
		
	}
	
	public Acceuil getAcceuil(){
		return this.acceuil;
	}
	
	public JTree getJTree(){
		return this.tree;
	}

}
