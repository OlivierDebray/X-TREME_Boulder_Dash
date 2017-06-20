package model;

import contract.IArea;
import contract.IBoulderDashModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Théo on 16/06/2017.
 */
public class Motionless {
    private Image image;
    private Position position;
    private Dimension dimension;
    private BoulderDashModel boulderDashModel;

    public Motionless( final Position position, final Dimension dimension, final String image , final int levelType){
        this.position = position ;
        this.dimension = dimension ;
        try {
            this.image = ImageIO.read(new File("/Sprites/type_"+ levelType +"/"+ image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBoulderDashModel(final BoulderDashModel boulderDashModel){
        this.boulderDashModel = boulderDashModel ;
    }

    public IBoulderDashModel getBoulderDashModel(){
        return this.boulderDashModel ;
    }

    public Position getPosition(){
        return this.position ;
    }

    public Dimension getDimension(){
        return this.dimension ;
    }

    public Image getImage(){
        return this.image ;
    }

    public void placeInArea(final IArea area){
        this.position.setXmax(area.getDimensionWidth());
        this.position.setYmax(area.getDimensionHeight());
    }
}
