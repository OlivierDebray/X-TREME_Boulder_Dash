package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class define the settings of the Hero
 */
public class Hero extends Characters{

    /**
     * Builder of Hero
     * @param direction
     * @param position
     * @param dimension
     * @param speed
     * @param image
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Hero(Direction direction, Position position, Dimension dimension, int speed, String image) {
        super(direction, position, dimension, speed, image);
    }
}
