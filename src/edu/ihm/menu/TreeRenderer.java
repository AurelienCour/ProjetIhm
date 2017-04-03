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

public class TreeRenderer implements TreeCellRenderer{

	
	private JPanel renderer = new JPanel();
	private JLabel name = new JLabel();
	private DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
	private Color backgroundSelectionColor;
	private Color backgroundNonSelectionColor;

	public TreeRenderer() {
		backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
	    backgroundNonSelectionColor = defaultRenderer.getBackgroundNonSelectionColor();
		renderer.add(name);
		renderer.setBackground(Color.WHITE);
	}

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
				name.setText(e.toString());
				returnValue = renderer;
			}
			else if(userObject instanceof Classes){
				if (selected) {
		          renderer.setBackground(backgroundSelectionColor);
		        } else {
		          renderer.setBackground(backgroundNonSelectionColor);
		        }
				Classes e = (Classes) userObject;
				name.setText(e.);
				returnValue = renderer;
			}
			else if()
		}
		if (returnValue == null) {
			returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded,
					leaf, row, hasFocus);
		}
		return returnValue;
	}
}
