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

public class UserOrderTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getOrder() throws Exception {
        UserOrder userOrder = new UserOrder(Order.UP) ;
        String expected = "UP" ;
        String result = userOrder.getOrder() ;
        Assert.assertEquals(expected , result);
    }
}