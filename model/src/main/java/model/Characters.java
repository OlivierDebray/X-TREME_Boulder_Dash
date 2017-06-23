package model;

/**
 * Created by Théo on 14/06/2017.
 */
public class Characters extends Mobile {

    public Characters(Direction direction, Position position, Dimension dimension, String name, int levelType , int properID) {
        super(direction, position, dimension, name , levelType , properID);
    }

    public void die(){

    }

    public void explode(){

    }
}
