package model;

/**
 * Created by Théo on 15/06/2017.
 */
public class Boulder extends Object {
    public static String IMAGE = "Boulder.png" ;

    public Boulder(Direction direction, Position position, Dimension dimension, int speed, int levelType) {
        super(direction, position, dimension, speed, "/Sprites/type_"+ levelType +"/"+ IMAGE);
    }
}
