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
    public void eventPerform (final KeyEvent keyCode) {
        final IUserOrder userOrder = this.keyCodeToUserOrder (keyCode.getKeyCode());
        if (userOrder != null){
            this.orderPerformer.orderPerform(userOrder);
        }
    }

    private IUserOrder keyCodeToUserOrder (final int keyCode) {
        IUserOrder userOrder;
        switch (keyCode){
            case KeyEvent.VK_UP:
                userOrder = new UserOrder (Order.UP);
                break;
            case KeyEvent.VK_DOWN:
                userOrder = new UserOrder (Order.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                userOrder = new UserOrder (Order.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                userOrder = new UserOrder (Order.LEFT);
                break;
            case KeyEvent.VK_A
                userOrder = new UserOrder (Order.DIG);
                break;
            case KeyEvent.VK_B:
                userOrder = new UserOrder (Order.PICKUP);
                break;
            default:
                userOrder = null;
        }
        return userOrder;
    }
}
