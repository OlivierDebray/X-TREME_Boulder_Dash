package view;

import contract.IBoulderDashModel;
import contract.IOrderPerformer;
import contract.IViewSystem;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by Vincent on 14/06/2017.
 */

/**
 * This class represents what the user will have before the eyes
 */
public class BoulderDashView implements IViewSystem, Runnable {
    /**
     * @see Observable
     */
    private Observable observable ;

    /**
     *@see EventPerformer
     */
    private EventPerformer eventPerformer ;

    /**
     *@see GraphicsBuilder
     */
    private GraphicsBuilder graphicsBuilder ;

    /**
     * @see GameFrame
     */
    private GameFrame gameFrame ;

    /**
     * Builder of BoulderSashView
     * @param orderPerformer
     * @param boulderDashModel
     * @param observable
     * @see IOrderPerformer
     * @see IBoulderDashModel
     * @see Observable
     */
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
