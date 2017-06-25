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

    /**
     * @see Observable
     */
    private Observable observable ;

    /**
     * @see EventPerformer
     */
    private EventPerformer eventPerformer ;

    /**
     * @see GraphicsBuilder
     */
    private GraphicsBuilder graphicsBuilder ;

    /**
     * @see GameFrame
     */
    private GameFrame gameFrame ;

    private int zoom ;

    /**
     * Builder of BoulderDashView
     * @param orderPerformer
     * @param boulderDashModel
     * @param observable
     * @param zoom
     * @see IOrderPerformer
     * @see IBoulderDashModel
     * @see Observable
     * @see GraphicsBuilder
     * @see EventPerformer
     */
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
