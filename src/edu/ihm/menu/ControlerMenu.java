package edu.ihm.menu;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Professeur;


public class ControlerMenu implements TreeSelectionListener{
	
	private PanelMenu tree;
	
	/**
	 * Constructeur de la classe
	 * @param tree Le model de JTree utiliser
	 * @param model Model de notre application contenant les données
	 */
	public ControlerMenu(PanelMenu tree){
		this.tree = tree;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				tree.getJTree().getLastSelectedPathComponent();
		if (node == null) return;
		Object nodeInfo = node.getUserObject();
		if(nodeInfo instanceof Eleve){
			AcceuilProf acceuilProf = (AcceuilProf) tree.getAcceuil();
			acceuilProf.goFicheEleve((Eleve) nodeInfo);
		}
		else if(nodeInfo instanceof Classes){
			AcceuilProf acceuilProf = (AcceuilProf) tree.getAcceuil();
			//acceuilProf.goFicheEleve((Eleve) nodeInfo);
		}
		else if(nodeInfo instanceof Exercice){
			if(tree.getAcceuil().getUser() instanceof Eleve){
				
			}else if(tree.getAcceuil().getUser() instanceof Professeur){
				AcceuilProf acceuilProf = (AcceuilProf) tree.getAcceuil();
				acceuilProf.goFicheExercice((Exercice) nodeInfo);
			}
		}
	}
	
}
