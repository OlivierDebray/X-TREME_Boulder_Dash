package model;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 14/06/2017.
 */
public class Characters extends Mobile {

    /**
     * Builder of Characters
     * @param direction
     * @param position
     * @param dimension
     * @param name
     * @param levelType
     * @param properID
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Characters(Direction direction, Position position, Dimension dimension, String name, int levelType , int properID) {
        super(direction, position, dimension, name , levelType , properID);
    }

    public void die(){

    }

    public void explode(){

    }
}
