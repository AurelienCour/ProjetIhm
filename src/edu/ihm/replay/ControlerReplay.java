package edu.ihm.replay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.tortue.Canvas;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

public class ControlerReplay implements ActionListener {
	
	private String idButton;
	private TortueG myTurtle;
	private Tentative tentative;

	public ControlerReplay(TortueG myTurtle, Tentative tentative, String idButton) {
		this.idButton = idButton;
		this.myTurtle = myTurtle;
		this.tentative = tentative;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(myTurtle instanceof TortueRapide){
			TortueRapide turtle = (TortueRapide) myTurtle;
			if(idButton.equals("lecture")){
				for (Action act : tentative.getListeAction()) {
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
			}
		}
		else if(myTurtle instanceof TortueCouleur){
			TortueCouleur turtle = (TortueCouleur) myTurtle;
			if(idButton.equals("lecture")){
				for (Action act : tentative.getListeAction()) {
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
			}
		}
		else{
			if(idButton.equals("lecture")){
				for (Action act : tentative.getListeAction()) {
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

}
