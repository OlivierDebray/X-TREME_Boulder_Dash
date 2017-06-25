package model;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 16/06/2017.
 */

public class Dimension {
    private int width;
    private int height;

    /**
     * 1st builder of Dimension
     * @param width
     * @param height
     */
    public Dimension (int width ,int height) {
        try {
            this.setWidth(width);
            this.setHeight(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2nd builder of Dimension
     * @param dimension
     * @see Dimension
     */
    public Dimension(final Dimension dimension){
        this(dimension.getWidth(), dimension.getHeight());
    }

    /**
     * Allows to read, to return the Width
     * @return width
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * Defines the Width
     * @param width
     */
    public void setWidth(int width) throws Exception {
        if (width < 0)
            throw new Exception("Dimension value should not be negative !") ;
        this.width = width;
    }

    /**
     * Allows to read, to return the Height
     * @return height
     */
    public int getHeight(){
        return this.height ;
    }

    /**
     * Defines the Height
     * @param height
     */
    public void setHeight(int height) throws Exception {
        if (height < 0)
            throw new Exception("Dimension value should not be negative !") ;
        this.height = height;
    }
}
