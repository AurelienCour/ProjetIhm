package testUnitaire;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Exercice;

public class ExerciceTest {

	private Exercice exercice;
	
	/**
	 * Partie qui s'execute avant chaque test
	 * Ici permet donc de r�initialiser l'objet exercice avant chaque test
	 * Il faut cr�er un objet correct ici
	 */
    @Before
    public void setUp(){
    	exercice = new Exercice("nomExercice", "leType", "leModele");
    }

    /**
     * Chose qui s'execute après les test (pas utile dans notre cas)
     */
    @After
    public void tearDown(){
    }
    
    /**
     * Permet de test la modif du nom
     */
	@Test
	public void testSetNomExercice() {
		exercice.setNomEx("nom2");
		assertEquals("nom2",exercice.getNomEx());
	}
	
	/**
	 * Permet de test la modif du type
	 */
	@Test
	public void testSetTypeExercice() {
		exercice.setTypeEx("type2");
		assertEquals("type2",exercice.getTypeEx());
	}
}
