package view;

import contract.IBoulderDashModel;
import contract.IGraphicsBuilder;
import contract.IMobile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * Created by Vincent on 14/06/2017.
 */

public class GraphicsBuilder implements IGraphicsBuilder {

    private BufferedImage emptyMap;
    private IBoulderDashModel boulderDashModel;

    public GraphicsBuilder (IBoulderDashModel boulderDashModel) {
        this.boulderDashModel = boulderDashModel;
        this.buildEmptyMap();
    }

    public void buildEmptyMap() {

    }

    public void drawMobile (IMobile mobile, Graphics graphics, ImageObserver observer){

    }

    @Override
    public void applyModelToGraphic() {

    }

    @Override
    public void getGlobalWidth() {

    }

    @Override
    public void getGlobalHeight() {

    }
}
