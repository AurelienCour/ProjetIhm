package edu.ihm.creation_exercice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Exercice;

/** Panel contenant les outils necessaire à un professeur pour créer un exercice permet de choisir :
 * <ul>
 * 	<li>une image modèle</li>
 * 	<li>Le nom de l'exercice</li>
 * 	<li>Le type d'exercice</li>
 * </ul>
 * Va modifier un objet de type Exercice a l'aide d'un ControlerExercice
 * @author Aurelien
 *
 */
public class PanelCreationExercice extends JPanel{

	private AcceuilProf acceuil; // L'acceuil utilisant le panel
	private Classes cl; // La classe pour laquel l'exercice est créé
	private JTextField nom; // Le field du champ nom
	private JTextField nomModel; // Le field du nom de l'image
	private JCheckBox check1; // La checkBox "basique"
	private JCheckBox check2; // La checkBox "Couleur"
	private JCheckBox check3; // La checkBox "Rapide"
	
	/**
	 * Le constructeur de la class
	 * @param acceuilProf L'acceuil ayant fait appel au panel
	 * @param cl La classe ou l'exercice va être créé
	 */
	public PanelCreationExercice(AcceuilProf acceuilProf, Classes cl) {
		this.acceuil = acceuilProf;
		this.cl = cl;
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
	
	/**
	 * Le constructeur de la classe permettant de modifier un exercice
	 * @param acceuilProf L'acceuil ayant fait apppel à notre panel
	 * @param exo L'exercice à modifier
	 */
	public PanelCreationExercice(AcceuilProf acceuilProf, Exercice exo) {
		this.acceuil = acceuilProf;
		this.cl = cl;
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

	/**
	 * Permet de récupérer le nom
	 * @return Le nom entré dans la field
	 */
	public String getFieldNom(){
		return this.nom.getText();
	}
	
	/**
	 * Permet de récupérer le nom de l'image
	 * @return Le nom de l'image
	 */
	public String getFieldModele(){
		return this.nomModel.getText();
	}
	
	/**
	 * Permet de récupérer la valeur de la checkBox choisi
	 * @return La valeur de la checkBox choisi
	 */
	public String getCheckBoxSelected(){
		if(check1.isSelected())
			return check1.getText();
		else if(check2.isSelected())
			return check2.getText();
		else
			return check3.getText();
	}
	
	/**
	 * Permet de modifier le nom de l'image 
	 * @param nomImage Le nom de l'image saisi
	 */
	public void setTextModel(String nomImage){
		this.nomModel.setText(nomImage);
	}
	
	/**
	 * Permet d'effectuer les actions après la création de l'exercice
	 * @param exo L'exercice créé
	 */
	public void afterCreate(Exercice exo){
		acceuil.goFicheExercice(exo);
		acceuil.reloadTree();
	}
}
