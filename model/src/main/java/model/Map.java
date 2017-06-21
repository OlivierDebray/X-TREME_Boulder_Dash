package model;

import contract.IArea;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Théo on 16/06/2017.
 */

public class Map implements IArea {
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
