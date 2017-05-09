package edu.ihm.construction_exercice;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.ihm.acceuil.Acceuil;
import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.evaluation.PanelEvaluation;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.noyau_fonctionnel.Utilisateur;
import edu.ihm.replay.PanelCommandeReplay;
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
	private Acceuil acceuil;

	public ConstructionExercice(Utilisateur user, Exercice exercice, Acceuil acceuil){
		this.acceuil = acceuil;
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
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) size.getHeight();
		this.setSize(new Dimension(800, height-22));
		this.setLocationRelativeTo(null);
	}

	public ConstructionExercice(Tentative tentative, ExerciceRealise exoR) {
		this.setLayout(new BorderLayout());
		listeAction = new PanelListeAction(tentative);
        this.add(listeAction, BorderLayout.EAST);
        TortueG myTurtle;
		if(exoR.getExerciceFait().getTypeEx().equals("Couleur")){
			myTurtle = new TortueCouleur();
		}
		else if(exoR.getExerciceFait().getTypeEx().equals("Rapide")){
			myTurtle = new TortueRapide();
		}
		else{
			myTurtle = new TortueG();
		}
        this.add(Canvas.getCanvasPanel(), BorderLayout.CENTER);
        this.add(new PanelCommandeReplay(myTurtle,tentative), BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Visualisation de "+exoR.getExerciceFait().getNomEx());
		this.setVisible(true);
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) size.getHeight();
		this.setSize(new Dimension(800, height-75));
		this.setLocationRelativeTo(null);
	}

	public ConstructionExercice(ExerciceRealise exoR, boolean correct, Acceuil acceuil) {
		Tentative tent = exoR.getListeTentatives().get(exoR.getListeTentatives().size()-1);
		if(correct){
			this.setLayout(new BorderLayout());
			listeAction = new PanelListeAction(tent);
	        this.add(listeAction, BorderLayout.EAST);
	        TortueG myTurtle;
			if(exoR.getExerciceFait().getTypeEx().equals("Couleur")){
				myTurtle = new TortueCouleur();
			}
			else if(exoR.getExerciceFait().getTypeEx().equals("Rapide")){
				myTurtle = new TortueRapide();
			}
			else{
				myTurtle = new TortueG();
			}
	        this.add(Canvas.getCanvasPanel(), BorderLayout.CENTER);
	        this.add(new PanelCommandeReplay(myTurtle,tent), BorderLayout.SOUTH);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Correction de "+exoR.getExerciceFait().getNomEx());
			this.setVisible(true);
			Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int height = (int) size.getHeight();
			this.setSize(new Dimension(800, height-75));
			this.setLocationRelativeTo(null);
		}
		else{
			this.setLayout(new BorderLayout());
			PanelEvaluation evaluation = new PanelEvaluation(exoR,this,acceuil);
			listeAction = new PanelListeAction(tent);
			JPanel est = new JPanel();
			est.setLayout(new BorderLayout());
			est.add(evaluation, BorderLayout.NORTH);
			est.add(listeAction, BorderLayout.CENTER);
	        this.add(est, BorderLayout.EAST);
	        TortueG myTurtle;
			if(exoR.getExerciceFait().getTypeEx().equals("Couleur")){
				myTurtle = new TortueCouleur();
			}
			else if(exoR.getExerciceFait().getTypeEx().equals("Rapide")){
				myTurtle = new TortueRapide();
			}
			else{
				myTurtle = new TortueG();
			}
	        this.add(Canvas.getCanvasPanel(), BorderLayout.CENTER);
	        this.add(new PanelCommandeReplay(myTurtle,tent), BorderLayout.SOUTH);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Correction de "+exoR.getExerciceFait().getNomEx());
			this.setVisible(true);
			Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int height = (int) size.getHeight();
			this.setSize(new Dimension(800, height-75));
			this.setLocationRelativeTo(null);
		}
	}

	public void addActionEffectue(String newAction) {
		listeAction.addAction(newAction);
		model.addActionTentative(newAction);
	}
	
	
	public void finExercice(){
		this.dispose();
		if(acceuil instanceof AcceuilEleve){
			model.finExercice(acceuil);
		}
	}
	
	public ModelConstructionExercice getModel(){
		return this.model;
	}

	public void removeLastAction() {
		listeAction.removeLastAction();
		model.removeLastAction();
	}
}
