package edu.ihm.resolution;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

/**
 * Classe permettant de gérer les intéractions avec le panel de resolution
 * @author Aurelien
 *
 */
public class ControlerResolution implements ActionListener {
	
	private PanelResolution panelResolution; // Le panel contenant les boutons
	private String idAction; // L'idée de l'action effectué
	private TortueG myTurtle; // La tortue que l'on fait bougé
	private PanelVitesse panelVitesse; // le panel contenant les boutons pour la gestion de la vitesse
	private PanelCouleur panelCouleur; // Le panel contenant les boutons pour la gestion de la couleur

	/**
	 * Le constructeur de la classe pour la gestion des commandes de bases
	 * @param panelResolution Le panel correspondant
	 * @param idAction L'id du bouton
	 * @param myTurtle La tortue a déplacer
	 */
	public ControlerResolution(PanelResolution panelResolution, String idAction, TortueG myTurtle) {
		this.panelResolution = panelResolution;
		this.idAction = idAction;
		this.myTurtle = myTurtle;
	}

	/**
	 * Le constructeur de la classe pour la gestion des commandes de la tortue rapide
	 * @param panelVitesse Le panel correspondant
	 * @param idAction L'id du bouton
	 * @param myTurtle La tortue a déplacer
	 * @param panelResolution Le panel avec les boutons de base
	 */
	public ControlerResolution(PanelVitesse panelVitesse, String idAction, TortueG myTurtle,
			PanelResolution panelResolution) {
		this.panelResolution = panelResolution;
		this.panelVitesse = panelVitesse;
		this.idAction = idAction;
		this.myTurtle = myTurtle;
	}

	/**
	 * Constructeur de la classe pour la gestion des intéractions avec les boutons pour gérer la couleur
	 * @param panelCouleur Le panel correspondant
	 * @param idAction L'id du bouton
	 * @param myTurtle La tortue que l'on veux déplacer
	 * @param panelResolution Le panel contenant les boutons de base
	 */
	public ControlerResolution(PanelCouleur panelCouleur, String idAction, TortueG myTurtle,
			PanelResolution panelResolution) {
		this.panelResolution = panelResolution;
		this.panelCouleur = panelCouleur;
		this.idAction = idAction;
		this.myTurtle = myTurtle;
	}

	/**
	 * Fonction permettant de gérer les différentes intéractions
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panelResolution.changeBouton(true);
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
		else if(idAction.equals("fin")){
			panelResolution.finExercice();
		}
		else if(idAction.equals("retour")){
			panelResolution.changeBouton(false);
			myTurtle.reset();
			if(myTurtle instanceof TortueCouleur){
				((TortueCouleur) myTurtle).setCouleur("black");
				panelResolution.removeLastAction();
			}
			else if(myTurtle instanceof TortueRapide){
				((TortueRapide) myTurtle).setVitesse(1);
				panelResolution.removeLastAction();
			}
			else{
				panelResolution.removeLastAction();
			}
		}
		else if(panelCouleur != null){
			((TortueCouleur) myTurtle).setCouleur(idAction);
			panelCouleur.changeCouleur(idAction);
			panelResolution.addAction(idAction);
		}
	}

}
