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

/**
 * Test class to test the behavior of the BoulderDashController class
 * @see BoulderDashController
 */
public class BoulderDashControllerTest {
    private IBoulderDashModel boulderDashModel ;
    private BoulderDashController boulderDashController ;

    @Before
    public void setUp() throws Exception {
        this.boulderDashController = new BoulderDashController(boulderDashModel) ;
    }

    /**
     * Test if the setter and the getter use and return the correct value
     * @throws Exception
     */
    @Test
    public void setAndGetViewSystem() throws Exception {
        IViewSystem viewSystem = null ;
        boulderDashController.setViewSystem(viewSystem);
        Assert.assertEquals(viewSystem , boulderDashController.getViewSystem());
    }
}
