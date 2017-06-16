package model;

/**
 * Created by Théo on 16/06/2017.
 */

public class Dimension {
    private int width;
    private int height;

    public Dimension(final Dimension dimension){

    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return this.height ;
    }

    public void setHeight(int height){
        this.height = height;
    }
}
