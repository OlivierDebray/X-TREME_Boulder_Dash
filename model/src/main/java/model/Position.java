package model;

/**
 * Created by Théo on 16/06/2017.
 */
public class Position {
    private int x;
    private int y;
    private int xMax = 1;
    private int yMax = 1;


    public Position(final int X, final int Y){
        this.x = x;
        this.y = y;
    }

    public Position(final Position position){
        this(position.getX(), position.getY());
    }

    public void setX(int posX){
        this.x = x;
    }

    public int getX(){
        return this.x;
    }

    public void setY(int posY){
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
