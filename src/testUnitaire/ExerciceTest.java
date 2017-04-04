package testUnitaire;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Exercice;

public class ExerciceTest {

	private Exercice exercice;
	/**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp(){
    	exercice = new Exercice("nomExercice", "leType", "leModele");
    }

    @After
    public void tearDown(){
    }
    
	@Test
	public void testSetNomExercice() {
		exercice.setNomEx("nom2");
		assertEquals("nom2",exercice.getNomEx());
	}
	
	@Test
	public void testSetTypeExercice() {
		exercice.setTypeEx("type2");
		assertEquals("type2",exercice.getTypeEx());
	}
	
	@Test
	public void testSetModele(){
		exercice.setModele("testModel");
		assertEquals(Exercice.class.getResource("testModel"),exercice.getModele());
	}
}
