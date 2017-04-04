package testUnitaire;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.sun.org.apache.xpath.internal.operations.String;

import edu.ihm.noyau_fonctionnel.*;

/**
 * 
 * @author Math
 * @version 03/04/2017
 */

public class ExerciceRealiseTest {

	private ExerciceRealise exerciceRealise;
	private Exercice exerciceFait;
	private Evaluation resultat;
	private ArrayList<Tentative> listeTentatives;
	private Tentative tentative1;
	
	
	@Before
    public void setUp(){
		exerciceFait = new Exercice("nomExercice", "leType", "leModele");
		resultat = new Evaluation("note","commentaire");
		listeTentatives = new ArrayList<Tentative>();
		exerciceRealise = new ExerciceRealise(exerciceFait);		
		
    }

    @After
    public void tearDown(){
    }
	
	
    @Test
	public void testSetCorrect() {
		exerciceRealise.setCorrect(true);
		assertEquals(true,exerciceRealise.isCorrect());
		
	}
	
    @Test
	public void testIsCorrect() {
    	exerciceRealise.setCorrect(true);
		assertEquals(true,exerciceRealise.isCorrect());
	}
    
    @Test
    public void testCorriger() {
    	exerciceRealise.corriger(resultat);
    	assertEquals(resultat,exerciceRealise.getResultat());
	}
    
    @Test
    public void testAddTentative() {
    	listeTentatives.add(tentative1);
    	assertEquals(tentative1,exerciceRealise.getListeTentatives());
	}

    @Test
    public void testIsEmpty() {
    	assertEquals(null,exerciceRealise.getListeTentatives());
    }
    
}
