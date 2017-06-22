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
    public IEventPerformer eventPerformer ;

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

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        try {
            this.eventPerformer.eventPerform(keyEvent);
            System.out.println("keytyped") ;
            System.out.println(keyEvent) ;
            System.out.println(keyEvent.getID()) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        try {
            this.eventPerformer.eventPerform(keyEvent);
            System.out.println(keyEvent.getID()) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
