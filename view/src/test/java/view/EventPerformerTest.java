package view;


import contract.IOrderPerformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;


/**
 * Created by Vincent on 14/06/2017.
 */

public class EventPerformerTest {
    private IOrderPerformer orderPerformer ;
    private EventPerformer eventPerformer ;

    @Before
    public void setUp () {
        eventPerformer = new EventPerformer(orderPerformer) ;
    }

    @Test
    public void eventPerform() throws Exception {
    }

    @Test
    public void keyCodeToUserOrder() throws Exception {
    }
}


