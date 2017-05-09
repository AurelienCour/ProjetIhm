package edu.ihm.noyau_fonctionnel;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import edu.ihm.Main.Database;

/**
 * Cette classe représente les exercices que doivent effectuer les élèves.
 * Les exercices sont regroupés par noms et types. Ils sont listés dans la classe Classe.
 * @author Erwan MAZUREAU
 * @version 03/04/2017
 */
public class Exercice {
	
	/**
	 * Nom de l’exercice que les élèves doivent réaliser.
	 */
	private String nomExercice;  
	
	/**
	 * cela représente le type de l’exercice. Le type est de trois types différents : une tortue générale, une tortue rapide et une rapide traçant en plusieurs couleurs.
	 */
	private String typeExercice;
	
	/**
	 * le modèle est une image. Cette image représente l’exercice que doit réaliser les enfants.
	 */
	private URL modele;
	
	/**
	 * le modèle est une image. Cette image représente l’exercice que doit réaliser les enfants.
	 */
	private String nomImage;
	
	/**
	 * Constructeur de la classe Exercice
	 * prend en paramètres 2 attributs de type String,
	 * si null alors on initialise avec les valeurs "Exercice 0" pour nomExercice
	 * et "Tortue normale" pour typeExercice,
	 * et un attributs de type URL, possiblement null.
	 * @param nomExercice : le nom de l'Exercice
	 * @param TypeExercice : le type d'exercice
	 * @param modele : le modele de l'exercice
	 */
	public Exercice(String nomExercice, String typeExercice, String nomImage){
		this.nomImage = nomImage;
		this.nomExercice = nomExercice;
		this.typeExercice = typeExercice;
		try{
			this.modele = Exercice.class.getResource("Image/"+nomImage);
			ImageIcon ic = new ImageIcon(new ImageIcon(this.modele).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		}
		catch(NullPointerException e){
			try{
				this.modele = Database.class.getResource("/Donnees_ProjetIhm_Aurelien/"+nomImage);
				ImageIcon ic = new ImageIcon(new ImageIcon(this.modele).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			}
			catch(NullPointerException i){
				this.modele = Exercice.class.getResource("Image/no-image-found.gif");
			}
		}
	}
	
	public String getNomImage(){
		return this.nomImage;
	}
	
	/**
	 * Getter du nom
	 * @return Nom de l'exercice
	 */
	public String getNomEx(){
		return this.nomExercice;
	}
	
	/**
	 * Permet de modifier le nom de l’exercice
	 * @param nom Nouveau nom de l'exercice
	 */
	public void setNomEx(String nomEx){
		this.nomExercice = nomEx;
	}
	
	/**
	 * Permet de modifier le nom de l’image
	 * @param nom Nouveau nom de l'exercice
	 */
	public void setNomImage(String nomImage){
		this.nomImage = nomImage;
		try{
			this.modele = Exercice.class.getResource("Image/"+nomImage);
			ImageIcon ic = new ImageIcon(new ImageIcon(this.modele).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		}
		catch(NullPointerException e){
			try{
				this.modele = Database.class.getResource("/Donnees_ProjetIhm_Aurelien/"+nomImage);
				ImageIcon ic = new ImageIcon(new ImageIcon(this.modele).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			}
			catch(NullPointerException i){
				this.modele = Exercice.class.getResource("Image/no-image-found.gif");
			}
		}
		
	}
	
	/**
	 * Renvoie le type d’exercice
	 * @return Le type d'exercice
	 */
	public String getTypeEx(){
		return this.typeExercice;		
	}
	
	/**
	 *  Permet de modifier le type de l’exercice
	 * @param type Type de la tortue (Rapide, couleur,normal)
	 */
	public void setTypeEx(String typeEx){
		this.typeExercice = typeEx;
	}
	/**
	 * Renvoie le modèle de l'exercice.
	 * @return Permet de récupérer le lien d'acces au modèle
	 */
	public URL getModele(){
		return this.modele;
	}
	
	/**
	 * Permet de modifier l’image de l’exercice.
	 * @param modele URL du nouveau modele de l'exercice
	 */
	public void setModele(URL newUrl){
		this.modele = Exercice.class.getResource(newUrl.toString());
	}
	
}
