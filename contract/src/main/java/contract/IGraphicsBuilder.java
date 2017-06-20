package contract;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 * Made on 14/06/2017
 */

public interface IGraphicsBuilder {
    void applyModelToGraphic (Graphics graphics, ImageObserver observer) ;
    int getGlobalWidth () ;
    int getGlobalHeight () ;
}
