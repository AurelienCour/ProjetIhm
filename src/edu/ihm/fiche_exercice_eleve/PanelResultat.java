package edu.ihm.fiche_exercice_eleve;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;

/**
 * Panel permettant de visualiser le résultat d'un exercice évalué
 * Va utiliser un objet de type ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelResultat extends JPanel{

	public PanelResultat(ExerciceRealise exerciceR) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("<html><h1>Résultat :</h1></br><div>"
				+ "<h2>Note :</h2></br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color:red\">"+exerciceR.getResultat().getNote()+"</span></br>"
				+ "<h2>Commentaire :</h2></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ exerciceR.getResultat().getCommentaire()
				+ "</div></html>");
		this.add(titre);
	}

}
