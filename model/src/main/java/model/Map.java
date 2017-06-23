package model;

import contract.IArea;

import java.awt.*;

/**
 * Created by Théo on 16/06/2017.
 */

/**
 * This class allows to include the Map
 */
public class Map implements IArea {

    /**
     * @see Dimension
     */
    private Dimension dimension;

    /**
     * Builder of Map
     * @param dimension
     * @see Dimension
     */
    public Map(final Dimension dimension){
    }

    @Override
    public int getDimensionWidth() {
        return 0;
    }

    @Override
    public int getDimensionHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public Image getImage() {
        return null;
    }
}
