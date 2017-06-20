package view;

import contract.IEventPerformer;
import contract.IOrderPerformer;
import contract.IUserOrder;

import java.awt.event.KeyEvent;

/**
 * Created by Vincent on 14/06/2017.
 */

public class EventPerformer implements IEventPerformer {
    private IOrderPerformer orderPerformer ;

    public EventPerformer (IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer ;
    }

    @Override
    public void eventPerform (final KeyEvent keyCode) throws Exception {
        final String userOrder = this.keyCodeToUserOrder (keyCode.getKeyCode());
        if (userOrder != null){
            this.orderPerformer.orderPerform(userOrder);
        }
    }

    public String keyCodeToUserOrder (final int keyCode) {
        String userOrder;
        switch (keyCode){
            case KeyEvent.VK_UP:
                userOrder = "UP";
                break;
            case KeyEvent.VK_DOWN:
                userOrder = "DOWN";
                break;
            case KeyEvent.VK_RIGHT:
                userOrder = "RIGHT";
                break;
            case KeyEvent.VK_LEFT:
                userOrder = "LEFT";
                break;
            case KeyEvent.VK_W :
                userOrder = "A";
                break;
            case KeyEvent.VK_X :
                userOrder = "B";
                break;
            case KeyEvent.VK_SPACE:
                userOrder = "START";
                break;
            default:
                userOrder = null;
        }
        return userOrder;
    }
}
