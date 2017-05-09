package edu.ihm.fiche_exercice_prof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.fiche_exercice_eleve.ControlerPanelFicheExerciceEleve;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Professeur;

/**
 * Panel permettant de visualiser la fiche d'un exercice pour un professeur
 * Va utiliser un objet de type Exercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheExerciceProf extends JPanel{
	
	private Exercice exercice;
	
	public PanelFicheExerciceProf(Exercice exercice, Professeur user, AcceuilProf acceuilProf){
		this.exercice = exercice;
		this.setLayout(new BorderLayout());
		JPanel corp = new JPanel();
		corp.setLayout(new BoxLayout(corp, BoxLayout.Y_AXIS));
		corp.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel debut = new JPanel();
		debut.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel titre = new JLabel("        Liste des enfants ayant réalisé l'exercice :");
		titre.setFont(new Font("Arial", Font.PLAIN, 20));
		debut.add(titre);
		corp.add(debut);
		boolean fait = false;;
		for (Classes classes : user.getClasses()) {
			for (Eleve eleve : classes.getEleves()) {
				for (ExerciceRealise exoR : eleve.getExerciceRealise()) {
					if(exoR.getExerciceFait().equals(exercice)){
						JPanel info = new JPanel();
						info.setLayout(new FlowLayout(FlowLayout.LEFT,30,30));
						JLabel name = new JLabel("                -   "+eleve.getNom()+" "+eleve.getPrenom());
						name.setFont(new Font("Arial", Font.BOLD, 15));
						info.add(name);
						if(exoR.isCorrect()){
							JButton voir = new JButton("Voir");
							voir.addActionListener(new ControlerFicheExerciceProf(exoR,"Voir",acceuilProf));
							info.add(voir);
							JLabel statut = new JLabel("Corrigé : "+exoR.getResultat().getNote());
							statut.setFont(new Font("Arial", Font.BOLD, 15));
							statut.setForeground(Color.RED);
							info.add(statut);
						}
						else{
							JButton voir = new JButton("Corriger");
							voir.addActionListener(new ControlerFicheExerciceProf(exoR,"Corriger",acceuilProf));
							info.add(voir);
						}
						corp.add(info);
						fait = true;
					}
				}
			}
		}
		JPanel nord = new JPanel();
		if(!fait){
			nord = new JPanel();
			nord.setLayout(new BorderLayout());
			JPanel description = new JPanel();
			description.setLayout(new GridLayout(3, 1));
			JLabel nom = new JLabel("        Nom : "+exercice.getNomEx());
			nom.setFont(new Font("Arial", Font.PLAIN, 20));
			JLabel type = new JLabel("        Type : "+exercice.getTypeEx());
			type.setFont(new Font("Arial", Font.PLAIN, 20));
			description.add(nom);
			description.add(type);
			JPanel bouton = new JPanel();
			bouton.setLayout(new FlowLayout());
			JButton modif = new JButton("Modification");
			modif.addActionListener(new ControlerFicheExerciceProf(exercice, "Modification", acceuilProf));
			modif.setPreferredSize(new Dimension(120,40));
			bouton.add(modif);
			description.add(bouton);
			nord.add(description,BorderLayout.WEST);
			nord.add(new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT))),BorderLayout.EAST);
		}
		else{
			nord = new JPanel();
			nord.setLayout(new BorderLayout());
			JPanel description = new JPanel();
			description.setLayout(new GridLayout(2, 1));
			JLabel nom = new JLabel("        Nom : "+exercice.getNomEx());
			nom.setFont(new Font("Arial", Font.PLAIN, 20));
			JLabel type = new JLabel("        Type : "+exercice.getTypeEx());
			type.setFont(new Font("Arial", Font.PLAIN, 20));
			description.add(nom);
			description.add(type);
			nord.add(description,BorderLayout.WEST);
			nord.add(new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT))),BorderLayout.EAST);
		}
		this.add(nord, BorderLayout.NORTH);
		this.add(corp, BorderLayout.CENTER);
	}

}
