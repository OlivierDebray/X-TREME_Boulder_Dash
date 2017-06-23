package model;

import contract.IArea;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Théo on 16/06/2017.
 */

/**
 * This class allows to include the Map
 */
public class Map implements IArea {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    /**
     * @see Dimension
     */
    private Dimension dimension;

    /**
     * Builder of Map
     * @param dimension
     * @see Dimension
     */
    public Map(final Dimension dimension){
=======
    private static String IMAGE = "Background.png" ;
    private Image image ;
    private Dimension dimension;

    public Map(int width , int height , int levelType){
        this.dimension = new Dimension(width , height) ;

=======
    private static String IMAGE = "Background.png" ;
    private Image image ;
    private Dimension dimension;

    public Map(int width , int height , int levelType){
        this.dimension = new Dimension(width , height) ;

>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
        try {
            this.image = ImageIO.read(new File("Sprites/type_" + levelType + "/" + IMAGE));
        } catch (final IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }

=======
    private static String IMAGE = "Background.png" ;
    private Image image ;
    private Dimension dimension;

    public Map(int width , int height , int levelType){
        this.dimension = new Dimension(width , height) ;

        try {
            this.image = ImageIO.read(new File("Sprites/type_" + levelType + "/" + IMAGE));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
    }

>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    public Dimension getDimension() {
        return this.dimension ;
    }

    @Override
    public int getDimensionWidth() {
        return this.dimension.getWidth();
    }

    @Override
    public int getDimensionHeight() {
        return this.dimension.getHeight();
    }

    @Override
    public Image getImage() {
        return this.image ;
    }
}
