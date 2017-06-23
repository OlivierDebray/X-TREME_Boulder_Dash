package model;


/**
 * Created by Théo on 14/06/2017.
 */

public class Object extends Mobile {

    /**
     * Builder of Object
     * @param direction
     * @param position
     * @param dimension
     * @param speed
     * @param image
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Object(Direction direction, Position position, Dimension dimension, int speed, String image) {
        super(direction, position, dimension, speed, image);
    }
}
