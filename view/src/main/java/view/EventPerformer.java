package view;

import contract.IEventPerformer;
import contract.IOrderPerformer;
import contract.IUserOrder;

import java.awt.event.KeyEvent;
import java.util.Objects;

/**
 * Created by Vincent on 14/06/2017.
 */

public class EventPerformer implements IEventPerformer {
    private IOrderPerformer orderPerformer ;

    public EventPerformer (IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer ;
    }

    @Override
    public void eventPerform (final KeyEvent keyEvent) throws Exception {
        final String userOrder = this.keyEventToUserOrder (keyEvent);
        if (!Objects.equals(userOrder, "")){
            this.orderPerformer.orderPerform(userOrder);
        }
    }

    public String keyEventToUserOrder (final KeyEvent keyEvent) {
        String userOrder;
        if (keyEvent.getID() == 400) {
            switch (keyEvent.getKeyChar()){
                case 'z' :
                    userOrder = "UP";
                    break;
                case 's':
                    userOrder = "DOWN";
                    break;
                case 'd':
                    userOrder = "RIGHT";
                    break;
                case 'q':
                    userOrder = "LEFT";
                    break;
                default:
                    userOrder = "NONE";
                    break ;
            }
        }
        else if (keyEvent.getID() == 401) {
            switch (keyEvent.getKeyChar()) {
                case ' ':
                    userOrder = "START";
                    break;
                default :
                    userOrder = "NONE" ;
                    break ;
            }
        }
        else if (keyEvent.getID() == 402) {
            switch (keyEvent.getKeyChar()) {
                case ' ':
                    userOrder = "START_RELEASED";
                    break;
                case 'z' :
                case 's':
                case 'd':
                case 'q':
                case 'w' :
                case 'x' :
                default :
                    userOrder = "NONE" ;
                    break ;
            }
        }
        else {
            userOrder = "NONE" ;
        }
        return userOrder;
    }
}
