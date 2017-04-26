package edu.ihm.resolution;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.tortue.TortueG;

public class ControlerResolution implements ActionListener {
	
	private PanelResolution panelResolution;
	private String idAction;
	private TortueG myTurtle;

	public ControlerResolution(PanelResolution panelResolution, String idAction, TortueG myTurtle) {
		this.panelResolution = panelResolution;
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
	}

}
