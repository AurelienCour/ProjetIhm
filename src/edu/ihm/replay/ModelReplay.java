package edu.ihm.replay;

import java.util.ArrayList;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

public class ModelReplay {
	
	private PanelCommandeReplay panelCommandeReplay;
	private TortueG myTurtle;
	private Tentative tentative;
	private ArrayList<Action> listeActionTemp;

	public ModelReplay(PanelCommandeReplay panelCommandeReplay, TortueG myTurtle, Tentative tentative) {
		listeActionTemp = (ArrayList<Action>) tentative.getListeAction().clone();
		this.tentative = tentative;
		this.myTurtle = myTurtle;
		this.panelCommandeReplay = panelCommandeReplay;
	}
	
	public void avance(){
		myTurtle.avancer();
	}
	
	public void tracer (boolean tracer){
		myTurtle.tracer(tracer);
	}
	
	public void tourner(){
		myTurtle.tourner();
	}
	
	public void accelerer(){
		((TortueRapide) myTurtle).accelerer();
	}
	
	public void ralentir (){
		((TortueRapide) myTurtle).ralentir();
	}
	
	public void setCouleur(String coul){
		((TortueCouleur) myTurtle).setCouleur(coul);
	}
	
	public void reset(){
		myTurtle.reset();
		listeActionTemp = (ArrayList<Action>) tentative.getListeAction().clone();
	}
	
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
	
	private void removeAction(){
		listeActionTemp.remove(0);
	}

}
