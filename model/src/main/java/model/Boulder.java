package model;

/**
 * Created by Théo on 15/06/2017.
 */
public class Boulder extends Object {
    public static String IMAGE = "Boulder.png" ;

    public Boulder(Direction direction, Position position, Dimension dimension, int levelType , String name) {
        super(direction, position, dimension, "/Sprites/type_"+ levelType +"/"+ IMAGE , name , levelType);
    }
}
