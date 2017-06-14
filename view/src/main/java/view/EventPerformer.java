package view;

import java.awt.event.KeyEvent;

/**
 * Created by Vincent on 14/06/2017.
 */

public class EventPerformer implements IEventPerformer {
    private OrderPerformer orderPerformer ;

    public EventPerformer (IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer ;
    }

    public void keyCodeToUserOrder (int keycode) {

    }

    @Override
    public void eventPerform (KeyEvent keyCode) {

    }
}
