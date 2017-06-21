package model;

import contract.IBoulderDashModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Théo on 19/06/2017.
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
        position = new Position(1 , 2) ;
        dimension = new Dimension(10, 20);
        mobile = new Mobile(Direction.RIGHT, position , dimension, "Image.png");
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

    @Test
    public void buildAllImages() throws Exception {
    }


    @Test
    public void getDirection() throws Exception {
        final Direction ExpectedDirection = Direction.RIGHT;
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
    }

    @Test
    public void getPositionY() throws Exception {
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
    }

    @Test
    public void getHeight() throws Exception {
    }


    @Test
    public void getImage() throws Exception {
        String ExpectedImg = "Image.png";
        assertEquals(ExpectedImg, mobile.getImage());
    }

    @Test
    public void move() throws Exception {
    }

    @Test
    public void placeInArea() throws Exception {
    }

    @Test
    public void hit() throws Exception {
        Assert.assertFalse(mobile.hit());
    }

}