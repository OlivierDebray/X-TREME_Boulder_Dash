package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class define the settings of the Hero
 */
public class Hero extends Characters{

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    public Hero(Direction direction, Position position, Dimension dimension, int levelType, String name , int properID) {
        super(direction, position, dimension, name , levelType , properID);
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
    public Hero(Direction direction, Position position, Dimension dimension, int levelType, String name , int properID) {
        super(direction, position, dimension, name , levelType , properID);
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }
}
