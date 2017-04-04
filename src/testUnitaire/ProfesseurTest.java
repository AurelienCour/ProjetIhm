package testUnitaire;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Professeur;

public class ProfesseurTest {

	private Professeur Prof;
	private Classes Classe;
	
	@Before
    public void setUp(){
    	Prof = new Professeur("leId", "leMotDePasse", "leNom", "lePrenom");
    	Classe = new Classes("leNomClasse");
    }
	
	@After
    public void tearDown(){
    }
	
	@Test
	public void testAddClasse() {
		Prof.addClasses(Classe);
		assertEquals(Classe,Prof.getClasses().get(0));
	}
	
	@Test
	public void testIsEmpty() {
		assertEquals(true, Prof.isEmpty());
	}
	
	@Test
	public void testRemoveClass() {
		Prof.addClasses(Classe);
		Prof.removeClasses(Classe);
		assertEquals(true,Prof.isEmpty());
	}
	

}
