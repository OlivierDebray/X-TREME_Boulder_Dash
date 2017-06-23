package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class define the settings of Diamond
 */
public class Diamond extends Object {

    /**
     * Builder of Diamond
     * @param direction
     * @param position
     * @param dimension
     * @param speed
     * @param image
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Diamond(Direction direction, Position position, Dimension dimension, int speed, String image) {
        super(direction, position, dimension, speed, image);
    }
}
