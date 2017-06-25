package model;

import contract.IBoulderDashModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 19/06/2017.
 */
public class MobileTest {
    Mobile mobile;
    Position position;
    Dimension dimension;
    Direction direction;
    String image;
    IBoulderDashModel boulderDashModel;

    @Before
    public void setUp(){
        this.position = new Position(1 , 2) ;
        this.dimension = new Dimension(10, 10);
        this.mobile = new Mobile(Direction.RIGHT, position , dimension, "none" , 1 , 1);
    }

    @Test
    public void moveUp() throws Exception {
        int expectedY = 2;
        this.position.setY(this.position.getY());
        int y = position.getY();
        assertEquals(expectedY, y);
    }

    @Test
    public void moveDown() throws Exception {
        int expectedY = 2;
        this.position.setY(this.position.getY());
        int y = position.getY();
        assertEquals(expectedY, y);
    }

    @Test
    public void moveRight() throws Exception {
        int expectedX = 1;
        this.position.setX(this.position.getX());
        int x = position.getX();
        assertEquals(expectedX, x);
    }

    @Test
    public void moveLeft() throws Exception {
        int expectedX = 1;
        this.position.setX(this.position.getX());
        int x = position.getX();
        assertEquals(expectedX, x);
    }

    @Test
    public void setBoulderDashModel() throws Exception {
        IBoulderDashModel expectedBoulderModel = boulderDashModel;
        mobile.setBoulderDashModel(boulderDashModel);
        IBoulderDashModel boulderModel = mobile.getBoulderDashModel();
        assertEquals(expectedBoulderModel,boulderModel);
    }


    @Test
    public void getBoulderDashModel() throws Exception {
        IBoulderDashModel expectedBoulderModel = boulderDashModel;
        assertEquals(expectedBoulderModel, mobile.getBoulderDashModel());
    }

    /**
     * Test if buildAllImages throw an exception when the method can't read the file
     * @throws Exception
     */
    @Test
    public void buildAllImages() throws Exception {
        String expectedException = "Can't read input file!" ;
        try {
            this.mobile.buildAllImages("none" , 200);
        } catch (IIOException e) {
            Assert.assertEquals(expectedException , e.getMessage());
        }
    }


    @Test
    public void getDirection() throws Exception {
        final String ExpectedDirection = Direction.RIGHT.toString();
        assertEquals(ExpectedDirection, mobile.getDirection());
    }

    @Test
    public void setDirection() throws Exception {
        String ExpectedDirection = "RIGHT";
        mobile.setDirection("RIGHT");
        String gdirection = mobile.getDirection();
        Assert.assertEquals(ExpectedDirection, gdirection);
    }

    @Test
    public void getPositionX() throws Exception {
        int expectedX = 1;
        assertEquals(expectedX, this.position.getX());
    }

    @Test
    public void getPositionY() throws Exception {
        int expectedY = 2;
        assertEquals(expectedY, this.position.getY());
    }

    @Test
    public void getPositionXMax() throws Exception {
    }

    @Test
    public void getPositionYMax() throws Exception {
    }

    @Test
    public void getDimensionWidth() throws Exception {
    }

    @Test
    public void getDimensionHeight() throws Exception {
    }

    @Test
    public void getWidth() throws Exception {
        int expectedWidth = 10;
        assertEquals(expectedWidth, this.dimension.getWidth());
    }

    @Test
    public void getHeight() throws Exception {
        int expectedHeight = 10;
        assertEquals(expectedHeight, this.dimension.getHeight());
    }


    @Test
    public void getImage() throws Exception {
    }

    @Test
    public void move() throws Exception {
    }

    @Test
    public void placeInArea() throws Exception {
    }

    @Test
    public void hit() throws Exception {
    }

}