package edu.ihm.fiche_enfant_prof;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.fiche_exercice_prof.ControlerFicheExerciceProf;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Panel de visualisation de la fiche d'un enfant
 * Va utiliser un objet de type Eleve
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheEnfantProf extends JPanel{
	
	private Eleve eleve;
	
	public PanelFicheEnfantProf(Eleve eleve, AcceuilProf acceuilProf){
		this.setBackground(new Color(225, 206, 154));
		
		this.eleve = eleve;
		this.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setLayout(new BorderLayout());
		JLabel nom = new JLabel("        "+eleve.getNom()+" "+eleve.getPrenom());
		nom.setFont(new Font("Arial", Font.PLAIN, 20));
		
		nord.add(nom,BorderLayout.WEST);
		nord.add(new JLabel(new ImageIcon(new ImageIcon(eleve.getPhoto()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT))),BorderLayout.EAST);
		
		JPanel corp = new JPanel();
		corp.setLayout(new BoxLayout(corp, BoxLayout.Y_AXIS));
		corp.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel debut = new JPanel();
		debut.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel titre = new JLabel("        Liste des exercices :");
		titre.setFont(new Font("Arial", Font.PLAIN, 20));
		debut.add(titre);
		corp.add(debut);
		boolean fait = false;
		for (Exercice exo : eleve.getClasse().getExercices()) {
			fait = false;
			JPanel info = new JPanel();
			info.setLayout(new FlowLayout(FlowLayout.LEFT,30,30));
			JLabel name = new JLabel("                -   "+exo.getNomEx());
			name.setFont(new Font("Arial", Font.PLAIN, 15));
			info.add(name);
			for (ExerciceRealise exoR : eleve.getExerciceRealise()) {
				if(exoR.getExerciceFait().equals(exo)){
					fait = true;
					if(exoR.isCorrect()){
						JButton voir = new JButton("Voir");
						voir.addActionListener(new ControlerFicheExerciceProf(exoR,"Voir", acceuilProf));
						info.add(voir);
						JLabel statut = new JLabel("Corrigé");
						statut.setFont(new Font("Arial", Font.BOLD, 15));
						statut.setForeground(Color.RED);
						info.add(statut);
					}
					else {
						JButton voir = new JButton("Corriger");
						voir.addActionListener(new ControlerFicheExerciceProf(exoR,"Corriger", acceuilProf));
						info.add(voir);
					}
				}
			}
			if(!fait){
				JLabel statut = new JLabel("Pas fait");
				statut.setFont(new Font("Arial", Font.BOLD, 15));
				statut.setForeground(Color.BLUE);
				info.add(statut);
			}
			corp.add(info);
		}
		
		this.add(nord, BorderLayout.NORTH);
		this.add(corp, BorderLayout.CENTER);
	}

}
