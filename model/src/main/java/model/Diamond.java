package model;

/**
 * Created by Théo on 15/06/2017.
 */
public class Diamond extends Object {
    public static String IMAGE = "Diamond.png" ;

    public Diamond(Direction direction, Position position, Dimension dimension, int levelType , String name) {
        super(Direction.DOWN, position, dimension, "Sprites/type_"+ levelType +"/"+ IMAGE , name , levelType);
    }
}