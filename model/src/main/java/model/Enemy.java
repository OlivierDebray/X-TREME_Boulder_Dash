package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class gather the functionality of the Enemy
 */
public class Enemy extends Characters {

    /**
     * Builder of Enemy
     * @param direction
     * @param position
     * @param dimension
     * @param speed
     * @param image
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Enemy(Direction direction, Position position, Dimension dimension, int speed, String image) {
        super(direction, position, dimension, speed, image);
    }
}
