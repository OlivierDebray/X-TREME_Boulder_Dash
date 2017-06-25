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
 * Test class to test the behavior of the Dimension class
 * @see Dimension
 */
public class DimensionTest {
    private Dimension dimension;

    @Before
    public void setUp() throws Exception {
        this.dimension = new Dimension(10, 20);
    }

    /**
     * Test getting the correct value from the getWidth method
     * @throws Exception
     */
    @Test
    public void getWidth() throws Exception {
        int ExpectedWidth = 10;
        assertEquals(ExpectedWidth, dimension.getWidth());
    }

    /**
     * Test setting the correct value with te setWidth method
     * @throws Exception
     */
    @Test
    public void setWidth() throws Exception {
        int ExpectedWidth = 10;
        dimension.setWidth(10);
        int width = dimension.getWidth();
        Assert.assertEquals(ExpectedWidth, width);
    }

    /**
     * Test getting the correct value from the getHeight method
     * @throws Exception
     */
    @Test
    public void getHeight() throws Exception {
        int ExpectedHeight = 20;
        assertEquals(ExpectedHeight, dimension.getHeight());
    }

    /**
     * Test setting the correct value with te setHeight method
     * @throws Exception
     */
    @Test
    public void setHeight() throws Exception {
        int ExpectedHeight = 20;
        dimension.setHeight(20);
        int height = dimension.getHeight();
        Assert.assertEquals(ExpectedHeight, height);
    }

    /**
     * Test if not allowed dimension could be set without exception thrown
     * @throws Exception
     */
    @Test
    public void outRangeSetWidthAndHeight () throws Exception {
        try {
            this.dimension.setHeight(-1);
            this.dimension.setWidth(-2);
        } catch (Exception e) {
            String expectedException = "Dimension value should not be negative !" ;
            Assert.assertEquals(expectedException , e.getMessage());
        }
    }
}