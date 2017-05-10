package edu.ihm.noyau_fonctionnel;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Classe héritant d’Utilisateur. Cette classe permet de représenter un élève
 * @author MathiasAntunes
 * @version 30/03/2017
 */
public class Eleve extends Utilisateur{
	
	private ArrayList<ExerciceRealise> exerciceRealise; // Liste des exercices réalisés par un élève.
	
	private Classes classe; // La classe de l’élève
	
	private URL photo; // Le chemin absolu menant à la photo

	private String nomPhoto; // Le nom de l'image
	
	/**
	 * Constructeur de la classe eleve
	 * @param identifiant L'identifiant de l'élève
	 * @param motDePasse Le mot de passe de l'élève
	 * @param nom Le nom de l'élève
	 * @param prenom Le prénom de l'élève
	 * @param classe La classe de l'élève
	 * @param photo Le nom de la photo de l'élève
	 */
	public Eleve(String identifiant, String motDePasse, String nom, String prenom,
			Classes classe, String photo) {
		super(identifiant, motDePasse, nom, prenom);
		this.classe = classe;
		this.nomPhoto = photo;
		try{
			this.photo = Eleve.class.getResource("Image/"+photo);
			ImageIcon ic = new ImageIcon(new ImageIcon(this.photo).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		}
		catch(NullPointerException e){
			this.photo = Eleve.class.getResource("Image/no-image-found.gif");
		}
		this.exerciceRealise = new ArrayList<ExerciceRealise>();
	}
	
	/**
	 * Permet de récupérer le nom de la photo
	 * @return Le nom de la photo
	 */
	public String getNomPhoto(){
		return this.nomPhoto;
	}

	/**
	 * Permet d'ajouter un exercice réalisé à l'élève
	 * @param ex L'exercice à ajouter
	 */
	public void addExerciceRealise(ExerciceRealise ex){ 
		if(!this.exerciceRealise.contains(ex))
			this.exerciceRealise.add(ex);		
	}
	
	/**
	 * Fonction permettant de récupérer la liste des exercices réalisé par l'élève
	 * @return la liste des exercices réalisé par l'élève
	 */
	public ArrayList<ExerciceRealise> getExerciceRealise()
	{
		return this.exerciceRealise;
	}
	
	/**
	 * Permet de récupérer le chemin absolu vers la photo
	 * @return Le chemin absolu vers la photo
	 */
	public URL getPhoto(){
		return this.photo;
	}
	
	/**
	 * Permet de récupérer la classe de l’élève.
	 * @return La classe de l'élève
	 */
	public Classes getClasse(){
		return this.classe;
	}
	
	/**
	 * Fonction permettant de modifier la classe de l'élève
	 * @param c La nouvelle classe de l'élève
	 */
	public void setClasse(Classes c){
		classe = c;
	}
}
