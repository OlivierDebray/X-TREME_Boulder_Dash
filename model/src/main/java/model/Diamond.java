package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class define the settings of Diamond
 */
public class Diamond extends Object {
    public static String IMAGE = "Diamond.png" ;

<<<<<<< HEAD
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
=======
    public Diamond(Direction direction, Position position, Dimension dimension, int levelType , String name , int properID) {
        super(Direction.DOWN, position, dimension, "Sprites/type_"+ levelType +"/"+ IMAGE , name , levelType , properID);
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }
}