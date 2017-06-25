package model;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 15/06/2017.
 */

public class Boulder extends Object {

    /**
     * Access path of the image boulder
     */
    public static String IMAGE = "Boulder.png" ;

    /**
     * Builder of Boudler
     * @param direction
     * @param position
     * @param dimension
     * @param levelType
     * @param name
     * @param properID
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Boulder(Direction direction, Position position, Dimension dimension, int levelType , String name , int properID) {
        super(Direction.DOWN , position, dimension, "/Sprites/type_"+ levelType +"/"+ IMAGE , name , levelType , properID);
    }
}
