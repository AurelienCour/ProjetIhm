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
 * @author Aurelien
 *
 */
public class ConstructionExercice extends JFrame{
	
	private PanelListeAction listeAction; // Le panel correspondant a la liste des actions
	private ModelConstructionExercice model; // Le model de notre JFrame
	private Acceuil acceuil; // L'acceuil qui a fait appel à la classe

	/**
	 * Le constructeur de la class permettant la résolution d'une exercice
	 * @param user L'utilisateur connecté
	 * @param exercice L'exercice  L'exercice à réalisé
	 * @param acceuil // L'acceuil ayant fait appel au constructeur
	 */
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
		this.setSize(new Dimension(800, 630));
		this.setLocationRelativeTo(null);
	}

	/**
	 * Le constructeur de notre class permettant la visualisation d'un exercice pour un élève
	 * @param tentative La tentative visualisé
	 * @param exoR L'exerciceRealise
	 */
	public ConstructionExercice(Tentative tentative, ExerciceRealise exoR) {
		this.setLayout(new BorderLayout());
		PanelModele mod = new PanelModele(exoR.getExerciceFait());
		listeAction = new PanelListeAction(tentative);
		JPanel est = new JPanel();
		est.setLayout(new BorderLayout());
		est.add(mod, BorderLayout.NORTH);
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
        this.add(new PanelCommandeReplay(myTurtle,tentative), BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Visualisation de "+exoR.getExerciceFait().getNomEx());
		this.setVisible(true);
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) size.getHeight();
		this.setSize(new Dimension(830, 655));
		this.setLocationRelativeTo(null);
	}

	/**
	 * Le constructeur de notre class pour la visualisation ou la notation d'un exercice pour un professeur
	 * @param exoR	L'exercice Realise
	 * @param correct Permmet de savoir si l'exercice est corrigé, true si il est déja corrigé
	 * @param acceuil	L'acceuil faisant appel au constructeur
	 */
	public ConstructionExercice(ExerciceRealise exoR, boolean correct, Acceuil acceuil) {
		Tentative tent = exoR.getListeTentatives().get(exoR.getListeTentatives().size()-1);
		if(correct){
			this.setLayout(new BorderLayout());
			PanelModele mod = new PanelModele(exoR.getExerciceFait());
			listeAction = new PanelListeAction(tent);
			JPanel est = new JPanel();
			est.setLayout(new BorderLayout());
			est.add(mod, BorderLayout.NORTH);
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
			this.setSize(new Dimension(830, 655));
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
			this.setSize(new Dimension(830, 655));
			this.setLocationRelativeTo(null);
		}
	}

	/**
	 * Permet d'ajouter une action au panel ListeAction
	 * @param newAction L'action à ajouter
	 */
	public void addActionEffectue(String newAction) {
		listeAction.addAction(newAction);
		model.addActionTentative(newAction);
	}
	
	/**
	 * Fonction appelé lorsque la réalisation de l'exercice est terminé
	 * Permet de mettre a jour le model ainsi que le menu
	 */
	public void finExercice(){
		this.dispose();
		if(acceuil instanceof AcceuilEleve){
			model.finExercice(acceuil);
			acceuil.reloadTree();
		}
	}
	
	/**
	 * permet de récupérer le model de la classe
	 * @return Le model de la classe
	 */
	public ModelConstructionExercice getModel(){
		return this.model;
	}

	/**
	 * Permet d'enlever la dernière action effectué
	 * Utile lors de l'utilisation du bouton retour lors de la résolution d'un exercice
	 */
	public void removeLastAction() {
		listeAction.removeLastAction();
		model.removeLastAction();
	}
}
