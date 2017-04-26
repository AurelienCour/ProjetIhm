package edu.ihm.construction_exercice;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Utilisateur;
import edu.ihm.resolution.PanelResolution;
import edu.ihm.tortue.Canvas;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;

/**
 * La JFrame contenant le canvas, ainsi que les panel utile
 * a la visualisation et la résolution d'un exercice
 * Va utiliser un objet de type Exercice ou ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class ConstructionExercice extends JFrame{
	
	private Utilisateur user;
	private Exercice exercice;
	private PanelListeAction listeAction;

	public ConstructionExercice(Utilisateur user, Exercice exercice, String action){
		this.exercice = exercice;
		this.user = user;
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Réalisation de "+exercice.getNomEx());
		this.setVisible(true);
		this.setSize(800, 800);
		
		TortueG myGraphicTurtle = new TortueG();
		TortueCouleur myColorTurtle = new TortueCouleur("RED");
		TortueG myTurtle = myGraphicTurtle; // Default
        this.add(Canvas.getCanvasPanel(), BorderLayout.CENTER);
        if(user instanceof Eleve){
        	if(action.equals("resolution")){
        		this.add(new PanelResolution(exercice,myTurtle, this), BorderLayout.NORTH);
        	}
        }
        listeAction = new PanelListeAction();
        this.add(listeAction, BorderLayout.EAST);
	}

	public void finish() {
		this.dispose();
		if(user instanceof Eleve){
			Eleve el = (Eleve) user;
			el.addExerciceRealise(new ExerciceRealise(exercice));
		}
	}

	public void addActionEffectue(String newAction) {
		listeAction.addAction(newAction);
	}
}
