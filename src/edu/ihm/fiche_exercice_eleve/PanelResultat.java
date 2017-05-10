package edu.ihm.fiche_exercice_eleve;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Le panel comportant l'affichage du résultat de l'exercice
 * @author Aurelien
 *
 */
public class PanelResultat extends JPanel{

	/**
	 * Le constructeur de notre classe
	 * @param exerciceR L'exercice dont on souhaite récupérer le résultat
	 */
	public PanelResultat(ExerciceRealise exerciceR) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel resultat = new JLabel("<html><h1>&nbsp;&nbsp;Résultat :</h1></br><div>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Note :</h2></br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color:red\">"+exerciceR.getResultat().getNote()+"</span></br>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Commentaire :</h2></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ exerciceR.getResultat().getCommentaire()
				+ "</div></html>");
		JPanel result = new JPanel();
		result.setLayout(new FlowLayout(FlowLayout.LEFT));
		result.add(resultat);
		this.add(result);
		if(!exerciceR.getResultat().equals("Acquis")){
			JPanel debut = new JPanel();
			debut.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel titre = new JLabel("   Tentative notée :");
			titre.setFont(new Font("Arial", Font.BOLD, 20));
			debut.add(titre);
			this.add(debut);
			JPanel info = new JPanel();
			info.setLayout(new FlowLayout(FlowLayout.LEFT,30,30));
			JLabel name = new JLabel("                - Tentative ");
			name.setFont(new Font("Arial", Font.BOLD, 15));
			info.add(name);
			JButton voir = new JButton("Voir");
			voir.addActionListener(new ControlerPanelFicheExerciceEleve(exerciceR, exerciceR.getListeTentatives().get(exerciceR.getListeTentatives().size()-1)));
			info.add(voir);
			this.add(info);
		}
	}
}
