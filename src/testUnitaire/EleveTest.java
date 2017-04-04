package testUnitaire;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Evaluation;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

import org.junit.Test;

public class EleveTest {
	
	private Eleve eleve;
	private Classes classe, classe2;
	private ExerciceRealise exerciceRealise;
	private Exercice exercice;
		
	/**
	 * Partie qui s'execute avant chaque test
	 * Ici permet donc de r�initialiser l'objet eleve avant chaque test
	 * Il faut cr�er un objet correct ici
	 */
    @Before
    public void setUp()
    {
    	classe = new Classes("nomClasse");
    	eleve = new Eleve("sonIdentifiant", "sonMotDePasse", "sonNom", "sonPrenom",classe, "saPhoto");
    	exercice = new Exercice("nomExercice", "leType", "leModele");
    	exerciceRealise = new ExerciceRealise(exercice);
    	classe2 = new Classes("nouvelleClasse");
    }
		
    /**
     * S'execute apres les test (pas utile ici)
     */
    @After
    public void tearDown()
    {
    }
	
    /**
     * Permet d'ajouter un exercie r�alis� � un �l�ve
     */
	@Test
	public void testAddExerciceRealise()
	{ 
		eleve.addExerciceRealise(exerciceRealise);
		assertEquals(exerciceRealise,eleve.getExerciceRealise(0));
	}

	/**
	 * 
	 * Teste la modification de la photo de l'eleve
	 */
    @Test
	public void testSetPhoto()
	{
		eleve.setPhoto("photo2");
		assertEquals(Eleve.class.getResource("photo2"),eleve.getPhoto());
	}

    @Test
	public void testSetClasse()
	{
		eleve.setClasse(classe2);
		assertEquals(classe2,eleve.getClasse());
	}
}



