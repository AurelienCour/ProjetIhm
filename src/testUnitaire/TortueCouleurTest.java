package testUnitaire;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.tortue.Canvas;
import edu.ihm.tortue.TortueCouleur;

/**
 * The test class TortueCouleurTest.
 *
 * @author  Pattrick Girard
 * @version f�vrier 2013
 */
public class TortueCouleurTest
{
    private TortueCouleur tortueCo1;

    /**
     * Default constructor for test class TortueCouleurTest
     */
    public TortueCouleurTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
 		Canvas.getCanvas().clear();        
 		Canvas.getCanvas().setVisible(true);
        tortueCo1 = new TortueCouleur();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Method testColors: the turtle write north, in red
     *
     */
    @Test
    public void testColors()
    {
        assertEquals("black", tortueCo1.getCouleur());
        tortueCo1.setCouleur("red");
        assertEquals("red", tortueCo1.getCouleur());
        tortueCo1.tourner();
        tortueCo1.avancer();
        assertEquals("red", tortueCo1.getCouleur());
        assertEquals(1, tortueCo1.getX());
        assertEquals(0, tortueCo1.getY());
    }

    /**
     * Method testGreenBlueMagenta: the turtle can be green, blue, magenta
     *
     */
    @Test
    public void testGreenBlueMagenta()
    {
        tortueCo1.setCouleur("green");
        assertEquals("green", tortueCo1.getCouleur());
        tortueCo1.setCouleur("blue");
        assertEquals("blue", tortueCo1.getCouleur());
        tortueCo1.setCouleur("magenta");
        assertEquals("magenta", tortueCo1.getCouleur());
    }

    /**
     * Method testBrown: the turtle cannot write in brown, stays in black
     *
     */
    @Test
    public void testBrown()
    {
        tortueCo1.setCouleur("brown");
        assertEquals("black", tortueCo1.getCouleur());
    }

    /**
     * Method testColoredSquare: the turtle wirites a square in red/green/blue/yellow, adds a black line
     * and goes one step further, facing north
     *
     */
    @Test
    public void testColoredSquare()
    {
        tortueCo1.setCouleur("red");
        tortueCo1.avancer();
        tortueCo1.setCouleur("green");
        tortueCo1.tourner();
        tortueCo1.avancer();
        tortueCo1.setCouleur("blue");
        tortueCo1.tourner();
        tortueCo1.avancer();
        tortueCo1.setCouleur("yellow");
        tortueCo1.tourner();
        tortueCo1.avancer();
        tortueCo1.setCouleur("orange");
        tortueCo1.avancer();
        tortueCo1.tracer(false);
        tortueCo1.avancer();
        tortueCo1.avancer();
        tortueCo1.tourner();
        assertEquals(-3, tortueCo1.getX());
        assertEquals(0, tortueCo1.getY());
        assertEquals(3, tortueCo1.getDirection());
    }
}




