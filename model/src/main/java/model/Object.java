package model;


/**
 * Created by Théo on 14/06/2017.
 */
public class Object extends Mobile {

    public Object(Direction direction, Position position, Dimension dimension, String image , String name) {
        super(direction, position, dimension, image , name);
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
