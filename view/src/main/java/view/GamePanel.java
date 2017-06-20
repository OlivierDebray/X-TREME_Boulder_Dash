package view;

import contract.IGraphicsBuilder;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public class GamePanel extends JPanel implements Observer {
    //private static final long serialVersionUID = 3987064896591403626L;
    private IGraphicsBuilder graphicsBuilder ;

    public GamePanel (IGraphicsBuilder graphicsBuilder) {
        this.graphicsBuilder = graphicsBuilder ;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
