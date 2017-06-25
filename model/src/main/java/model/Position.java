package model;

/**
 * Created by Théo on 16/06/2017.
 */

public class Position {
    private int x;
    private int y;
    private int xMax = 1;
    private int yMax = 1;


    public Position(int x, int y){
        try {
            this.setX(x);
            this.setY(y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Position(final Position position){
        this(position.getX(), position.getY());
    }

    public void setX(int x) {
        if (x < 0 || x > 25*16)
            try {
                throw new Exception("Position should not be out of map !") ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        this.x = x;
    }

    public int getX(){
        return this.x;
    }

    public void setY(int y ) {
        if (y < 0 || y > 25*16)
            try {
                throw new Exception("Position should not be out of map !") ;
            } catch (Exception e) {
                e.printStackTrace();
            }
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
