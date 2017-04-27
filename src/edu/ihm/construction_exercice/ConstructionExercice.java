package edu.ihm.construction_exercice;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Utilisateur;
import edu.ihm.resolution.PanelResolution;
import edu.ihm.tortue.Canvas;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

/**
 * La JFrame contenant le canvas, ainsi que les panel utile
 * a la visualisation et la résolution d'un exercice
 * Va utiliser un objet de type Exercice ou ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class ConstructionExercice extends JFrame{
	
	private PanelListeAction listeAction;
	private ModelConstructionExercice model;

	public ConstructionExercice(Utilisateur user, Exercice exercice){
		this.model = new ModelConstructionExercice(user,exercice);
		this.setLayout(new BorderLayout());
		listeAction = new PanelListeAction();
        this.add(listeAction, BorderLayout.EAST);
        TortueG myTurtle;
		if(exercice.getTypeEx().equals("Couleur")){
			myTurtle = new TortueCouleur();
		}
		else if(exercice.getTypeEx().equals("Rapide")){
			myTurtle = new TortueRapide();
		}
		else{
			myTurtle = new TortueG();
		}
        this.add(Canvas.getCanvasPanel(), BorderLayout.CENTER);
		this.add(new PanelResolution(exercice,myTurtle, this), BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Réalisation de "+exercice.getNomEx());
		this.setVisible(true);
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
	}

	public void addActionEffectue(String newAction) {
		listeAction.addAction(newAction);
		model.addActionTentative(newAction);
	}
	
	public void finExercice(){
		this.dispose();
		model.finExercice();
	}
}
