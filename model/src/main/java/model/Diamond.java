package model;

/**
 * Created by Théo on 15/06/2017.
 */
public class Diamond extends Object {
    public static String IMAGE = "Diamond.png" ;

    public Diamond(Direction direction, Position position, Dimension dimension, int speed, int levelType) {
        super(direction, position, dimension, speed, "/Sprites/type_"+ levelType +"/"+ IMAGE);
    }
}
