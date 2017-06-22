package model;

import contract.IArea;
import contract.IBoulderDashModel;
import contract.IMobile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Théo on 16/06/2017.
 */
public class Motionless implements IMobile {
    private Image image;
    private Position position;
    private Dimension dimension;
    private IBoulderDashModel boulderDashModel;

    public Motionless( final Position position, final Dimension dimension, final String image , final int levelType){
        this.position = position ;
        this.dimension = dimension ;
        try {
            this.image = ImageIO.read(new File("Sprites/type_"+ levelType +"/"+ image +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBoulderDashModel(final IBoulderDashModel boulderDashModel){
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

    @Override
    public String getDirection() {
        return null;
    }

    @Override
    public void setDirection(String direction) {

    }

    @Override
    public int getPositionX() {
        return this.position.getX();
    }

    @Override
    public int getPositionY() {
        return this.position.getY();
    }

    @Override
    public int getPositionXMax() {
        return 0;
    }

    @Override
    public int getPositionYMax() {
        return 0;
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
    public int getWidth() {
        return this.getDimensionWidth();
    }

    @Override
    public int getHeight() {
        return this.getDimensionHeight();
    }

    @Override
    public Image getImage(){
        return this.image ;
    }

    @Override
    public void move() {

    }

    @Override
    public void placeInArea(final IArea area){
        this.position.setXmax(area.getDimensionWidth());
        this.position.setYmax(area.getDimensionHeight());
    }

    @Override
    public boolean hit() {
        return false;
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public boolean isObject() {
        return false;
    }
}
