package testUnitaire;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.tortue.TortueG;

public class TentativeTest {

	private Tentative tentative;
	private Action act;
		
	
	@Before
	public void setUp(){
		tentative = new Tentative();
		act = new Action(new TortueG(), "toto");
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testAddActionInexistante(){
		assertEquals(true,tentative.addAction(act));
		assertEquals(true,tentative.getListeAction().contains(act));
	}
	
	@Test
	public void testAddActionExistante(){
		tentative.addAction(act);
		assertEquals(false,tentative.addAction(act));
		assertEquals(true,tentative.getListeAction().contains(act));
	}
	    
	@Test
	public void testRemoveActionGood(){
		tentative.addAction(act);
		assertEquals(true,tentative.removeAction(act));
		assertEquals(false,tentative.getListeAction().contains(act));
	}
	
	@Test
	public void testRemoveActionBad(){
		assertEquals(false,tentative.getListeAction().contains(act));
		assertEquals(false,tentative.removeAction(act));
	}
	
}
