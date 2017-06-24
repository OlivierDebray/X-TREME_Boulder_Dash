package view;

import contract.IEventPerformer;
import contract.IOrderPerformer;
import contract.IUserOrder;

import java.awt.event.KeyEvent;
import java.util.Objects;

/**
 * @author Vincent Alayrac vincent.alayrac@viacesi.fr
 *         Made on 14/06/2017.
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
                case 'w' :
                    userOrder = "A";
                    break;
                case 'x' :
                    userOrder = "B";
                    break;
                case ' ':
                    userOrder = "START";
                    break;
                default:
                    userOrder = "NONE";
                    break ;
            }
        }
        else if (keyEvent.getID() == 402) {
            switch (keyEvent.getKeyChar()) {
                case 'z' :
                    userOrder = "NONE";
                    break;
                case 's':
                    userOrder = "NONE";
                    break;
                case 'd':
                    userOrder = "NONE";
                    break;
                case 'q':
                    userOrder = "NONE";
                    break;
                case 'w' :
                    userOrder = "NONE";
                    break;
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
