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
public class BoulderDashController implements IOrderPerformer {

    private static int TIME_SLEEP = 30;
    private boolean isGameOver = false;
    private IBoulderDashModel boulderDashModel;
    private IViewSystem viewSystem ;

    public BoulderDashController (IBoulderDashModel boulderDashModel) {
        this.boulderDashModel = boulderDashModel ;
    }

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
            }
        }
    }

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

    private boolean isEntityOnMobile(IMobile mobile, IMobile entity) {
        if ((entity.getPositionY() == mobile.getPositionY()) && (entity.getPositionX() == mobile.getPositionX())) {
            if (mobile.getClass() != entity.getClass()) {
                return true ;
            }
        }
        return false;
    }

    public void setViewSystem (IViewSystem viewSystem){
        this.viewSystem = viewSystem ;
    }

    public IViewSystem getViewSystem () {
        return this.viewSystem ;
    }
}