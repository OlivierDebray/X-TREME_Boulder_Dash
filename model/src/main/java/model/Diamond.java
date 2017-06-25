package model;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 15/06/2017.
 */
public class Diamond extends Object {
    public static String IMAGE = "Diamond.png" ;

    /**
     * Builder of Diamond
     * @param direction
     * @param position
     * @param dimension
     * @param levelType
     * @param name
     * @param properID
     * @see Direction
     * @see Position
     * @see Dimension
     * */
    public Diamond(Direction direction, Position position, Dimension dimension, int levelType , String name , int properID) {
        super(Direction.DOWN, position, dimension, "Sprites/type_"+ levelType +"/"+ IMAGE , name , levelType , properID);
    }
}