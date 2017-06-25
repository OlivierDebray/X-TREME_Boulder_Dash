package model;

/**
 * Created by Théo on 16/06/2017.
 */

public class Dimension {
    private int width;
    private int height;

    public Dimension (int width ,int height) {
        try {
            this.setWidth(width);
            this.setHeight(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Dimension(final Dimension dimension){
        this(dimension.getWidth(), dimension.getHeight());
    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width) throws Exception {
        if (width < 0)
            throw new Exception("Dimension value should not be negative !") ;
        this.width = width;
    }

    public int getHeight(){
        return this.height ;
    }

    public void setHeight(int height) throws Exception {
        if (height < 0)
            throw new Exception("Dimension value should not be negative !") ;
        this.height = height;
    }
}
