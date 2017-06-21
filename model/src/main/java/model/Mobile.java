package model;


import contract.IArea;
import contract.IBoulderDashModel;
import contract.IMobile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Théo on 14/06/2017.
 */

public class Mobile implements IMobile {
    private Image images[];
    private Position position;
    private Dimension dimension;
    private Direction direction;
    private IBoulderDashModel boulderDashModel;

    public Mobile(Direction direction, Position position, final Dimension dimension, final String image){

    }

    @Override
    public void move() {
        switch (this.direction){
            case UP:
                this.moveUp();
                break;
            case DOWN:
                this.moveDown();
                break;
            case LEFT:
                this.moveLeft();
                break;
            case RIGHT:
                this.moveRight();
                break;
            case NONE:
                break;
            default:
                break;
        }

    }

    public void moveUp(){
        this.position.setY(this.position.getY());
    }

    public void moveDown(){
        this.position.setY(this.position.getY());
    }

    public void moveRight(){
        this.position.setX(this.position.getX());
    }

    public void moveLeft(){
        this.position.setX(this.position.getX());
    }

    public void buildAllImages(final String imageName) throws IOException{
        this.images = new Image[5];
        this.images[Direction.UP.ordinal()] = ImageIO.read(new File("ProjetJava/Sprites/Hero/"+ imageName +"_UP.png"));
        this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("ProjetJava/Sprites/Hero/"+ imageName +"_DOWN.png"));
        this.images[Direction.RIGHT.ordinal()] = ImageIO.read(new File("ProjetJava/Sprites/Hero/"+ imageName +"_RIGHT.png"));
        this.images[Direction.LEFT.ordinal()] = ImageIO.read(new File("ProjetJava/Sprites/Hero/"+ imageName +"_LEFT.png"));
        this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("ProjetJava/Sprites/Hero/"+ imageName +"_DIE.png"));
    }

    @Override
    public String getDirection() {
        return this.direction.toString();
    }

    @Override
    public void setDirection(String direction) {
        switch (direction){
            case "UP":
                this.direction = Direction.UP;
                break;
            case "DOWN":
                this.direction = Direction.DOWN;
                break;
            case "RIGHT":
                this.direction = Direction.RIGHT;
                break;
            case "LEFT":
                this.direction = Direction.LEFT;
                break;
            case "NONE":
                this.direction = Direction.NONE;
                break;
            default:
                this.direction = Direction.NONE;
        }
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
        switch (this.direction) {
            case NONE:
            case UP:
            case DOWN:
                return this.getDimensionHeight();
            case RIGHT:
            case LEFT:
            default:
                return this.getDimensionWidth();
        }
    }

    @Override
    public int getHeight() {
        switch (this.direction) {
            case UP:
            case DOWN:
                return this.getDimensionWidth();
            case RIGHT:
            case LEFT:
            default:
                return this.getDimensionHeight();
        }
    }

    @Override
    public Image getImage() {
        return this.images[this.direction.ordinal()];
    }

    @Override
    public void placeInArea(IArea area) {
        this.position.setXmax(area.getDimensionWidth());
        this.position.setYmax(area.getDimensionHeight());
    }

    public IBoulderDashModel getBoulderDashModel(){
        return this.boulderDashModel;
    }

    @Override
    public void setBoulderDashModel(IBoulderDashModel boulderDashModel) {
        this.boulderDashModel = boulderDashModel;
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
