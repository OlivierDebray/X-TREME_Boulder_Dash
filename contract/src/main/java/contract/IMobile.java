package contract;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public interface IMobile {
    Direction getDirection () ;
    void setDirection (Direction direction) ;
    Position getPosition () ;
    Dimension getDimension () ;
    int getWidth () ;
    int getHeight () ;
    int getSpeed () ;
    Image getImage () ;
    void move () ;
    void placeInArea(IArea area) ;
    void setBoulderDashModel(BoulderDashModel boulderDashModel) ;
    boolean hit () ;
}
