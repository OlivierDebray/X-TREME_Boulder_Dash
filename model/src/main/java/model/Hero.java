package model;

/**
 * Created by Théo on 15/06/2017.
 */
public class Hero extends Characters{

    public Hero(Direction direction, Position position, Dimension dimension, int levelType, String name , int properID) {
        super(direction, position, dimension, name , levelType , properID);
    }
}
