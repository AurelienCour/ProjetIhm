package edu.ihm.resolution;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

public class ControlerResolution implements ActionListener {
	
	private PanelResolution panelResolution;
	private String idAction;
	private TortueG myTurtle;
	private PanelVitesse panelVitesse;
	private PanelCouleur panelCouleur;

	public ControlerResolution(PanelResolution panelResolution, String idAction, TortueG myTurtle) {
		this.panelResolution = panelResolution;
		this.idAction = idAction;
		this.myTurtle = myTurtle;
	}

	public ControlerResolution(PanelVitesse panelVitesse, String idAction, TortueG myTurtle,
			PanelResolution panelResolution) {
		this.panelResolution = panelResolution;
		this.panelVitesse = panelVitesse;
		this.idAction = idAction;
		this.myTurtle = myTurtle;
	}

	public ControlerResolution(PanelCouleur panelCouleur, String idAction, TortueG myTurtle,
			PanelResolution panelResolution) {
		this.panelResolution = panelResolution;
		this.panelCouleur = panelCouleur;
		this.idAction = idAction;
		this.myTurtle = myTurtle;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(idAction.equals("avance")){
			myTurtle.avancer();
			panelResolution.addAction("Avance");
		}
		else if(idAction.equals("trace")){
			if(myTurtle.enTrace()){
				myTurtle.tracer(false);
				panelResolution.addAction("Ne trace plus");
			}
			else{
				myTurtle.tracer(true);
				panelResolution.addAction("Trace");
			}
		}
		else if(idAction.equals("tourne")){
			myTurtle.tourner();
			panelResolution.addAction("Tourne");
		}
		else if(idAction.equals("add")){
			((TortueRapide) myTurtle).accelerer();
			panelVitesse.changeVitesse(Integer.toString(((TortueRapide) myTurtle).getVitesse()));
			panelResolution.addAction("Accelere");
		}
		else if(idAction.equals("remove")){
			if(((TortueRapide) myTurtle).getVitesse() != 0){
				((TortueRapide) myTurtle).ralentir();
				panelVitesse.changeVitesse(Integer.toString(((TortueRapide) myTurtle).getVitesse()));
				panelResolution.addAction("Ralenti");
			}
		}
		else if(panelCouleur != null){
			((TortueCouleur) myTurtle).setCouleur(idAction);
			panelCouleur.changeCouleur(idAction);
			panelResolution.addAction(idAction);
		}
	}

}
