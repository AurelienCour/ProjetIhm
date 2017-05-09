package edu.ihm.noyau_fonctionnel;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Classe FiltreSimple est utilisée dans la gestion de recherche d'une image sur l'ordinateur
 * Le filtre est composée d'une description et d'une extension
 * 
 * @author Groupe_2
 */
public class FiltreSimple extends FileFilter{ 
   //Description et extension acceptées par le filtre 
   private String description; 
   private String extension; 
   
   /**
    * Constructeur à partir de la description et de l'extension acceptées 
    * @param description : choix de la description pour ce filtre (string)
    * @param extension : choix de l'extension pour ce filtre (string)
    */
   public FiltreSimple(String description, String extension){ 
      if(description == null || extension ==null){ 
         throw new NullPointerException("La description (ou extension) ne peut être null."); 
      } 
      this.description = description; 
      this.extension = extension; 
   } 
   
   /**
    * Implémentation de FileFilter 
    * Réécriture de la méthode accept
    * Permet de renvoyer le nom du fichier avec l'extension à la fin
    * Vérifie si le fichier est présent dans le répertoire indiqué
    * 
    * @param file : fichier choisi de type File
    * @return nomFichier.endsWith(extension)
    */
    @Override
    public boolean accept(File file){ 
      if(file.isDirectory()) {  
         return true;  
      }  
      String nomFichier = file.getName().toLowerCase();  
  
      return nomFichier.endsWith(extension); 
    } 
   
    /**
     * Réécriture de la méthode getDescription
     * Permet de renvoyer la description du filtre
     * @return description : de type String
     */
      public String getDescription(){ 
    	return description; 
   } 
}