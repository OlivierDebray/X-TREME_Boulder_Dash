package contract;

import java.awt.event.KeyEvent;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 * Made on 14/06/2017
 */

public interface IEventPerformer {
    void eventPerform(KeyEvent keyCode) throws Exception;
}
