package edu.ihm.creation_exercice;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
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
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel nomEx = new JPanel();
		nomEx.setLayout(new GridLayout(1,2));
		nomEx.add(new JLabel("Nom exercice :"));
		nom = new JTextField();
		nomEx.add(nom);
		
		
		JPanel nomMod = new JPanel();
		nomMod.setLayout(new GridLayout(1,2));
		nomMod.add(new JLabel("Nom image :"));
		nomModel = new JTextField();
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
	    /*validate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(PanelCreationExercice.this.check1.isSelected())
					System.out.println(PanelCreationExercice.this.check1.getText());
				else if(PanelCreationExercice.this.check2.isSelected())
					System.out.println(PanelCreationExercice.this.check2.getText());
				else if(PanelCreationExercice.this.check3.isSelected())
					System.out.println(PanelCreationExercice.this.check3.getText());
			}
	    	
	    });*/
	    this.add(nomEx);
	    this.add(nomMod);
	    this.add(radioB);
	    this.add(validate);
	}
	
	public JTextField getFieldNom(){
		return this.nom;
	}
	
	public JTextField getFieldModele(){
		return this.nomModel;
	}
	
	public ArrayList<JCheckBox> getCheckBox(){
		ArrayList<JCheckBox> check = new ArrayList<JCheckBox>();
		check.add(check1);
		check.add(check2);
		check.add(check3);
		return check;
	}
	
	public void afterCreate(Exercice exo){
		acceuil.goFicheExercice(exo);
		acceuil.reloadTree();
	}
}
