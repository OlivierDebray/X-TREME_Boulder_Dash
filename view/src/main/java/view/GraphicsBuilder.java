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

/**
 * This class allows to create and show all graphics of the Map
 */
public class GraphicsBuilder implements IGraphicsBuilder {

    /**
     * @see BufferedImage
     */
    private BufferedImage emptyMap;

    /**
     * @see IBoulderDashModel
     */
    private IBoulderDashModel boulderDashModel;

    /**
     * Builder of GraphicsBuilder
     * @param boulderDashModel
     * @see IBoulderDashModel
     */
    public GraphicsBuilder (IBoulderDashModel boulderDashModel) {
        this.boulderDashModel = boulderDashModel;
        this.buildEmptyMap();
    }

    /**
     * @param graphics
     * @param observer
     * @see Graphics
     * @see ImageObserver
     */
    @Override
    public void applyModelToGraphic(Graphics graphics, ImageObserver observer) {
        graphics.drawImage(this.emptyMap , 0, 0, observer);

        for (final IMobile mobile : this.boulderDashModel.getMobiles()) {
            this.drawMobile(mobile, graphics, observer);
        }
    }

    /**
     * @return boulderDashModel.getArea().getDimensionWidth()
     */
    @Override
    public int getGlobalWidth() {
        return this.boulderDashModel.getArea().getDimensionWidth() ;
    }

    /**
     * @return boulderDashModel.getArea().getDimensionHeight()
     */
    @Override
    public int getGlobalHeight() {
        return this.boulderDashModel.getArea().getDimensionHeight() ;
    }

    /**
     * This method allows to insert the Map
     */
    public void buildEmptyMap() {
        this.emptyMap = new BufferedImage(this.boulderDashModel.getArea().getDimensionWidth(), this.boulderDashModel.getArea().getDimensionHeight(), BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics = (Graphics2D) this.emptyMap.getGraphics();
        graphics.drawImage(this.boulderDashModel.getArea().getImage(), 0, 0, this.boulderDashModel.getArea().getDimensionWidth(), this.boulderDashModel.getArea().getDimensionHeight(), null);
    }

    /**
     * This method allows to create the Mobile
     * @param mobile
     * @param graphics
     * @param observer
     * @see IMobile
     * @see Graphics
     * @see ImageObserver
     */
    public void drawMobile (IMobile mobile, Graphics graphics, ImageObserver observer){

    }
}
