package model;

/**
 * Created by Théo on 14/06/2017.
 */

/**
 * This class define all Characters that we need
 */
public class Characters extends Mobile {

    /**
     * Builder of Characters
     * @param direction
     * @param position
     * @param dimension
     * @param speed
     * @param image
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Characters(Direction direction, Position position, Dimension dimension, int speed, String image) {
        super(direction, position, dimension, speed, image);
    }

    public void die(){

    }

    public void explode(){

    }
}
