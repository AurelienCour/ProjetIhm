package edu.ihm.replay;

import java.util.ArrayList;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

/**
 * Le model permettant la gestion des données lors du replay
 * @author Aurelien
 *
 */
public class ModelReplay {
	
	private PanelCommandeReplay panelCommandeReplay; // Le panel contenant les commandes
	private TortueG myTurtle; // La tortue qui est modifié suivant les actions
	private Tentative tentative; // La tentative contenant les actions
	private ArrayList<Action> listeActionTemp; // La liste des actions temporaire lors de la navigation

	/**
	 * Le constructeur de notre classe
	 * @param panelCommandeReplay Le panel contenant les boutons
	 * @param myTurtle La tortue que l'on souhaite faire bouger
	 * @param tentative La tentative correspondant
	 */
	public ModelReplay(PanelCommandeReplay panelCommandeReplay, TortueG myTurtle, Tentative tentative) {
		listeActionTemp = (ArrayList<Action>) tentative.getListeAction().clone();
		this.tentative = tentative;
		this.myTurtle = myTurtle;
		this.panelCommandeReplay = panelCommandeReplay;
	}
	
	/**
	 * Fonction permettant de faire avancer la tortue
	 */
	public void avance(){
		myTurtle.avancer();
	}
	
	/**
	 * Fonction permettant de faire tracer ou non la tortue
	 * @param tracer True pour faire tracer la tortue 
	 */
	public void tracer (boolean tracer){
		myTurtle.tracer(tracer);
	}
	
	/**
	 * Fonction permettant de faire tourner la tortue
	 */
	public void tourner(){
		myTurtle.tourner();
	}
	
	/**
	 * Fonction permettant de faire accelerer la tortue
	 */
	public void accelerer(){
		((TortueRapide) myTurtle).accelerer();
	}
	
	/**
	 * Fonction permettant de faire ralentir la tortue
	 */
	public void ralentir (){
		((TortueRapide) myTurtle).ralentir();
	}
	
	/**
	 * Fonction permettant de modifié la couleur du tracé de la tortue
	 * @param coul La nouvelle couleur
	 */
	public void setCouleur(String coul){
		((TortueCouleur) myTurtle).setCouleur(coul);
	}
	
	/**
	 * Fonction permettant de reinitialisé la tortue et remettre les actions à 0
	 */
	public void reset(){
		myTurtle.reset();
		listeActionTemp = (ArrayList<Action>) tentative.getListeAction().clone();
	}
	
	/**
	 * Permet d'effectuer l'action suivante de la liste
	 */
	public void actSuivante(){
		if(listeActionTemp.isEmpty()){
			panelCommandeReplay.setBouton(false,false);
		}
		else{
			switch (listeActionTemp.get(0).getAction()) {
			case "Avance":
				avance();
				break;
			case "Ne trace plus":
				tracer(false);
				break;
			case "Trace":
				tracer(true);
				break;
			case "Tourne":
				tourner();
				break;
			case "Accelere":
				accelerer();
				break;
			case "Ralenti":
				ralentir();
				break;
			default:
				setCouleur(listeActionTemp.get(0).getAction());
				break;
			}
			removeAction();
		}
		if(listeActionTemp.isEmpty()){
			panelCommandeReplay.setBouton(false,false);
		}
	}
	
	/**
	 * Permet d'effectuer toutes les actions sur la tortue
	 */
	public void lecture(){
		for (Action act : tentative.getListeAction()) {
			switch (act.getAction()) {
			case "Avance":
				avance();
				break;
			case "Ne trace plus":
				tracer(false);
				break;
			case "Trace":
				tracer(true);
				break;
			case "Tourne":
				tourner();
				break;
			case "Accelere":
				accelerer();
				break;
			case "Ralenti":
				ralentir();
				break;
			default:
				setCouleur(act.getAction());
				break;
			}
		}
	}
	
	/**
	 * Permet d'enlever l'action effectué de la liste temporaire
	 */
	private void removeAction(){
		listeActionTemp.remove(0);
	}

}
