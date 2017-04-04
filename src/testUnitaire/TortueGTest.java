package testUnitaire;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.tortue.Canvas;
import edu.ihm.tortue.TortueG;

/**
 * The test class TortueGTest.
 *
 * @author  Pattrick Girard
 * @version f�vrier 2013
 */
public class TortueGTest
{
    private TortueG tortue1;
    
    /**
     * Default constructor for test class TortueGTest
     */
    public TortueGTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Clears the canvaas, and instantiate a new turtle
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
 		Canvas.getCanvas().clear();
// 		Canvas.getCanvas().setVisible(true);
        tortue1 = new TortueG();
    }

    /**
     * Tears down the test fixture.
     * do nothing !
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Method testTestTourner : turns the turtle once. The direction must now be 0 (East)
     *
     */
    @Test
    public void testTestTourner()
	{
		tortue1.tourner();
		assertEquals(0, tortue1.getDirection());
	}

    /**
     * Method testIntegration : advances twice, truns once. 
     * Must be in (0, -2), direction 0.
     *
     */
    @Test
	public void testIntegration()
	{
		tortue1.avancer();
		tortue1.avancer();
		tortue1.tourner();
		assertEquals(0, tortue1.getX());
		assertEquals(-2, tortue1.getY());
		assertEquals(0, tortue1.getDirection());
	}
        
    /**
     * Method testAvancer : after one move, the turtle must be in (0, -1), direction 3
     *
     */
    @Test
    public void testAvancer()
    {
        tortue1.avancer();
		assertEquals(0, tortue1.getX());
		assertEquals(-1, tortue1.getY());
		assertEquals(3, tortue1.getDirection());
    }

    /**
     * Method testAvancerTourner : advances once, and turns twice
     * Must be in (0, -1), direction 1
     *
     */
    @Test
    public void testAvancerTourner()
    {
        tortue1.avancer();
        tortue1.tourner();
        tortue1.tourner();
        assertEquals(1, tortue1.getDirection());
        assertEquals(0, tortue1.getX());
        assertEquals(-1, tortue1.getY());
    }

    /**
     * Method testTourner : verify all turns, successively 3, 0, 1, 2, 3
     *
     */
    @Test
    public void testTourner()
    {
        assertEquals(3, tortue1.getDirection());
        tortue1.tourner();
        assertEquals(0, tortue1.getDirection());
        tortue1.tourner();
        assertEquals(1, tortue1.getDirection());
        tortue1.tourner();
        assertEquals(2, tortue1.getDirection());
        tortue1.tourner();
        assertEquals(3, tortue1.getDirection());
    }

    /**
     * Method testSquare : print a square in (0,0),(1,-1)
     * Verifies all successive positions (0,-1), (1,-1), (1,0), (0,0)
     *
     */
    @Test
    public void testSquare()
    {
        tortue1.avancer();
        assertEquals(0, tortue1.getX());
        assertEquals(-1, tortue1.getY());
        assertEquals(3, tortue1.getDirection());
        tortue1.tourner();
        tortue1.avancer();
        assertEquals(1, tortue1.getX());
        assertEquals(-1, tortue1.getY());
        tortue1.tourner();
        tortue1.avancer();
        assertEquals(1, tortue1.getX());
        assertEquals(0, tortue1.getY());
        tortue1.tourner();
        tortue1.avancer();
        assertEquals(0, tortue1.getX());
        assertEquals(0, tortue1.getY());
        assertEquals(2, tortue1.getDirection());
    }
}




