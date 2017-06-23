package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Théo on 19/06/2017.
 */
public class PositionTest {

    private Position position;


    @Before
    public void setUp() {
        this.position = new Position(1,2);
    }


    @Test
    public void setX()  {
        int ExpectedX = 1;
        position.setX(1);
        int x =  position.getX();
        Assert.assertEquals(ExpectedX, x);
    }

    @Test
    public void getX(){
        final int ExpectedX = 1;
        assertEquals(ExpectedX, position.getX());
    }

    @Test
    public void setY(){
        int ExpectedY = 2;
        position.setY(2);
        int y = position.getY();
        Assert.assertEquals(ExpectedY, y);
    }

    @Test
    public void getY() {
        final int Expected = 2;
        assertEquals(Expected, this.position.getY());
    }

    @Test
    public void setXmax() {
        int ExpectedXmax = 3;
        position.setXmax(3);
        final int xMax = 3;
        Assert.assertEquals(ExpectedXmax, xMax);
    }

    @Test
    public void setYmax(){
        int ExpectedYmax = 6;
        position.setYmax(6);
        final int yMax = 6;
        Assert.assertEquals(ExpectedYmax, yMax);
    }

}