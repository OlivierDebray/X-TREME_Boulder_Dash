package model;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Théo on 19/06/2017.
 */
public class DimensionTest {
    private Dimension dimension;
    @Before
    public void setUp() throws Exception {
        this.dimension = new Dimension(10, 20);
    }

    @Test
    public void getWidth() throws Exception {
        int ExpectedWidth = 10;
        assertEquals(ExpectedWidth, dimension.getWidth());
    }

    @Test
    public void setWidth() throws Exception {
        int ExpectedWidth = 10;
        dimension.setWidth(10);
        int width = dimension.getWidth();
        Assert.assertEquals(ExpectedWidth, width);
    }

    @Test
    public void getHeight() throws Exception {
        int ExpectedHeight = 20;
        assertEquals(ExpectedHeight, dimension.getHeight());
    }

    @Test
    public void setHeight() throws Exception {
        int ExpectedHeight = 20;
        dimension.setHeight(20);
        int height = dimension.getHeight();
        Assert.assertEquals(ExpectedHeight, height);
    }

}