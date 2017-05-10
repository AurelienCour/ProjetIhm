package edu.ihm.evaluation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ihm.acceuil.Acceuil;
import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.construction_exercice.PanelModele;
import edu.ihm.noyau_fonctionnel.Evaluation;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Le panel permettant à un professeur d'évaluer la dernière tentative d'un élève
 * @author Aurelien
 *
 */
public class PanelEvaluation extends JPanel{
	
	private JComboBox<String> combo; // Les différentes checkBox
	private JTextField comment; // La field contenant le commentaire
	private ExerciceRealise exoR; // L'exercire évalué
	private ConstructionExercice constructionExercice; // La frame utilisant le panel
	private AcceuilProf acceuil; // L'acceuil de l'application pour la redirecion
	
	/**
	 * Le constructeur de notre classe
	 * @param exoR L'exercice évalué
	 * @param constructionExercice La frame utilisant le panel
	 * @param acceuil L'acceuil pour la redirection
	 */
	public PanelEvaluation(ExerciceRealise exoR, ConstructionExercice constructionExercice, Acceuil acceuil){
		this.exoR = exoR;
		this.acceuil = (AcceuilProf) acceuil;
		this.constructionExercice = constructionExercice;
		this.setLayout(new GridLayout(2, 1));
		
		JPanel eval = new JPanel();
		eval.setLayout(new BoxLayout(eval,BoxLayout.Y_AXIS));
		eval.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel title = new JLabel("Evaluation");
		
		JPanel panelChoix = new JPanel();
		JLabel choix = new JLabel("Choix :");
		combo = new JComboBox<String>();
		combo.setPreferredSize(new Dimension(100, 20));
	    combo.addItem("Acquis");
	    combo.addItem("En cours");
	    combo.addItem("Non acquis");
	    
	    panelChoix.add(choix);
	    panelChoix.add(combo);
	    
	    JLabel commentaire = new JLabel("Commentaire :");
	    comment = new JTextField();
		
	    JButton valider = new JButton("Valider");
	    valider.addActionListener(new ControlerEvaluation(this));
	    
	    eval.add(title);
	    eval.add(panelChoix);
	    eval.add(commentaire);
	    eval.add(comment);
	    eval.add(valider);
	    this.add(new PanelModele(exoR.getExerciceFait()));
	    this.add(eval);
	}
	
	/**
	 * Permet d'ajouter l'evaluation à l'exercice
	 */
	public void correct (){
		Evaluation eval = new Evaluation(combo.getSelectedItem().toString(), comment.getText());
		exoR.corriger(eval);
		constructionExercice.dispose();
		acceuil.goFicheExercice(exoR.getExerciceFait());
	}

}
