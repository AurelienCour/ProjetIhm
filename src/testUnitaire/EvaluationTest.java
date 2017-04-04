package testUnitaire;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Evaluation;
import edu.ihm.noyau_fonctionnel.Exercice;

public class EvaluationTest {

	private Evaluation Eval;
	
	@Before
    public void setUp(){
    	Eval = new Evaluation("laNote", "leCommentaire");
    }
	
	@After
    public void tearDown(){
    }
	
	@Test
	public void testSetNote() {
		Eval.setNote("newNote");
		assertEquals("newNote", Eval.getNote());
	}
	
	@Test
	public void testSetCommentaire() {
		Eval.setCommentaire("newCommentaire");
		assertEquals("newCommentaire", Eval.getCommentaire());
	}

}
