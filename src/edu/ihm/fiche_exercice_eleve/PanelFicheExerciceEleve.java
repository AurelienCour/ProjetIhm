package edu.ihm.fiche_exercice_eleve;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * Panel permettant la visualisation des informations d'un exercice
 * @author Aurelien
 *
 */
public class PanelFicheExerciceEleve extends JPanel{
	
	private Exercice exercice; // L'exercice visualisé
	private Eleve user; // L'élève regardant l'exercice
	
	/**
	 * Constructeur de la classe
	 * @param exercice L'exercice visualisé
	 * @param user L'élève regardant les informations
	 * @param acceuilEleve L'acceuil pour la redirection
	 */
	public PanelFicheExerciceEleve(Exercice exercice, Utilisateur user, AcceuilEleve acceuilEleve){
		this.exercice = exercice;
		this.user = (Eleve) user;
		this.setLayout(new BorderLayout());
		JPanel nord = new JPanel();
		nord.setLayout(new BorderLayout());
		JPanel description = new JPanel();
		boolean acquis = false;
		for (ExerciceRealise exoR : this.user.getExerciceRealise()) {
			if(exoR.getExerciceFait().equals(exercice)){
				if(exoR.isCorrect()){
					if(exoR.getResultat().getNote().equals("Acquis")){
						description.setLayout(new GridLayout(2, 1));
						JLabel nom = new JLabel("        Nom : "+exercice.getNomEx());
						nom.setFont(new Font("Arial", Font.PLAIN, 20));
						JLabel type = new JLabel("        Type : "+exercice.getTypeEx());
						type.setFont(new Font("Arial", Font.PLAIN, 20));
						description.add(nom);
						description.add(type);
						acquis = true;
					}
				}
			}
		}
		if(!acquis){
			description.setLayout(new GridLayout(3, 1));
			JLabel nom = new JLabel("        Nom : "+exercice.getNomEx());
			nom.setFont(new Font("Arial", Font.PLAIN, 20));
			JLabel type = new JLabel("        Type : "+exercice.getTypeEx());
			type.setFont(new Font("Arial", Font.PLAIN, 20));
			JPanel bouton = new JPanel();
			bouton.setLayout(new FlowLayout());
			JButton faire = new JButton("Faire");
			faire.addActionListener(new ControlerPanelFicheExerciceEleve(exercice,this.user,acceuilEleve));
			faire.setPreferredSize(new Dimension(75,40));
			bouton.add(faire);
			description.add(nom);
			description.add(type);
			description.add(bouton);
		}
		nord.add(description,BorderLayout.WEST);
		nord.add(new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT))),BorderLayout.EAST);
		this.add(nord,BorderLayout.NORTH);
		JPanel corp = new JPanel();
		corp.setLayout(new BoxLayout(corp,BoxLayout.Y_AXIS));
		boolean exerciceFait = false;
		for (ExerciceRealise exerciceR : this.user.getExerciceRealise()) {
			if(exerciceR.getExerciceFait().equals(exercice)){
				exerciceFait = true;
				if(exerciceR.isCorrect()){
					corp.add(new PanelResultat(exerciceR));
				}
				else{
					corp.add(new PanelTentative(exerciceR));
				}
				break;
			}
		}
		if(!exerciceFait){
			JLabel mauvais = new JLabel("    Exercice à faire");
			mauvais.setFont(new Font("Arial", Font.PLAIN, 30));
			corp.add(mauvais);
		}
		this.add(corp,BorderLayout.CENTER);
	}

}
