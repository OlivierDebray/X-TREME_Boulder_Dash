package view;

import contract.IEventPerformer;
import contract.IGraphicsBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public class GameFrame extends JFrame implements KeyListener {
    private static long serialVersionUID = -1112124206501543946L ;
    public IEventPerformer eventPerformer ;

    public GameFrame (String title , IEventPerformer eventPerformer , IGraphicsBuilder graphicsBuilder , Observable observable) throws HeadlessException {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
