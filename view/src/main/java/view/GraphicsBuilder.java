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

    @Override
    public void applyModelToGraphic(Graphics graphics, ImageObserver observer) {
        graphics.drawImage(this.emptyMap , 0, 0, observer);

        for (final IMobile mobile : this.boulderDashModel.getMobiles()) {
            this.drawMobile(mobile, graphics, observer);
        }
    }

    @Override
    public int getGlobalWidth() {
        return this.boulderDashModel.getArea().getDimensionWidth() ;
    }

    @Override
    public int getGlobalHeight() {
        return this.boulderDashModel.getArea().getDimensionHeight() ;
    }

    public void buildEmptyMap() {
        this.emptyMap = new BufferedImage(this.boulderDashModel.getArea().getDimensionWidth(), this.boulderDashModel.getArea().getDimensionHeight(), BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics = (Graphics2D) this.emptyMap.getGraphics();
        graphics.drawImage(this.boulderDashModel.getArea().getImage(), 0, 0, this.boulderDashModel.getArea().getDimensionWidth(), this.boulderDashModel.getArea().getDimensionHeight(), null);
    }

    public void drawMobile (IMobile mobile, Graphics graphics, ImageObserver observer){

    }
}
