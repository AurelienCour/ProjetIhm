package testUnitaire;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ihm.noyau_fonctionnel.*;

/**
 * 
 * @author Math
 * @version 03/04/2017
 */

public class ExerciceRealiseTest {

	private boolean correct;	// Booleen permettant de savoir si l'exercice à été corrigé
	private Evaluation resultat;	// L'évaluation de l'exercice si elle a été corrigé
	private Exercice exerciceFait;//TODO instancier	// L'exercice qui a été effectué
	
	
	ExerciceRealise ER = new ExerciceRealise(exerciceFait);
	
	public void TestExerciceRealise() {
		
		assertEquals("oui",exerciceFait,ER);
	}
	
	public void TestsetCorrect() {
		
		ER.setCorrect(true);
		assertTrue("Erreur set",ER.isCorrect());
	}
	
	public void TestisCorrect() {
		
		ER.setCorrect(true);
		assertTrue("Erreur get",ER.isCorrect());
	}
	
	
}
