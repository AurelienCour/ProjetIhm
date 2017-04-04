package testUnitaire;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.tortue.Canvas;
import edu.ihm.tortue.TortueRapide;

/**
 * The test class TortueRapideTest.
 *
 * @author  Pattrick Girard
 * @version f�vrier 2013
 */
public class TortueRapideTest
{
    private TortueRapide tortueRa1;

    /**
     * Default constructor for test class TortueRapideTest
     */
    public TortueRapideTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Clears the canvas, and instantiate a turtle
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Canvas.getCanvas().clear();
 		Canvas.getCanvas().setVisible(true);
        tortueRa1 = new TortueRapide();
    }

    /**
     * Tears down the test fixture.
     * do nothing
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Method testSpeed: successively :
     * advance 1
     * speed++
     * speed++
     * advance 3
     * turn
     * advance 3
     * turn
     * advance 5
     * speed--
     * speed--
     * advance 3
     * turtle in (3,4), direction 1, speed 3
     *
     */
    @Test
    public void testSpeed()
    {
        tortueRa1.avancer();
        tortueRa1.accelerer();
        tortueRa1.accelerer();
        assertEquals(3, tortueRa1.getVitesse());
        tortueRa1.avancer();
        assertEquals(-4, tortueRa1.getY());
        assertEquals(0, tortueRa1.getX());
        tortueRa1.tourner();
        tortueRa1.avancer();
        tortueRa1.tourner();
        tortueRa1.setVitesse(5);
        tortueRa1.avancer();
        assertEquals(3, tortueRa1.getX());
        assertEquals(5, tortueRa1.getVitesse());
        assertEquals(1, tortueRa1.getY());
        tortueRa1.ralentir();
        tortueRa1.ralentir();
        tortueRa1.avancer();
        assertEquals(3, tortueRa1.getVitesse());
        assertEquals(3, tortueRa1.getX());
        assertEquals(4, tortueRa1.getY());
        assertEquals(1, tortueRa1.getDirection());
    }
}

