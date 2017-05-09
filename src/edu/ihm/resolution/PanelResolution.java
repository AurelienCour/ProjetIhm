package edu.ihm.resolution;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

/**
 * Panel comportant les boutons pour resoudre un exercice
 * Va utiliser les objets ExerciceRealise et TortueG
 * Va utiliser le controler ControlerExercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelResolution extends JPanel{
	
	private Exercice exercice;
	private TortueG myTurtle;
	private ConstructionExercice constructionExercice;
	private PanelCouleur panelCouleur;
	private PanelVitesse panelVitesse;
	private JButton bRetour;

	public PanelResolution(Exercice exercice, TortueG myTurtle, ConstructionExercice constructionExercice){
		this.exercice = exercice;
		this.myTurtle = myTurtle;
		this.constructionExercice = constructionExercice;
		this.setLayout(new BorderLayout());
		
		JPanel boutonBase = new JPanel();
		boutonBase.setLayout(new GridLayout(2,2));
		JButton bAvance = new JButton("AVANCER");
		bAvance.addActionListener(new ControlerResolution(this,"avance",myTurtle));
		JButton bTrace = new JButton("TRACER");
		bTrace.addActionListener(new ControlerResolution(this,"trace",myTurtle));
		JButton bTourne = new JButton("TOURNER");
		bTourne.addActionListener(new ControlerResolution(this,"tourne",myTurtle));
		bRetour = new JButton("RETOUR");
		bRetour.addActionListener(new ControlerResolution(this,"retour",myTurtle));
		boutonBase.add(bAvance);
		boutonBase.add(bTrace);
		boutonBase.add(bTourne);
		boutonBase.add(bRetour);
		
		JPanel commande = new JPanel();
		commande.setLayout(new BorderLayout());
		commande.add(boutonBase, BorderLayout.CENTER);
		
		if(myTurtle instanceof TortueCouleur){
			panelCouleur = new PanelCouleur((TortueCouleur) myTurtle, this);
			commande.add(panelCouleur,BorderLayout.WEST);
		}
		else if(myTurtle instanceof TortueRapide){
			panelVitesse = new PanelVitesse((TortueRapide) myTurtle,this);
			commande.add(panelVitesse,BorderLayout.WEST);
		}
		this.add(new PanelModele(exercice),BorderLayout.WEST);
		this.add(commande,BorderLayout.CENTER);
		JButton bTermine = new JButton("TERMINE !");
		bTermine.addActionListener(new ControlerResolution(this,"fin",myTurtle));
		this.add(bTermine,BorderLayout.EAST);
	}

	public void addAction(String newAction) {
		constructionExercice.addActionEffectue(newAction);
	}
	
	public void finExercice() {
		constructionExercice.finExercice();
	}
	
	public void changeBouton(boolean etat){
		bRetour.setEnabled(etat);
	}

	public void removeLastAction() {
		constructionExercice.removeLastAction();
		if(myTurtle instanceof TortueCouleur){
			TortueCouleur turtle = (TortueCouleur) myTurtle;
			for (Action act : constructionExercice.getModel().getTentative().getListeAction()) {
				switch (act.getAction()) {
				case "Avance":
					turtle.avancer();
					break;
				case "Ne trace plus":
					turtle.tracer(false);
					break;
				case "Trace":
					turtle.tracer(true);
					break;
				case "Tourne":
					turtle.tourner();
					break;
				default:
					turtle.setCouleur(act.getAction());
					break;
				}
			}
			panelCouleur.changeCouleur(turtle.getCouleur());
		}
		else if(myTurtle instanceof TortueRapide){
			TortueRapide turtle = (TortueRapide) myTurtle;
			for (Action act : constructionExercice.getModel().getTentative().getListeAction()) {
				switch (act.getAction()) {
				case "Avance":
					turtle.avancer();
					break;
				case "Ne trace plus":
					turtle.tracer(false);
					break;
				case "Trace":
					turtle.tracer(true);
					break;
				case "Tourne":
					turtle.tourner();
					break;
				case "Accelere":
					turtle.accelerer();
					break;
				case "Ralenti":
					turtle.ralentir();
					break;
				default:
					break;
				}
			}
			panelVitesse.changeVitesse(Integer.toString(turtle.getVitesse()));
		}
		else{
			for (Action act : constructionExercice.getModel().getTentative().getListeAction()) {
				switch (act.getAction()) {
				case "Avance":
					myTurtle.avancer();
					break;
				case "Ne trace plus":
					myTurtle.tracer(false);
					break;
				case "Trace":
					myTurtle.tracer(true);
					break;
				case "Tourne":
					myTurtle.tourner();
					break;
				default:
					break;
				}
			}
		}
	}
}
