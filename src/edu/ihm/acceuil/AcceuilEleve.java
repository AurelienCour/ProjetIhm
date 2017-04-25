package edu.ihm.acceuil;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import edu.ihm.fiche_exercice_eleve.PanelFicheExerciceEleve;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Utilisateur;

public class AcceuilEleve extends Acceuil{

	private JPanel panelInfo;
	
	public AcceuilEleve(Utilisateur user) {
		super(user);
		panelInfo = new JPanel();
		panelInfo.setLayout(new BorderLayout());
		goListeExercice();
		this.add(panelInfo,BorderLayout.CENTER);
	}
	
	public void goListeExercice(){
		panelInfo.removeAll();
		panelInfo.add(new PanelListeExerciceEleve(this));
		panelInfo.revalidate();
	}
	
	public void goFicheExercice(Exercice exercice){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheExerciceEleve(exercice));
		panelInfo.revalidate();
	}
}
