package edu.ihm.noyau_fonctionnel;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import edu.ihm.Main.Database;

/**
 * Classe représentant un Exerice
 * @author Aurelien
 *
 */
public class Exercice {
	
	private String nomExercice;  // Nom de l’exercice que les élèves doivent réaliser.
	private String typeExercice; // Le type d'exercice (basique, couleur, rapide)
	private URL modele; // Le chemin absolu vers le modèle de l'exercice
	private String nomImage; // Le nom de l'image
	
	/**
	 * Le constructeur de la classe
	 * @param nomExercice Le nom de l'exercice
	 * @param typeExercice Le type d'exercice
	 * @param nomImage Le nom de l'image
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
	
	/**
	 * Permet de récupérer le nom de l'image
	 * @return Le nom de l'image
	 */
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
	 * @param nomEx Nouveau nom de l'exercice
	 */
	public void setNomEx(String nomEx){
		this.nomExercice = nomEx;
	}
	
	/**
	 * Permet de modifier le nom de l’image
	 * @param nomImage Nouveau nom de l'exercice
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
	 * Permet de modifier le type de l’exercice
	 * @param typeEx Type de la tortue (Rapide, couleur, Basique)
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
	 * @param newUrl URL du nouveau modele de l'exercice
	 */
	public void setModele(URL newUrl){
		this.modele = Exercice.class.getResource(newUrl.toString());
	}
	
}
