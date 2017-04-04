package testUnitaire;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;

public class TentativeTest {

	
	private ArrayList<Action> listeAction;
	private Action action;
	private Tentative tentative;
	
		
	
	@Before
	public void setUp(){
		tentative.addAction(action);
		listeAction = new ArrayList<Action>();
		listeAction.add(action);
		
	}

	@After
	public void tearDown(){
		
	}
	    
	@Test
	public void testRemoveActionEmpty(){
		tentative.removeAction(action);
		assertEquals(false,tentative.removeAction(action));
		
	}
	
	@Test
	public void testRemoveAction(){
		assertEquals(true,tentative.removeAction(action));
		
	}
}
