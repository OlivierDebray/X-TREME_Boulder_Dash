package controller;

import contract.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */
public class BoulderDashController implements IOrderPerformer {

    private static int TIME_SLEEP = 90;
    private static int DIAMOND_NUMBER = 10 ;
    private int diamondCounter = 0 ;
    private boolean isGameOver = false;
    private IBoulderDashModel boulderDashModel;
    private IViewSystem viewSystem ;
    private boolean isActionCurrent = false ;

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
                    case "RIGHT":
                    case "DOWN":
                    case "LEFT":
                        direction = userOrder.getOrder() ;
                        break ;
                    case "START":
                        this.isActionCurrent = true ;
                        direction = this.boulderDashModel.getPlayer().getDirection() ;
                        break ;
                    case "START_RELEASED" :
                        this.isActionCurrent = false ;
                        direction = this.boulderDashModel.getPlayer().getDirection() ;
                        break ;
                    default:
                        direction = "NONE" ;
                        break ;
                }
                hero.setDirection(direction);
            }
        }
    }

    /**
     * Launch the game
     * @see IViewSystem
     */
    public void play() {
        this.gameLoop();
        if (diamondCounter == DIAMOND_NUMBER)
            this.viewSystem.displayMessage("All diamonds have been collected ! Great !");
        else
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

            initialMobiles.addAll(this.boulderDashModel.getMobiles());

            for (IMobile mobile : initialMobiles) {
                mobile.move() ;
                this.manageEntityCollision(mobile);
            }

            this.boulderDashModel.setMobilesHavesMoved() ;
        }
    }

    /**
     * Manage the collision between the current mobile (here known as entity) and the other mobiles (Mobile and Motionless objects)
     * @param entity
     * @see IMobile
     * @see IBoulderDashModel
     */
    private void manageEntityCollision(IMobile entity) {
        final ArrayList<IMobile> target = new ArrayList<IMobile>();
        final ArrayList<IMobile> motionlessTarget = new ArrayList<IMobile>();
        boolean isTargetHit = false ;
        boolean isTargetRemoved = false ;

        for (final IMobile mobile : this.boulderDashModel.getMobiles()) {
            if (this.isEntityOnMobile(mobile, entity)) {
                target.add(mobile) ;
            }
        }

        for (final IMobile mobile : target) {
            switch (mobile.getName()) {
                case "class model.Boulder" :
                    if (Objects.equals(entity.getName(), "class model.Hero")) {
                        mobile.setDirection(this.boulderDashModel.getPlayer().getDirection());
                        this.boulderDashModel.getPlayer().reverseMove(this.boulderDashModel.getPlayer().getDirection());
                        mobile.move();
                        this.manageEntityCollision(mobile);
                    }
                    if ((Objects.equals(entity.getName(), "class model.Boulder")) || (Objects.equals(entity.getName(), "class model.Diamond"))) {
                        entity.reverseMove(entity.getDirection());
                    }
                    break ;
                case "class model.Diamond" :
                    if ((Objects.equals(entity.getName(), "class model.Hero"))) {
                        this.boulderDashModel.removeMobile(mobile);
                        diamondCounter++ ;
                        if (this.isActionCurrent)
                            entity.reverseMove(entity.getDirection());
                    }
                    else if ((Objects.equals(entity.getName(), "class model.Boulder")) || (Objects.equals(entity.getName(), "class model.Diamond"))) {
                        entity.reverseMove(entity.getDirection());
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
                        if (Objects.equals(mobile.getName(), "clxass model.Hero")) {
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
                        if (Objects.equals(entity.getName(), "class model.Hero")) {
                            iterMotionless.remove();
                            if (!this.isActionCurrent)
                                entity.move();
                        }
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

        for (final IMobile mobileBoulderDiamond : this.boulderDashModel.getMobiles()) {
            if ((Objects.equals(mobileBoulderDiamond.getName(), "class model.Boulder")) || (Objects.equals(mobileBoulderDiamond.getName(), "class model.Diamond"))) {
                mobileBoulderDiamond.setDirection("DOWN") ;
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
        if ((entity.getPositionY() == mobile.getPositionY()) && (entity.getPositionX() == mobile.getPositionX())) {
            if (mobile.getProperID() != entity.getProperID()) {
                return true ;
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