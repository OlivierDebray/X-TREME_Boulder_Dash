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
    //private static long serialVersionUID = -1112124206501543946L ;

    /**
     * @see IEventPerformer
     */
    public IEventPerformer eventPerformer ;

    /**
     * This Builder instantiate a new eventPerformer object whose performer is the one in parameter
     * @param title
     * @param eventPerformer
     * @param graphicsBuilder
     * @param observable
     * @param zoom
     * @throws HeadlessException
     * @see IEventPerformer
     * @see IGraphicsBuilder
     * @see Observable
     * @see EventPerformer
     */
    public GameFrame (String title , IEventPerformer eventPerformer , IGraphicsBuilder graphicsBuilder , Observable observable , int zoom) throws HeadlessException {
        this.eventPerformer = eventPerformer;

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setVisible(true);

        GamePanel gamePanel = new GamePanel(graphicsBuilder);
        this.setContentPane(gamePanel);
        this.setSize(graphicsBuilder.getGlobalWidth() * zoom  + this.getInsets().left + this.getInsets().right, graphicsBuilder.getGlobalHeight() * zoom  + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        observable.addObserver(gamePanel);

        this.setVisible(true);
    }

    /**
     * Know type of keys
     * @param keyEvent
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        try {
            this.eventPerformer.eventPerform(keyEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Know which key is pressed
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        try {
            this.eventPerformer.eventPerform(keyEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * know the key released
     * @param keyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        try {
            this.eventPerformer.eventPerform(keyEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
