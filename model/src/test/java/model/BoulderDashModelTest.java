package model;

import contract.IMobile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 24/06/2017
 */

public class BoulderDashModelTest {
    BoulderDashModel boulderDashModel ;
    Position position ;
    Dimension dimension ;

    @Before
    public void setUp() throws Exception {
        this.position = new Position(1 , 1) ;
        this.dimension = new Dimension(16 , 16) ;
        this.boulderDashModel = new BoulderDashModel(1 , 1 ,1) ;
    }

    /**
     * Test if getMobiles() method return the correct ArrayList
     * @throws Exception
     */
    @Test
    public void getMobiles() throws Exception {
        this.boulderDashModel.addMobile(new Mobile(Direction.RIGHT, position , dimension, "none" , 1 , 1));
        int expectedSize = 1 ;
        Assert.assertEquals(expectedSize , this.boulderDashModel.getMobiles().size()) ;
    }

    /**
     * Test if the getMotionLess() method return the correct ArrayList
     * @throws Exception
     */
    @Test
    public void getMotionless() throws Exception {
        this.boulderDashModel.addMotionless(new Motionless(position , dimension, "none" , 1 , "none" , 1));
        int expectedSize = 1 ;
        Assert.assertEquals(expectedSize , this.boulderDashModel.getMotionless().size()) ;
    }

    /**
     * Test if BoulderDashModel throw an exception when adding a random mobile as the player
     * @throws Exception
     */
    @Test
    public void addPlayer() throws Exception {
        String expectedException = "Parameter should be an Hero object !" ;
        try {
            this.boulderDashModel.addPlayer(new Motionless(position , dimension, "none" , 1 , "none" , 1));
        } catch (Exception e) {
            Assert.assertEquals(expectedException , e.getMessage());
        }
    }
}