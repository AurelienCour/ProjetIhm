package testUnitaire;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;


public class ClassesTest {

	private ArrayList<Exercice> exercices; 
	private ArrayList<Eleve> eleves; 
	private String nomClasse;
	
	private Classes classe;
	private Exercice exercice;
	private Eleve eleve;
	
	
	/**
	 * Partie qui s'execute avant chaque test
	 * Ici permet donc de réinitialiser l'objet classe avant chaque test
	 * Il faut créer un objet correct ici
	 */
	
	@Before
    public void setUp()
	{
    	classe = new Classes("nomClasse");
    	exercice = new Exercice("leNom", "leType", "leModele");
    	//eleve = new Eleve("sonIdentifiant", "sonMotDePasse", "sonNom", "sonPrenom","saClasse", "saPhoto")
    	}
	
    /**
     * S'execute apres les test (pas utile ici)
     */
    @After
    public void tearDown()
    {
    }
	//------------------EXERCICES---------------------------------------------------------
    /**
     * Permet de tester l'ajout d'un exercice
   	 */
	@Test
	public void testAddExercice() 
	{
    	classe.addExercice(exercice);
		assertEquals(exercice,classe.getExercice(0));
	}	

	/**
     * Permet de tester la suppression d'un exercice
     */
	public void testSuppExercice()
	{
		exercices.remove(exercice);
		assertEquals(null,classe.getExercice(0));		
	}
	
	/**
	 * Teste la fonction getExercice et regarde si elle retourne l'exercice
	 */
	public void testGetExercice()
	{
		assertEquals(exercice,exercices.get(0));
	}
	
	//------------------CLASSE---------------------------------------------------------
	/**
	 * Teste la fonction getNomClasse et regarde si elle retourne le nom de la classe
	 */
	public void testGetNomClasse()
	{
		 assertEquals("nomClasse", classe.getNomClasse());
	}
	
	
	//------------------ELEVE--------------------------------------------------------- 
    /**
     * Permet de tester l'ajout d'un eleve
   	 */
	public void testAddEleve(Eleve el)
	{		
    	classe.addEleve(eleve);
		assertEquals(eleve,classe.getEleves().get(0));
	}
	
	/**
     * Permet de tester la suppression d'un eleve
     */
	public void testSuppEleve(Eleve el)
	{
		eleves.remove(eleve);
		assertEquals(null,classe.getEleves().get(0));	
	}

}
