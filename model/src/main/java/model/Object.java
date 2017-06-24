package model;


/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 14/06/2017.
 */
public class Object extends Mobile {

    /**
     * Builder of Object
     * @param direction
     * @param position
     * @param dimension
     * @param image
     * @param name
     * @param levelType
     * @param properID
     * @see Direction
     * @see Position
     * @see Dimension
     */
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
    }
}
