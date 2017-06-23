package view;

import contract.IGraphicsBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

/**
 * This class allows to modify the contents of the window
 */
public class GamePanel extends JPanel implements Observer {
    //private static final long serialVersionUID = 3987064896591403626L;

    /**
     * @see IGraphicsBuilder
     */
    private IGraphicsBuilder graphicsBuilder ;

    /**
     * Builder of GamePanel
     * @param graphicsBuilder
     * @see IGraphicsBuilder
     */
    public GamePanel (IGraphicsBuilder graphicsBuilder) {
        this.graphicsBuilder = graphicsBuilder ;
    }

    /**
     * @param observable
     * @param object
     * @see Observable
     * @see Object
     */
    @Override
    public void update(final Observable observable, final Object object) {
        this.repaint();
    }

    /**
     * @param graphics
     * @see Graphics
     */
    @Override
    protected void paintComponent(final Graphics graphics) {
        this.graphicsBuilder.applyModelToGraphic(graphics, this);
    }
}
