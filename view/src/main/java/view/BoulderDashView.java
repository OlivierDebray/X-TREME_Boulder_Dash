package view;

import contract.IBoulderDashModel;
import contract.IOrderPerformer;
import contract.IViewSystem;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by Vincent on 14/06/2017.
 */

public class BoulderDashView implements IViewSystem, Runnable {
    private Observable observable ;
    private EventPerformer eventPerformer ;
    private GraphicsBuilder graphicsBuilder ;
    private GameFrame gameFrame ;
    private int zoom ;

    public BoulderDashView (IOrderPerformer orderPerformer, IBoulderDashModel boulderDashModel, Observable observable, int zoom ){
        this.observable = observable ;
        this.zoom = zoom ;
        this.eventPerformer = new EventPerformer(orderPerformer) ;
        this.graphicsBuilder = new GraphicsBuilder(boulderDashModel , zoom) ;
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        this.gameFrame = new GameFrame("X-TREME BoulderDash !", this.eventPerformer, this.graphicsBuilder, this.observable , zoom);
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
