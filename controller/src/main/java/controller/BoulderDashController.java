package controller;

import contract.IBoulderDashModel;
import contract.IMobile;
import contract.IOrderPerformer;
import contract.IViewSystem;

import java.util.ArrayList;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

/**
 * This class manage the data of BoulderDash
 */
public class BoulderDashController implements IOrderPerformer {

    private static int TIME_SLEEP = 30;
    private boolean isGameOver = false;
    private IBoulderDashModel boulderDashModel;
    private IViewSystem viewSystem ;

    /**
     * Builder of BoulderDashController
     * When constructing a boulderDashController object, the boulderDashModel matches the boulderDashModel
     * @param boulderDashModel
     * @see IBoulderDashModel
     */
    public BoulderDashController (IBoulderDashModel boulderDashModel) {
        this.boulderDashModel = boulderDashModel ;
    }


    /**
     * Method of moving the player
     * @param stringUserOrder
     * @throws Exception
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
     * This method allows to activate the end of the game
     */
    public void play() {
        this.gameLoop();
        this.viewSystem.displayMessage("Game Over !");
        this.viewSystem.closeAll();
    }


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
     * Method that manages collisions
     * @param entity
     * @see ArrayList<IMobile></IMobile>
     * @see IMobile
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
     *This method makes it possible to know the position of the mobile
     * @param mobile
     * @param entity
     * @return false
     * @see IMobile
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
     * This method allows to define the ViewSystem
     * @param viewSystem
     * @see IViewSystem
     */
    public void setViewSystem (IViewSystem viewSystem){
        this.viewSystem = viewSystem ;
    }

    /**
     * This method allows to return the ViewSystem
     * @return viewSystem
     * @see IViewSystem
     */
    public IViewSystem getViewSystem () {
        return this.viewSystem ;
    }
}