package model;

import contract.IArea;
import contract.IBoulderDashModel;

import java.awt.*;

/**
 * Created by Théo on 16/06/2017.
 */

/**
 * This class instantiate the elements not moving by itself
 */
public class Motionless {

    /**
     * @see Image
     */
    private Image images[];


    /**
     * @see Position
     */
    private Position position;

    /**
     * @see Dimension
     */
    private Dimension dimension;

    /**
     * @see BoulderDashModel
     */
    private BoulderDashModel boulderDashModel;

    /**
     * Builder of Motionless
     * @param position
     * @param dimension
     * @param image
     * @see Position
     * @see Dimension
     */
    public Motionless( final Position position, final Dimension dimension, final String image){
    }

    public IBoulderDashModel getBoulderDashModel(){
        return null;
    }

    public void buildAllImages(final String imageName){
    }

    public Position getPosition(){
        return null;
    }

    public Dimension getDimentsion(){
        return null;
    }

    public Image getImage(){
        return null;
    }

    public void placeInArea(final IArea area){
    }

    public void setBoulderDashModel(final BoulderDashModel boulderDashModel){
    }

}
