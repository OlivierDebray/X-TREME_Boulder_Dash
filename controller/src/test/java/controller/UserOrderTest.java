package controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

/**
 * Test class to test to test the UserOrder class
 * @see UserOrder
 */
public class UserOrderTest {

    /**
     * Test the instantiation of a new UserOrder and test its returned value
     * @throws Exception
     */
    @Test
    public void constructorAndGetOrder() throws Exception {
        UserOrder userOrder = new UserOrder("UP") ;
        String expected = "UP" ;
        String result = userOrder.getOrder() ;
        Assert.assertEquals(expected , result);
    }
}