package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 19/06/2017.
 */

/**
 * Test class to test the behavior of the Position class
 * @see Position
 */
public class PositionTest {
    private Position position;

    @Before
    public void setUp() {
        this.position = new Position(1,2);
    }

    /**
     * Test setting the correct value with the setX method
     * @throws Exception
     */
    @Test
    public void setX() throws Exception {
        int ExpectedX = 1;
        position.setX(1);
        int x =  position.getX();
        Assert.assertEquals(ExpectedX, x);
    }

    /**
     * Test getting the correct value with the getX method
     * @throws Exception
     */
    @Test
    public void getX(){
        final int ExpectedX = 1;
        assertEquals(ExpectedX, position.getX());
    }

    /**
     * Test setting the correct value with the setY method
     * @throws Exception
     */
    @Test
    public void setY() throws Exception {
        int ExpectedY = 2;
        position.setY(2);
        int y = position.getY();
        Assert.assertEquals(ExpectedY, y);
    }

    /**
     * Test getting the correct value with the getY method
     * @throws Exception
     */
    @Test
    public void getY() {
        final int Expected = 2;
        assertEquals(Expected, this.position.getY());
    }

    @Test
    /**
     * Test setting the correct value with the setXMax method
     * @throws Exception
     */
    public void setXmax() {
        int ExpectedXmax = 3;
        position.setXmax(3);
        final int xMax = 3;
        Assert.assertEquals(ExpectedXmax, xMax);
    }

    /**
     * Test setting the correct value with the setYMax method
     * @throws Exception
     */
    @Test
    public void setYmax(){
        int ExpectedYmax = 6;
        position.setYmax(6);
        final int yMax = 6;
        Assert.assertEquals(ExpectedYmax, yMax);
    }

    /**
     * Test if out range values could be set without any exception thrown
     * @throws Exception
     */
    @Test
    public void outRangeSetXAndY () {
        try {
            this.position.setX(26*16);
            this.position.setY(-1) ;
        } catch (Exception e) {
            String expectedException = "Position should not be out of map !" ;
            Assert.assertEquals(expectedException , e.getMessage());
        }
    }
}