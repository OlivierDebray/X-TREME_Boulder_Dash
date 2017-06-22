package contract;

import java.awt.*;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public interface IMobile {
    String getName () ;
    String getDirection () ;
    void setDirection (String direction) ;
    int getPositionX () ;
    int getPositionY () ;
    int getPositionXMax () ;
    int getPositionYMax () ;
    int getDimensionWidth () ;
    int getDimensionHeight () ;
    int getWidth () ;
    int getHeight () ;
    Image getImage () ;
    void move () ;
    void reverseMove (String direction) ;
    void placeInArea(IArea area) ;
    void setBoulderDashModel(IBoulderDashModel boulderDashModel) ;
    boolean hit () ;
    boolean isRemovable () ;
    boolean isEnemy () ;
    boolean isObject () ;
}
