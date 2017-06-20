package controller;

import contract.IBoulderDashModel;
import contract.IViewSystem;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public class BoulderDashControllerTest {
    private IBoulderDashModel boulderDashModel ;
    private BoulderDashController boulderDashController ;

    @Before
    public void setUp() throws Exception {
        this.boulderDashController = new BoulderDashController(boulderDashModel) ;
    }

    @Test
    public void orderPerform() throws Exception {
        BoulderDashController boulderDashController = new BoulderDashController(boulderDashModel) ;

        try {
            boulderDashController.orderPerform("UP");
            fail("Should throw the direction") ;
        }
        catch (final Exception e) {
            String expected = "UP" ;
            Assert.assertEquals(expected , e.getMessage());
        }
    }

    @Test
    public void play() throws Exception {
    }

    @Test
    public void gameLoop() throws Exception {
    }

    @Test
    public void setAndGetViewSystem() throws Exception {
        IViewSystem viewSystem = null ;
        boulderDashController.setViewSystem(viewSystem);
        Assert.assertEquals(viewSystem , boulderDashController.getViewSystem());
    }

    @Test
    public void manageEnemyCollision() throws Exception {

    }

    @Test
    public void manageObjectCollision() throws Exception {

    }

    @Test
    public void isEntityOnMobile() throws Exception {

    }
}
