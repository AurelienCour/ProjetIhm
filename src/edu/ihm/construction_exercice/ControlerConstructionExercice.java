package edu.ihm.construction_exercice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.tortue.TortueG;

public class ControlerConstructionExercice implements ActionListener {
	
	private TortueG turtle;
	private String idButton;
	private ConstructionExercice frame;

	public ControlerConstructionExercice(TortueG myTurtle, String idButton, ConstructionExercice frame) {
		this.turtle = myTurtle;
		this.idButton = idButton;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(idButton.equals("avance"))
			turtle.avancer();
		else if(idButton.equals("trace")){
			if(turtle.enTrace())
				turtle.tracer(false);
			else
				turtle.tracer(true);
		}
		else if(idButton.equals("tourne"))
			turtle.tourner();
		else
			frame.finish();
	}

}
