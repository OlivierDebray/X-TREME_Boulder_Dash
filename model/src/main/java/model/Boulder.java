package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class allows to define the settings of Boulder
 */
public class Boulder extends Object {

    /**
     * Builder of Boulder
     * @param direction
     * @param position
     * @param dimension
     * @param speed
     * @param image
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Boulder(Direction direction, Position position, Dimension dimension, int speed, String image) {
        super(direction, position, dimension, speed, image);
    }
}
