package view;

import contract.IEventPerformer;
import contract.IOrderPerformer;
import contract.IUserOrder;

import java.awt.event.KeyEvent;
import java.util.Objects;

/**
 * Created by Vincent on 14/06/2017.
 */

/**
 * This class allows to see the movements of the player
 */
public class EventPerformer implements IEventPerformer {

    /**
     * @see IOrderPerformer
     */
    private IOrderPerformer orderPerformer ;

    /**
     * Builder EventPerformer
     * @param orderPerformer
     * @see IOrderPerformer
     */
    public EventPerformer (IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer ;
    }

    /**
     * This method
     * @param keyCode
     * @throws Exception
     * @see KeyEvent
     */
    @Override
    public void eventPerform (final KeyEvent keyEvent) throws Exception {
        final String userOrder = this.keyEventToUserOrder (keyEvent);
        if (!Objects.equals(userOrder, "")){
            this.orderPerformer.orderPerform(userOrder);
        }
    }

<<<<<<< HEAD
    /**
     * This method allows to show the user in what direction the player is going
     * @param keyCode
     * @return userOrder
     */
    public String keyCodeToUserOrder (final int keyCode) {
=======
    public String keyEventToUserOrder (final KeyEvent keyEvent) {
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
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
