package model;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 16/06/2017.
 */

public class Position {
    private int x;
    private int y;
    private int xMax = 1;
    private int yMax = 1;

    /**
     * 1st Builder of Position
     * @param x
     * @param y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 2nd Builder of Position
     * @param position
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
