package model;

import contract.IArea;

import java.awt.*;

/**
 * Created by Théo on 16/06/2017.
 */

public class Map implements IArea {
    private Dimension dimension;

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
