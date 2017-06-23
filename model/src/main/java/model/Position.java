package model;

/**
 * Created by Théo on 16/06/2017.
 */

public class Position {
    private int x;
    private int y;
    private int xMax = 1;
    private int yMax = 1;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    /**
     * Builder of Position
     * @param X
     * @param Y
     */
    public Position(final int X, final int Y){
=======

    public Position(int x, int y){
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======

    public Position(int x, int y){
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======

    public Position(int x, int y){
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
        this.x = x;
        this.y = y;
    }

    /**
     * @param position
     * @see Position
     */
    public Position(final Position position){
        this(position.getX(), position.getY());
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return this.x;
    }

    public void setY(int y ){
        this.y = y;
    }

    public int getY(){
        return this.y;
    }

    public void setXmax(int xMax){
        this.xMax = xMax;
    }

    public void setYmax(int yMax){
        this.yMax = yMax;
    }

}
