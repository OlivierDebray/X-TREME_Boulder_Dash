package model;


/**
 * Created by Théo on 14/06/2017.
 */

public class Object extends Mobile {

<<<<<<< HEAD
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
=======
    public Object(Direction direction, Position position, Dimension dimension, String image , String name , int levelType , int properID) {
        super(direction, position, dimension, name, levelType , properID);
    }

    @Override
    public boolean isObject() {
        return true ;
    }

    @Override
    public boolean hit() {
        return true ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }
}
