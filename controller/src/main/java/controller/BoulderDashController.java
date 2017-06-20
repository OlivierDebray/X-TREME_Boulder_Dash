package controller;

import contract.*;

import java.util.ArrayList;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */
public class BoulderDashController implements IOrderPerformer {

    private static int TIME_SLEEP = 30;
    private boolean isGameOver = false;
    private IBoulderDashModel boulderDashModel;
    private IViewSystem viewSystem ;

    /**
     * Set a new instance of the Controller
     * @param boulderDashModel
     *      Tha current Model instance of the game
     * @see IBoulderDashModel
     */
    public BoulderDashController (IBoulderDashModel boulderDashModel) {
        this.boulderDashModel = boulderDashModel ;
    }

    /**
     * @param stringUserOrder
     *      The string corresponding to the user's order
     * @throws Exception when direction is set
     * @see IBoulderDashModel
     * @see UserOrder
     */
    public void orderPerform (String stringUserOrder) throws Exception {
        UserOrder userOrder = new UserOrder(stringUserOrder) ;
        if (userOrder != null) {
            final IMobile hero = this.boulderDashModel.getPlayer() ;
            if (hero != null) {
                String direction ;
                switch (userOrder.getOrder()) {
                    case "UP":
                        direction = userOrder.getOrder();
                        break ;
                    case "RIGHT":
                        direction = userOrder.getOrder();
                        break ;
                    case "DOWN":
                        direction = userOrder.getOrder();
                        break ;
                    case "LEFT":
                        direction = userOrder.getOrder();
                        break ;
                    case "A":
                        direction = userOrder.getOrder();
                        break ;
                    case "B":
                        direction = userOrder.getOrder();
                        break ;
                    case "START":
                        direction = userOrder.getOrder();
                        break ;
                    default:
                        direction = "NONE" ;
                        break ;
                }
                hero.setDirection(direction);
                throw new Exception(direction) ;
            }
        }
    }

    /**
     * Launch the game
     * @see IViewSystem
     */
    public void play() {
        this.gameLoop();
        this.viewSystem.displayMessage("Game Over !");
        this.viewSystem.closeAll();
    }

    /**
     * The game loop, running while the player hasn't died or won
     * @see IBoulderDashModel
     */
    public void gameLoop(){
        while (!this.isGameOver) {
            try {
                Thread.sleep(TIME_SLEEP) ;
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt() ;
            }

            final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>() ;

            /*
             *  Version intiale
             *
             *  for (IMobile mobile : this.boulderDashModel.getMobiles()) {
             *      initialMobiles.add(mobile) ;
             *  }
             */

            /*
             * Version conseillé par IntelliJ
             */
            initialMobiles.addAll(this.boulderDashModel.getMobiles());

            for (IMobile mobile : initialMobiles) {
                mobile.move() ;
                this.manageEntityCollision(mobile);
            }

            this.boulderDashModel.setMobilesHavesMoved() ;
        }
    }

    /**
     * Manage the collision between the current mobile and the other mobiles
     * @param entity
     * @see IMobile
     * @see IBoulderDashModel
     */
    private void manageEntityCollision(IMobile entity) {
        final ArrayList<IMobile> target = new ArrayList<IMobile>();
        boolean isTargetHit = false ;

        for (final IMobile mobile : this.boulderDashModel.getMobiles()) {
            if (this.isEntityOnMobile(mobile, entity)) {
                target.add(mobile) ;
            }
        }

        for (final IMobile mobile : target) {
            isTargetHit = isTargetHit || mobile.hit() ;
        }

        if (isTargetHit) {
            this.boulderDashModel.removeMobile(entity) ;

            if (entity.getClass().toString() == "class model.hero") {
                this.isGameOver = true ;
            }
        }
    }

    /**
     * Calculate if two mobiles are superposed
     * @param mobile
     * @param entity
     * @see IMobile
     * @return if yes or no the mobiles are superposed
     */
    private boolean isEntityOnMobile(IMobile mobile, IMobile entity) {
        if (((entity.getPositionX() / entity.getWidth()) >= (mobile.getPositionX() / entity.getWidth()))
                && ((entity.getPositionX() / entity.getWidth()) <= ((mobile.getPositionX() + mobile.getWidth()) / entity.getWidth()))) {
            if (((entity.getPositionY() / entity.getHeight()) >= (mobile.getPositionY() / entity.getHeight()))
                    && ((entity.getPositionY() / entity.getHeight()) <= ((mobile.getPositionY() + mobile.getHeight()) / entity.getHeight()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Set the ViewSystem instance of the controller to the one in parameter
     * @param viewSystem
     * @see IViewSystem
     */
    public void setViewSystem (IViewSystem viewSystem){
        this.viewSystem = viewSystem ;
    }

    /**
     * Get the ViewSystem instance of the controller
     * @see IViewSystem
     * @return the ViewSystem instance
     */
    public IViewSystem getViewSystem () {
        return this.viewSystem ;
    }
}