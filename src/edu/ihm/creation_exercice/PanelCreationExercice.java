package edu.ihm.creation_exercice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Exercice;

/**
 * Panel contenant les outils necessaire à un professeur pour créer un exercice
 * permet de choisir :
 * 		- une image modèle
 * 		- Le nom de l'exercice
 * 		- Le type d'exercice
 * Va modifier un objet de type Exercice a l'aide d'un ControlerExercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelCreationExercice extends JPanel{

	private AcceuilProf acceuil;
	private Classes cl;
	private JTextField nom;
	private JTextField nomModel;
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	
	public PanelCreationExercice(AcceuilProf acceuilProf, Classes cl) {
		this.acceuil = acceuilProf;
		this.cl = cl;
		//this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 0);
		
		JPanel nomEx = new JPanel();
		nomEx.setLayout(new FlowLayout(FlowLayout.LEFT));
		nomEx.add(new JLabel("Nom exercice :"));
		nom = new JTextField();
		nom.setPreferredSize(new Dimension(150,25));
		nomEx.add(nom);
		
		
		JPanel nomMod = new JPanel();
		nomMod.setLayout(new FlowLayout(FlowLayout.LEFT));
		nomMod.add(new JLabel("Nom image :"));
		nomModel = new JTextField();
		nomModel.setPreferredSize(new Dimension(150,25));
		nomMod.add(nomModel);
		
		
	    ButtonGroup group = new ButtonGroup();
	    check1 = new JCheckBox("Basique");
	    check1.setSelected(true);
	    check2 = new JCheckBox("Couleur");
	    check3 = new JCheckBox("Rapide");
	    group.add(check1);
	    group.add(check2);
	    group.add(check3);
	    JPanel radioB = new JPanel();
	    radioB.setLayout(new GridLayout(1,3));
	    radioB.add(check1);
	    radioB.add(check2);
	    radioB.add(check3);
	    
	    JButton validate = new JButton("creer");
	    validate.addActionListener(new ControlerCreationExercice(this, acceuilProf.getUser()));
	    JButton rechercheButton = new JButton("Recherche une image");
	    rechercheButton.addActionListener(new ControlerCreationExercice(this));
		
	    this.add(nomEx,gbc);
	    this.add(rechercheButton,gbc);
	    this.add(nomMod,gbc);
	    this.add(radioB,gbc);
	    this.add(validate,gbc);
	}
	
	public PanelCreationExercice(AcceuilProf acceuilProf, Exercice exo) {
		this.acceuil = acceuilProf;
		this.cl = cl;
		//this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 0);
		
		JPanel nomEx = new JPanel();
		nomEx.setLayout(new FlowLayout(FlowLayout.LEFT));
		nomEx.add(new JLabel("Nom exercice :"));
		nom = new JTextField();
		nom.setText(exo.getNomEx());
		nom.setPreferredSize(new Dimension(150,25));
		nomEx.add(nom);
		
		JPanel nomMod = new JPanel();
		nomMod.setLayout(new FlowLayout(FlowLayout.LEFT));
		nomMod.add(new JLabel("Nom image :"));
		nomModel = new JTextField();
		nomModel.setText(exo.getNomImage());
		nomModel.setPreferredSize(new Dimension(150,25));
		nomMod.add(nomModel);
		
	    ButtonGroup group = new ButtonGroup();
	    check1 = new JCheckBox("Basique");
	    check2 = new JCheckBox("Couleur");
	    check3 = new JCheckBox("Rapide");
	    switch (exo.getTypeEx()) {
		case "Basique":
			check1.setSelected(true);
			break;
		case "Couleur":
			check2.setSelected(true);
			break;
		case "Rapide":
			check3.setSelected(true);
			break;
		default:
			break;
		}
	    group.add(check1);
	    group.add(check2);
	    group.add(check3);
	    JPanel radioB = new JPanel();
	    radioB.setLayout(new GridLayout(1,3));
	    radioB.add(check1);
	    radioB.add(check2);
	    radioB.add(check3);
	    
	    JButton validate = new JButton("Modifier");
	    validate.addActionListener(new ControlerCreationExercice(this, acceuilProf.getUser(), exo));
	    JButton rechercheButton = new JButton("Recherche une image");
	    rechercheButton.addActionListener(new ControlerCreationExercice(this));
		
		this.add(nomEx,gbc);
	    this.add(rechercheButton,gbc);
	    this.add(nomMod,gbc);
	    this.add(radioB,gbc);
	    this.add(validate,gbc);
	}

	public JTextField getFieldNom(){
		return this.nom;
	}
	
	public JTextField getFieldModele(){
		return this.nomModel;
	}
	
	public JCheckBox getCheckBoxSelected(){
		if(check1.isSelected())
			return check1;
		else if(check2.isSelected())
			return check2;
		else
			return check3;
	}
	
	public void setTextModel(String nomImage){
		this.nomModel.setText(nomImage);
	}
	
	public void afterCreate(Exercice exo){
		acceuil.goFicheExercice(exo);
		acceuil.reloadTree();
	}
}
