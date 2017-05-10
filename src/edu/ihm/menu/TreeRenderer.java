package edu.ihm.menu;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;

/**
 * Classe permettant la gestion du rendu dans le JTree
 * @author Aurelien
 *
 */
public class TreeRenderer implements TreeCellRenderer{

	
	private JPanel renderer = new JPanel(); // Le panel correspondant à l'affichage
	private JLabel name = new JLabel(); //  Le label correspondant au texte affiché
	private DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer(); // Le rendu par défaut
	private Color backgroundSelectionColor; // La couleur de selection dans le JTree
	private Color backgroundNonSelectionColor; // La couleur de fond des label

	/**
	 * Le constructeur de la classe
	 */
	public TreeRenderer() {
		backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
	    backgroundNonSelectionColor = defaultRenderer.getBackgroundNonSelectionColor();
		renderer.add(name);
		renderer.setBackground(backgroundNonSelectionColor);
	}

	/**
	 * Fonction permettant de modifier l'apparence du JTree
	 */
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus) {
		Component returnValue = null;
		if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
			Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
			if (userObject instanceof Eleve) {
				Eleve e = (Eleve) userObject;
				if (selected) {
		          renderer.setBackground(backgroundSelectionColor);
		        } else {
		          renderer.setBackground(backgroundNonSelectionColor);
		        }
				name.setText(e.getNom()+" "+e.getPrenom());
				returnValue = renderer;
			}
			else if(userObject instanceof Classes){
				if (selected) {
		          renderer.setBackground(backgroundSelectionColor);
		        } else {
		          renderer.setBackground(backgroundNonSelectionColor);
		        }
				Classes e = (Classes) userObject;
				name.setText(e.getNomClasse());
				returnValue = renderer;
			}
			else if(userObject instanceof Exercice){
				if (selected) {
		          renderer.setBackground(backgroundSelectionColor);
		        } else {
		          renderer.setBackground(backgroundNonSelectionColor);
		        }
				Exercice e = (Exercice) userObject;
				name.setText(e.getNomEx());
				returnValue = renderer;
			}
		}
		if (returnValue == null) {
			returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded,
					leaf, row, hasFocus);
		}
		return returnValue;
	}
}

