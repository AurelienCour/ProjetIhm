package edu.ihm.creation_exercice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import edu.ihm.Main.Database;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.FiltreSimple;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * Classe permetant de controler les intéractions avec le panel CreationExercice
 * @author Aurelien
 *
 */
public class ControlerCreationExercice implements ActionListener {
	
	private PanelCreationExercice pane; // Le panel correspondant
	private Professeur prof; // Le professeur créant l'exercice
	private Exercice exo; // L'exercice à modifier
	
	/**
	 * Constructeur de la classe pour permettre la création d'un exercice
	 * @param pane Le panel de création
	 * @param prof Le professeur créant l'exercice
	 */
	public ControlerCreationExercice(PanelCreationExercice pane, Utilisateur prof) {
		this.pane = pane;
		this.prof = (Professeur) prof;
	}
	
	/**
	 * Constructeur de la classe pour permettre la modification d'un exercice
	 * @param panelCreationExercice Le panel comportant les champs
	 * @param user Le professeur modifiant l'exercice
	 * @param exo L'exercice modifié
	 */
	public ControlerCreationExercice(PanelCreationExercice panelCreationExercice, Utilisateur user, Exercice exo) {
		this.pane = panelCreationExercice;
		this.prof = (Professeur) prof;
		this.exo = exo;
	}

	/**
	 * Constructeur de la classe pour permettre la recherche d'une image
	 * @param panelCreationExercice Le panel comportant les champs
	 */
	public ControlerCreationExercice(PanelCreationExercice panelCreationExercice) {
		this.pane = panelCreationExercice;
	}

	/**
	 * Fonction permettant la gestion des différents event
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(exo == null && prof == null){
			// Permet de chercher un fichier à partir du Bureau
            FileSystemView vueSysteme = FileSystemView.getFileSystemView(); 
            File home = vueSysteme.getHomeDirectory();
            JFileChooser homeChooser = new JFileChooser(home);

            // Permet de filtrer les choix possibles de fichiers (que les images)
            FileFilter png = new FiltreSimple("Fichiers PNG",".png"); 
            FileFilter jpeg = new FiltreSimple("Fichiers JPEG",".jpeg"); 
            FileFilter jpg = new FiltreSimple("Fichiers JPG",".jpg");   
            FileFilter gif = new FiltreSimple("Fichiers GIF",".gif");
            FileFilter tiff = new FiltreSimple("Fichiers TIFF",".tiff");
            FileFilter tif = new FiltreSimple("Fichiers TIF",".tif");
            homeChooser.setAcceptAllFileFilterUsed(false);
            homeChooser.addChoosableFileFilter(png); 
            homeChooser.addChoosableFileFilter(jpeg); 
            homeChooser.addChoosableFileFilter(jpg);
            homeChooser.addChoosableFileFilter(gif);
            homeChooser.addChoosableFileFilter(tiff);
            homeChooser.addChoosableFileFilter(tif);

            // On récupère l'image
            int retour=homeChooser.showOpenDialog(null);
            if (retour == JFileChooser.APPROVE_OPTION)
            {         
                File monFichier = homeChooser.getSelectedFile();
                if(monFichier.exists()){
                	boolean resultat = false;
                	URL path = Database.class.getResource("/Donnees_ProjetIhm_Aurelien/");
                	// Declaration des flux
                	java.io.FileInputStream sourceFile=null;
                	java.io.FileOutputStream destinationFile=null;
                	try {
                		File destination = new File(path.getPath()+monFichier.getName());
                		// Création du fichier :
                		destination.createNewFile();
                		// Ouverture des flux
                		sourceFile = new java.io.FileInputStream(monFichier);
                		destinationFile = new java.io.FileOutputStream(destination);
                		// Lecture par segment de 0.5Mo
                		byte buffer[]=new byte[512*1024];
                		int nbLecture;
                		while( (nbLecture = sourceFile.read(buffer)) != -1 ) {
                			destinationFile.write(buffer, 0, nbLecture);
                		}
                		pane.setTextModel(destination.getName());
                	} catch( java.io.FileNotFoundException f ) {
                	} catch( java.io.IOException e ) {
                	} finally {
                		// Quoi qu'il arrive, on ferme les flux
                		try {
                			sourceFile.close();
                		} catch(Exception e) { }
                		try {
                			destinationFile.close();
                		} catch(Exception e) { }
                	}
                }
                
             }
		}
		else if(exo != null){
			exo.setNomEx(pane.getFieldNom());
			exo.setTypeEx(pane.getCheckBoxSelected());
			exo.setNomImage(pane.getFieldModele());
			pane.afterCreate(exo);
		}
		else{
			Exercice exercice = new Exercice(pane.getFieldNom(), pane.getCheckBoxSelected(), pane.getFieldModele());
			for (Classes cla : prof.getClasses()) {
				cla.addExercice(exercice);
			}
			pane.afterCreate(exercice);
		}
	}
}
