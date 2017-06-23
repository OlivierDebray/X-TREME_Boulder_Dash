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

/**
 * This class allows to create a new  window
 */
public class GameFrame extends JFrame implements KeyListener {
    //private static long serialVersionUID = -1112124206501543946L ;

    /**
     * @see IEventPerformer
     */
    public IEventPerformer eventPerformer ;

    /**
     * Builder of GameFrame
     * @param title
     * @param eventPerformer
     * @param graphicsBuilder
     * @param observable
     * @throws HeadlessException
     * @see IEventPerformer
     * @see IGraphicsBuilder
     * @see Observable
     */
    public GameFrame (String title , IEventPerformer eventPerformer , IGraphicsBuilder graphicsBuilder , Observable observable) throws HeadlessException {
        this.eventPerformer = eventPerformer;

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setVisible(true);

        GamePanel gamePanel = new GamePanel(graphicsBuilder);
        this.setContentPane(gamePanel);
        this.setSize(graphicsBuilder.getGlobalWidth() + this.getInsets().left + this.getInsets().right, graphicsBuilder.getGlobalHeight() + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        observable.addObserver(gamePanel);

        this.setVisible(true);
    }

    /**
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
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    /**
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
