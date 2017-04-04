package testUnitaire;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.noyau_fonctionnel.Professeur;

public class UtilisateurTest {
	
	private Professeur Prof;
	
    @Before
    public void setUp(){
    	Prof = new Professeur("leId", "leMotDePasse", "leNom", "lePrenom");
    }
    
    @After
    public void tearDown(){
    }
    
    @Test
	public void testGetIdentitifant() {
		assertEquals("leId",Prof.getIdentifiant());
	}
    
    @Test
	public void testGetMotDePasse() {
		assertEquals("leMotDePasse",Prof.getMotDePasse());
	}

    @Test
	public void testGetNom() {
		assertEquals("leNom",Prof.getNom());
	}
    
    @Test
	public void testGetPrenom() {
		assertEquals("lePrenom",Prof.getPrenom());
	}
	
    @Test
	public void testSetMotDePasse() {
    	Prof.setMotDePasse("motDePasse");
		assertEquals("motDePasse",Prof.getMotDePasse());
	}
}
