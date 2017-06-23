package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class allows to define the settings of Boulder
 */
public class Boulder extends Object {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    public static String IMAGE = "Boulder.png" ;

    public Boulder(Direction direction, Position position, Dimension dimension, int levelType , String name , int properID) {
        super(Direction.DOWN , position, dimension, "/Sprites/type_"+ levelType +"/"+ IMAGE , name , levelType , properID);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }
}
