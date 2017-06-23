package model;


/**
 * Created by Théo on 14/06/2017.
 */
public class Object extends Mobile {

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
