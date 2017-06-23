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
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
public class Motionless implements IMobile {
    private Image image;
    private String name ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
public class Motionless implements IMobile {
    private Image image;
    private String name ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    private Position position;

    /**
     * @see Dimension
     */
    private Dimension dimension;
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
    private IBoulderDashModel boulderDashModel;
    private int properID ;
    private boolean isRemovable ;

    public Motionless( final Position position, final Dimension dimension, final String image , final int levelType , final String name , final int properID){
        this.position = position ;
        this.dimension = dimension ;
        this.properID = properID ;
        try {
            this.image = ImageIO.read(new File("Sprites/type_"+ levelType +"/"+ image +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = name ;

        switch (name) {
            case "dirt" :
                this.isRemovable = true ;
            default :
                this.isRemovable = false ;
        }
    }
=======
    private IBoulderDashModel boulderDashModel;
    private int properID ;
    private boolean isRemovable ;

    public Motionless( final Position position, final Dimension dimension, final String image , final int levelType , final String name , final int properID){
        this.position = position ;
        this.dimension = dimension ;
        this.properID = properID ;
        try {
            this.image = ImageIO.read(new File("Sprites/type_"+ levelType +"/"+ image +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = name ;

        switch (name) {
            case "dirt" :
                this.isRemovable = true ;
            default :
                this.isRemovable = false ;
        }
    }

    @Override
    public String getName () {
        return this.name ;
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
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b

    @Override
    public String getName () {
        return this.name ;
    }

    @Override
    public void setBoulderDashModel(final IBoulderDashModel boulderDashModel){
        this.boulderDashModel = boulderDashModel ;
    }

    public IBoulderDashModel getBoulderDashModel(){
        return this.boulderDashModel ;
    }

<<<<<<< HEAD
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

>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
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
=======
    @Override
    public int getPositionX() {
        return this.position.getX();
    }

    @Override
    public int getPositionY() {
        return this.position.getY();
    }

    @Override
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
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
    public int getProperID() {
        return this.properID ;
    }

    @Override
    public Image getImage(){
        return this.image ;
    }

    @Override
    public void move() {

    }

    @Override
    public void reverseMove(String direction) {
<<<<<<< HEAD
=======

    }

    @Override
    public void placeInArea(final IArea area){
        this.position.setXmax(area.getDimensionWidth());
        this.position.setYmax(area.getDimensionHeight());
    }
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b

    @Override
    public boolean hit() {
        return false;
    }

    @Override
<<<<<<< HEAD
    public void placeInArea(final IArea area){
<<<<<<< HEAD
    }

    public void setBoulderDashModel(final BoulderDashModel boulderDashModel){
=======
        this.position.setXmax(area.getDimensionWidth());
        this.position.setYmax(area.getDimensionHeight());
    }

    @Override
    public boolean hit() {
        return false;
    }

    @Override
    public boolean isRemovable () {
        return this.isRemovable ;
    }

    @Override
    public boolean isEnemy() {
        return false;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }

    @Override
=======
    public boolean isRemovable () {
        return this.isRemovable ;
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    public boolean isObject() {
        return false;
    }
}
