package model;


import contract.IArea;
import contract.IBoulderDashModel;
import contract.IMobile;

import java.awt.*;

/**
 * Created by Théo on 14/06/2017.
 */

public class Mobile implements IMobile {
    private int speed;
    private Image image[];
    private Position position;
    private Dimension dimension;
    private Direction direction;
    private BoulderDashModel boulderDashModel;

    public Mobile(Direction direction, Position position, final Dimension dimension, final int speed, final String image){

    }

    public void moveUp(){

    }

    public void moveDown(){

    }

    public void moveRight(){

    }

    public void moveLeft(){

    }

    public IBoulderDashModel getBoulderDashModel(){

        return null;
    }

    public void buildAllImages(final String imageName){

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
        return 0;
    }

    @Override
    public int getPositionY() {
        return 0;
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
        return 0;
    }

    @Override
    public int getDimensionHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public void move() {

    }

    @Override
    public void placeInArea(IArea area) {

    }

    @Override
    public void setBoulderDashModel(IBoulderDashModel boulderDashModel) {

    }

    @Override
    public boolean hit() {
        return false;
    }
}