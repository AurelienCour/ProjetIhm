package edu.ihm.menu;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import edu.ihm.acceuil.Acceuil;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Professeur;

/**
 *  Panel contenant le menu sous la forme d'un JTree
 * @author Aurelien
 *
 */
public class PanelMenu{
	
	private Acceuil acceuil; // L'acceuil pour les redirections
	private JTree tree; // Le Jtree associé

	/**
	 * Le constructeur de la classe
	 * @param acceuil L'acceuil pour les redirections
	 */
	public PanelMenu(Acceuil acceuil){
		this.acceuil = acceuil;
		buildTree();
	}

	/**
	 * Permet l'initialisation et la construction du JTree
	 */
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
	
	/**
	 * Permet de récupérer l'acceuil du JTree
	 * @return L'acceuil de l'application
	 */
	public Acceuil getAcceuil(){
		return this.acceuil;
	}
	
	/**
	 * Permet de récupérer l'arbre
	 * @return Le Jtree correspondant
	 */
	public JTree getJTree(){
		return this.tree;
	}

}
