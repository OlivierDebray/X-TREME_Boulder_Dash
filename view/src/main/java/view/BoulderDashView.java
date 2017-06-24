package view;

import contract.IBoulderDashModel;
import contract.IOrderPerformer;
import contract.IViewSystem;

import javax.swing.*;
import java.util.Observable;

/**
 * @author Vincent Alayrac vincent.alayrac@viacesi.fr
 *         Made on 14/06/2017.
 */

public class BoulderDashView implements IViewSystem, Runnable {
    private Observable observable ;
    private EventPerformer eventPerformer ;
    private GraphicsBuilder graphicsBuilder ;
    private GameFrame gameFrame ;

    public BoulderDashView (IOrderPerformer orderPerformer, IBoulderDashModel boulderDashModel, Observable observable ){
        this.observable = observable ;
        this.eventPerformer = new EventPerformer(orderPerformer) ;
        this.graphicsBuilder = new GraphicsBuilder(boulderDashModel) ;
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        this.gameFrame = new GameFrame("X-TREME BoulderDash !", this.eventPerformer, this.graphicsBuilder, this.observable);
    }

    @Override
    public void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void closeAll() {
        this.gameFrame.dispose();
    }
}
