package model;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 15/06/2017.
 */
public class Hero extends Characters{

    /**
     * Builder of Hero
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
    public Hero(Direction direction, Position position, Dimension dimension, int levelType, String name , int properID) {
        super(direction, position, dimension, name , levelType , properID);
    }
}
