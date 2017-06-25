package view;

import contract.IBoulderDashModel;
import contract.IGraphicsBuilder;
import contract.IMobile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * @author Vincent Alayrac vincent.alayrac@viacesi.fr
 *         Made on 14/06/2017.
 */

public class GraphicsBuilder implements IGraphicsBuilder {

    private BufferedImage emptyMap;
    private IBoulderDashModel boulderDashModel;
    private int zoom ;

    /**
     * This Builder instantiate a new boulderDashModel object
     * @param boulderDashModel
     * @param zoom
     * @see IBoulderDashModel
     */
    public GraphicsBuilder (IBoulderDashModel boulderDashModel , int zoom) {
        this.boulderDashModel = boulderDashModel;
        this.zoom = zoom ;
        this.buildEmptyMap();
    }

    /**
     * Allows to apply the graphics model settings
     * @see Graphics
     * @see ImageObserver
     */
    @Override
    public void applyModelToGraphic(Graphics graphics, ImageObserver observer) {
        graphics.drawImage(this.emptyMap , 0, 0, observer);

        for (final IMobile mobile : this.boulderDashModel.getMobiles()) {
            this.drawMobile(mobile, graphics, observer);
        }
        for (final IMobile motionless : this.boulderDashModel.getMotionless()) {
            this.drawMobile(motionless, graphics, observer);
        }
    }

    /**
     * @return the Width of the Area
     */
    @Override
    public int getGlobalWidth() {
        return this.boulderDashModel.getArea().getDimensionWidth() ;
    }

    /**
     * @return the Height of the Area
     */
    @Override
    public int getGlobalHeight() {
        return this.boulderDashModel.getArea().getDimensionHeight() ;
    }

    /**
     * Allows to create the empty map
     */
    public void buildEmptyMap() {
        this.emptyMap = new BufferedImage(this.boulderDashModel.getArea().getDimensionWidth() * zoom, this.boulderDashModel.getArea().getDimensionHeight() * zoom, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics = (Graphics2D) this.emptyMap.getGraphics();
        graphics.drawImage(this.boulderDashModel.getArea().getImage(), 0, 0, this.boulderDashModel.getArea().getDimensionWidth() * zoom, this.boulderDashModel.getArea().getDimensionHeight() * zoom, null);
    }

    /**
     * Allows to draw mobile object
     * @param mobile
     * @param graphics
     * @param observer
     * @see IMobile
     * @see Graphics
     * @see ImageObserver
     */
    public void drawMobile (IMobile mobile, Graphics graphics, ImageObserver observer){
        final BufferedImage imageMobile = new BufferedImage(mobile.getWidth(), mobile.getHeight(), Transparency.TRANSLUCENT);
        final Graphics graphicsMobile = imageMobile.getGraphics();

        graphicsMobile.drawImage(mobile.getImage(), 0, 0, mobile.getWidth(), mobile.getHeight(), observer);
        graphics.drawImage(imageMobile, mobile.getPositionX() * zoom, mobile.getPositionY() * zoom, observer);
    }
}
