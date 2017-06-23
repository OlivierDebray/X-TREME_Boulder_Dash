package controller;

import contract.IBoulderDashModel;
import contract.IMobile;
import contract.IOrderPerformer;
import contract.IViewSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */
public class BoulderDashController implements IOrderPerformer {

    private static int TIME_SLEEP = 120;
    private static int DIAMOND_NUMBER = 10 ;
    private int diamondCounter = 0 ;
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
        if (diamondCounter == DIAMOND_NUMBER)
            this.viewSystem.displayMessage("All diamonds have been collected ! Great !");
        else
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
        final ArrayList<IMobile> motionlessTarget = new ArrayList<IMobile>();
        boolean isTargetHit = false ;
        boolean isTargetRemoved = false ;

        /*
        Voir si ca vaut pas le  coup de tout faire dans la partie gestion des entités, peut être que cela sera mieux de
        gérer les éléments qui se déplacent que ceux qui se font superposer
         */

        for (final IMobile mobile : this.boulderDashModel.getMobiles()) {
            if (this.isEntityOnMobile(mobile, entity)) {
                target.add(mobile) ;
            }
            if ((Objects.equals(mobile.getName(), "class model.Boulder")) || (Objects.equals(mobile.getName(), "class model.Diamond"))) {
                mobile.setDirection("DOWN") ;
            }
        }

        for (final IMobile mobile : target) {
            switch (mobile.getName()) {
                case "class model.Boulder" :
                    if (Objects.equals(entity.getName(), "class model.Hero")) {
                        mobile.setDirection(this.boulderDashModel.getPlayer().getDirection());
                        this.boulderDashModel.getPlayer().reverseMove(this.boulderDashModel.getPlayer().getDirection());
                        mobile.move();
                        mobile.setDirection("NONE");
                    }
                    if ((Objects.equals(entity.getName(), "class model.Boulder")) || (Objects.equals(entity.getName(), "class model.Diamond"))) {
                        entity.reverseMove(entity.getDirection());
                        System.out.println(mobile.getName());
                    }
                    break ;
                case "class model.Diamond" :
                    if ((Objects.equals(entity.getName(), "class model.Hero"))) {
                        this.boulderDashModel.removeMobile(mobile);
                        diamondCounter++ ;
                    }
                    else if ((Objects.equals(entity.getName(), "class model.Boulder")) || (Objects.equals(entity.getName(), "class model.Diamond"))) {
                        entity.reverseMove(entity.getDirection());
                        System.out.println(mobile.getName()) ;
                    }
                    break ;
                case "class model.Enemy" :
                    if ((Objects.equals(entity.getName(), "class model.Boulder")) || (Objects.equals(entity.getName(), "class model.Diamond"))) {
                        this.boulderDashModel.removeMobile(mobile);
                    }
                    if ((Objects.equals(entity.getName(), "class model.Hero"))) {
                        isTargetHit = isTargetHit || mobile.hit() ;
                    }
                    break ;
                default :
                    break ;
            }
            if ((Objects.equals(mobile.getName(), "class model.Hero")) || (Objects.equals(mobile.getName(), "class model.Enemy"))) {
                switch (entity.getName()) {
                    case "class model.Boulder" :
                    case "class model.Diamond" :
                        if (Objects.equals(entity.getDirection(), "DOWN")) {
                            if (Objects.equals(mobile.getName(), "class model.Hero"))
                                this.isGameOver = true ;
                            this.boulderDashModel.removeMobile(mobile);
                        }
                        break ;
                    case "class model.Enemy" :
                        if (Objects.equals(mobile.getName(), "class model.Hero")) {
                            this.boulderDashModel.removeMobile(mobile);
                            this.isGameOver = true ;
                        }
                    default :
                        break ;
                }
            }
        }

        Iterator<IMobile> iterMotionless = this.boulderDashModel.getMotionless().iterator();
        while(iterMotionless.hasNext()) {
            IMobile currentMotionless = iterMotionless.next() ;
            if (this.isEntityOnMobile(currentMotionless , entity)) {
                switch (currentMotionless.getName()) {
                    case "dirt" :
                        if (Objects.equals(entity.getName(), "class model.Hero"))
                            iterMotionless.remove();
                        else {
                            entity.reverseMove(entity.getDirection());
                            entity.setDirection("NONE");
                        }
                    case "wall" :
                        entity.reverseMove(entity.getDirection());
                }
            }
        }

        for (final IMobile motionless : motionlessTarget) {
            isTargetRemoved = isTargetRemoved || motionless.isRemovable() ;
        }

        if (isTargetHit) {
            this.boulderDashModel.removeMobile(entity) ;

            if (entity.getClass() == this.boulderDashModel.getPlayer().getClass()) {
                this.isGameOver = true ;
            }
        }

        if (isTargetRemoved) {
            this.boulderDashModel.removeMotionless(entity);
        }

        if (diamondCounter == DIAMOND_NUMBER) {
            this.isGameOver = true ;
        }
    }

    private boolean isEntityOnMobile(IMobile mobile, IMobile entity) {
        if ((entity.getPositionY() == mobile.getPositionY()) && (entity.getPositionX() == mobile.getPositionX())) {
            if (mobile.getProperID() != entity.getProperID()) {
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