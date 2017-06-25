package view;


import contract.IBoulderDashModel;
import contract.IGraphicsBuilder;
import contract.IOrderPerformer;
import oracle.jrockit.jfr.JFR;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Observable;

import static java.awt.event.KeyEvent.KEY_LOCATION_STANDARD;
import static java.awt.event.KeyEvent.KEY_PRESSED;
import static java.awt.event.KeyEvent.KEY_TYPED;
import static javafx.scene.input.KeyCode.Q;


/**
 * Created by Vincent on 14/06/2017.
 */

/**
 * Test the behavior of the EventPerformer class
 * @see EventPerformer
 */
public class EventPerformerTest {
    private IOrderPerformer orderPerformer ;
    private EventPerformer eventPerformer ;
    KeyEvent keyEvent ;
    String actualUserOrder ;
    String expectedUserOrder ;

    /**
     * Test if the keyEventToUserOrder method return the correct string for the given keyEvent (typed left, pressed space, released space)
     * @throws Exception
     */
    @Test
    public void keyCodeToUserOrder() throws Exception {
        this.eventPerformer = new EventPerformer(orderPerformer) ;

        this.keyEvent = new KeyEvent(new JFrame("test") , 400, 1 , 0 , 0 , 'q') ;
        actualUserOrder = this.eventPerformer.keyEventToUserOrder(keyEvent);
        expectedUserOrder = "LEFT" ;
        Assert.assertEquals(expectedUserOrder , actualUserOrder);

        this.keyEvent = new KeyEvent(new JFrame("test") , 401, 1 , 0 , 0 , ' ') ;
        actualUserOrder = this.eventPerformer.keyEventToUserOrder(keyEvent);
        expectedUserOrder = "START" ;
        Assert.assertEquals(expectedUserOrder , actualUserOrder);

        this.keyEvent = new KeyEvent(new JFrame("test") , 402, 1 , 0 , 0 , ' ') ;
        actualUserOrder = this.eventPerformer.keyEventToUserOrder(keyEvent);
        expectedUserOrder = "START_RELEASED" ;
        Assert.assertEquals(expectedUserOrder , actualUserOrder);

    }
}


