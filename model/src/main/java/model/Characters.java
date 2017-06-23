package model;

/**
 * Created by Théo on 14/06/2017.
 */

/**
 * This class define all Characters that we need
 */
public class Characters extends Mobile {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    public Characters(Direction direction, Position position, Dimension dimension, String name, int levelType , int properID) {
        super(direction, position, dimension, name , levelType , properID);
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
    public Characters(Direction direction, Position position, Dimension dimension, String name, int levelType , int properID) {
        super(direction, position, dimension, name , levelType , properID);
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
    public Characters(Direction direction, Position position, Dimension dimension, String name, int levelType , int properID) {
        super(direction, position, dimension, name , levelType , properID);
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }

    public void die(){

    }

    public void explode(){

    }
}
