package model;


import contract.IArea;
import contract.IBoulderDashModel;
import contract.IMobile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 14/06/2017.
 */

public class Mobile implements IMobile {

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
     * @see Direction
     */
    private Direction direction;

    /**
     * @see IBoulderDashModel
     */
    private IBoulderDashModel boulderDashModel;

    private int properID ;

    /**
     * Builder of Mobile
     * @param direction
     * @param position
     * @param dimension
     * @param mobileName
     * @param levelType
     * @param properID
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Mobile(Direction direction, Position position, final Dimension dimension, final String mobileName , final int levelType , final int properID){
        this.direction = direction;
        this.position = position;
        this.dimension = dimension;
        this.properID = properID ;
        try {
            this.buildAllImages(mobileName , levelType);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName () {
        return this.getClass().toString() ;
    }

    /**
     *
     Defines the movements of mobile enemies
     */
    @Override
    public void move() {
        if (this.isEnemy()) {
            switch (this.getDirection()) {
                case "UP" :
                    if (this.clockWiseMove())
                        setDirection("RIGHT");
                    else if (!this.clockWiseMove())
                        setDirection("LEFT");
                    break ;
                case "RIGHT" :
                    if (this.clockWiseMove())
                        setDirection("DOWN");
                    else if (!this.clockWiseMove())
                        setDirection("UP");
                    break ;
                case "DOWN" :
                    if (this.clockWiseMove())
                        setDirection("LEFT");
                    else if (!this.clockWiseMove())
                        setDirection("RIGHT");
                    break ;
                case "LEFT" :
                    if (this.clockWiseMove())
                        setDirection("UP");
                    else if (!this.clockWiseMove())
                        setDirection("DOWN");
                    break ;
                case "NONE" :
                    if (this.clockWiseMove())
                        setDirection("UP");
                    else if (!this.clockWiseMove())
                        setDirection("DOWN");
                    break ;
                default :
                    break ;
            }
        }
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
            default:
                break;
        }
    }

    /**
     * Reverse moves of Enemy
     * @param direction
     */
    @Override
    public void reverseMove (String direction) {
        switch (direction) {
            case "UP" :
                this.moveDown();
                break ;
            case "RIGHT" :
                this.moveLeft();
                break ;
            case "DOWN" :
                this.moveUp();
                break ;
            case "LEFT" :
                this.moveRight();
                break ;
            default :
                break ;
        }
    }

    public void moveUp(){
        this.position.setY(this.position.getY() - 16);
    }

    public void moveDown(){
        this.position.setY(this.position.getY() + 16);
    }

    public void moveRight(){
        this.position.setX(this.position.getX() + 16);
    }

    public void moveLeft(){
        this.position.setX(this.position.getX() - 16);
    }

    /**
     * Associates the images with the different movements
     * @param mobileName
     * @param levelType
     * @throws IOException
     */
    public void buildAllImages(final String mobileName , final int levelType) throws IOException{
        switch (mobileName) {
            case "hero" :
                this.images = new Image[5];
                this.images[Direction.UP.ordinal()] = ImageIO.read(new File("Sprites/Hero/Up.png"));
                this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("Sprites/Hero/Down.png"));
                this.images[Direction.RIGHT.ordinal()] = ImageIO.read(new File("Sprites/Hero/Right.png"));
                this.images[Direction.LEFT.ordinal()] = ImageIO.read(new File("Sprites/Hero/Left.png"));
                this.images[Direction.NONE.ordinal()] = ImageIO.read(new File("Sprites/Hero/None.png"));
                break ;
            case "enemy_1" :
                this.images = new Image[1];
                this.images[0] = ImageIO.read(new File("Sprites/type_" + levelType + "/Enemy_1.png")) ;
                break ;
            case "enemy_2" :
                this.images = new Image[1];
                this.images[0] = ImageIO.read(new File("Sprites/type_" + levelType + "/Enemy_2.png")) ;
                break ;
            case "amoeba" :
                this.images = new Image[1];
                this.images[0] = ImageIO.read(new File("Sprites/type_" + levelType + "/Amoeba.png")) ;
                break ;
            case "boulder" :
                this.images = new Image[1];
                this.images[0] = ImageIO.read(new File("Sprites/type_" + levelType + "/Boulder.png")) ;
                break ;
            case "diamond" :
                this.images = new Image[1];
                this.images[0] = ImageIO.read(new File("Sprites/type_" + levelType + "/Diamond.png")) ;
                break ;
            default :
                break;
        }
    }

    /**
     * Allows to read the Direction
     * @return Direction
     */
    @Override
    public String getDirection() {
        return this.direction.toString();
    }

    /**
     * Defines the different Direction
     * @param direction
     */
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
                break;
        }
    }

    /**
     * Allows to know the position X
     * @return
     */
    @Override
    public int getPositionX() {
        return this.position.getX();
    }

    /**
     * Allows to know the position Y
     * @return
     */
    @Override
    public int getPositionY() {
        return this.position.getY();
    }

    /**
     * Allows to know the position X Max
     * @return
     */
    @Override
    public int getPositionXMax() {
        return 0;
    }

    /**
     * Allows to know the position Y Max
     * @return
     */
    @Override
    public int getPositionYMax() {
        return 0;
    }

    /**
     * Allows to know the Width Dimension
     * @return
     */
    @Override
    public int getDimensionWidth() {
        return this.dimension.getWidth();
    }

    /**
     * Allows to know the Height Dimension
     * @return
     */
    @Override
    public int getDimensionHeight() {
        return this.dimension.getHeight();
    }

    /**
     * Allows to know where the mobile is going
     * @return the Height and Width
     */
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

    /**
     * Allows to know where the mobile is going
     * @return the Height and Width
     */
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
    public int getProperID() {
        return this.properID ;
    }

    /**
     * Allows to know the image associate with the position
     * @return
     */
    @Override
    public Image getImage() {
        if (this.getClass() == this.boulderDashModel.getPlayer().getClass()) {
            return this.images[this.direction.ordinal()];
        }
        else {
            return this.images[0] ;
        }
    }

    /**
     * Know the position in the Area
     * @param area
     */
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
    public boolean isRemovable () {
        return false ;
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public boolean isObject() {
        return false;
    }

    public boolean clockWiseMove () {return false;}
}
