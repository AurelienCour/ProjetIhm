package edu.ihm.resolution;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.ihm.construction_exercice.ConstructionExercice;
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
		JButton bRetour = new JButton("RETOUR");
		bRetour.addActionListener(new ControlerResolution(this,"retour",myTurtle));
		boutonBase.add(bAvance);
		boutonBase.add(bTrace);
		boutonBase.add(bTourne);
		boutonBase.add(bRetour);
		
		JPanel commande = new JPanel();
		commande.setLayout(new BorderLayout());
		commande.add(boutonBase, BorderLayout.CENTER);
		
		if(myTurtle instanceof TortueCouleur)
			commande.add(new PanelCouleur((TortueCouleur) myTurtle, this),BorderLayout.WEST);
		else if(myTurtle instanceof TortueRapide)
			commande.add(new PanelVitesse((TortueRapide) myTurtle,this),BorderLayout.WEST);
		
		this.add(new PanelModele(exercice),BorderLayout.WEST);
		this.add(commande,BorderLayout.CENTER);
		this.add(new JButton("TERMINE !"),BorderLayout.EAST);
	}

	public void addAction(String newAction) {
		constructionExercice.addActionEffectue(newAction);
	}
}
