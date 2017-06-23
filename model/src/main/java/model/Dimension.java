package model;

/**
 * Created by Théo on 16/06/2017.
 */

public class Dimension {
    private int width;
    private int height;

<<<<<<< HEAD
<<<<<<< HEAD
    /**
     * Builder of Dimension
     * @param width
     * @param height
     */
    public Dimension (final int width , final int height) {
        this.setWidth(width);
        this.setHeight(height);
=======
    public Dimension (int width ,int height) {
        this.width = width;
        this.height = height;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
    public Dimension (int width ,int height) {
        this.width = width;
        this.height = height;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }

    /**
     * 2nd Builder of Dimension
     * @param dimension
     * @see Dimension
     */
    public Dimension(final Dimension dimension){
        this(dimension.getWidth(), dimension.getHeight());
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
