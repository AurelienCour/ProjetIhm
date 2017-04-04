package testUnitaire;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ihm.tortue.Canvas;
import edu.ihm.tortue.CanvasTortue;

/**
 * The test class CanvasTortueTest.
 *
 * @author  Pattrick Girard
 * @version f�vrier 2013
 */
public class CanvasTortueTest
{
    /**
     * Default constructor for test class CanvasTortueTest
     */
    public CanvasTortueTest()
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
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        Canvas.getCanvas().wait(1000);
    }

    /**
     * Method test1North: Turtle facing North
     *
     */
    @Test
    public void test1North()
    {
        CanvasTortue.tortueNord(0, -1);
    }
    
    /**
     * Method test2East: Turtle facing East
     *
     */
    @Test
    public void test2East()
    {
        CanvasTortue.tortueEst(1, 0);
    }

    /**
     * Method test3South: Turtle facing South
     *
     */
    @Test
    public void test3South()
    {
        CanvasTortue.tortueSud(0, 1);
    }

    /**
     * Method test4West: Turtle facing West
     *
     */
    @Test
    public void test4West()
    {
        CanvasTortue.tortueOuest(-1, 0);
    }

}




