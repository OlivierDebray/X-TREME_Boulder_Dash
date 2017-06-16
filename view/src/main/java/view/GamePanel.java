package view;

import contract.IEventPerformer;
import contract.IGraphicsBuilder;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public class GamePanel implements Observer {
    void GamePanel (String title , IEventPerformer eventPerformer , IGraphicsBuilder graphicsBuilder , Observable observable) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
