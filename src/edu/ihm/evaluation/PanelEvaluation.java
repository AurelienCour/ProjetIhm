package edu.ihm.evaluation;


import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ihm.acceuil.Acceuil;
import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.noyau_fonctionnel.Evaluation;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Le panel permettant à un professeur d'évaluer la dernière tentative d'un élève
 * pour un exercice donné
 * Modifie la classe ExerciceRealise a l'aide du ControlerExercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelEvaluation extends JPanel{
	
	private JComboBox<String> combo;
	private JTextField comment;
	private ExerciceRealise exoR;
	private ConstructionExercice constructionExercice;
	private AcceuilProf acceuil;
	
	public PanelEvaluation(ExerciceRealise exoR, ConstructionExercice constructionExercice, Acceuil acceuil){
		this.exoR = exoR;
		this.acceuil = (AcceuilProf) acceuil;
		this.constructionExercice = constructionExercice;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
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
	    
	    this.add(title);
	    this.add(panelChoix);
	    this.add(commentaire);
	    this.add(comment);
	    this.add(valider);
	}
	
	public void correct (){
		Evaluation eval = new Evaluation(combo.getSelectedItem().toString(), comment.getText());
		exoR.corriger(eval);
		constructionExercice.dispose();
		acceuil.goFicheExercice(exoR.getExerciceFait());
	}

}
