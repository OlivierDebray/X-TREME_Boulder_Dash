package model;

import contract.IArea;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 16/06/2017.
 */


public class Map implements IArea {
    private static String IMAGE = "Background.png" ;

    /**
     * @see Image
     */
    private Image image ;

    /**
     * @see Dimension
     */
    private Dimension dimension;

    /**
     * Builder of Map
     * Access path of the map
     * @param width
     * @param height
     * @param levelType
     * @see Dimension
     */
    public Map(int width , int height , int levelType){
        this.dimension = new Dimension(width , height) ;

        try {
            this.image = ImageIO.read(new File("Sprites/type_" + levelType + "/" + IMAGE));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows to read the size of the Map
     * @return the dimension
     */
    public Dimension getDimension() {
        return this.dimension ;
    }

    /**
     * Allows to read the Width of the Map
     * @return width
     */
    @Override
    public int getDimensionWidth() {
        return this.dimension.getWidth();
    }

    /**
     * Allows to read the Height of the Map
     * @return height
     */
    @Override
    public int getDimensionHeight() {
        return this.dimension.getHeight();
    }

    /**
     *  allows to read Image of the map
     * @return Image
     */
    @Override
    public Image getImage() {
        return this.image ;
    }
}
