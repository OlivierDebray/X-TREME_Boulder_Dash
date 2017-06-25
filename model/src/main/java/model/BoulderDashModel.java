package model;

import contract.IArea;
import contract.IBoulderDashModel;
import contract.IMobile;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 16/06/2017.
 */

public class BoulderDashModel extends Observable implements IBoulderDashModel {

    /**
     * @see Map
     */
    private Map map;

    /**
     * @see Level
     */
    private Level level ;
    private ArrayList<IMobile> mobiles;
    private ArrayList<IMobile> motionless;

    /**
     * @see IMobile
     */
    private IMobile hero ;

    private int levelType ;

    private int zoom ;

    /**
     * This builder Instantiate a new mobiles and motionless object
     * @param levelType
     * @param levelID
     * @param zoom
     */
    public BoulderDashModel(int levelType , int levelID , int zoom){
        this.mobiles = new ArrayList<>() ;
        this.motionless = new ArrayList<>() ;

        this.zoom = zoom ;
        this.levelType = levelType ;

        this.level = new Level(levelType , zoom) ;
        this.level.setBoulderDashModel(this);
        this.level.getLevel(levelID);
        this.level.buildLevel();
    }

    /**
     * this method build the Area with the Width and the Height
     * @param width
     * @param height
     * @see Map
     */
    @Override
    public void buildArea(int width , int height) {
        this.map = new Map(width*16 , height*16 , this.levelType) ;
    }


    @Override
    public IArea getArea() {
        return this.map ;
    }

    /**
     * This method add a new Mobile
     * @param mobile
     */
    @Override
    public void addMobile(IMobile mobile) {
        this.mobiles.add(mobile) ;
        mobile.setBoulderDashModel(this) ;
    }

    /**
     * This method remove this mobile
     * @param mobile
     */
    @Override
    public void removeMobile(IMobile mobile) {
        this.mobiles.remove(mobile) ;
    }

    /**
     * Allows to have the list of all mobiles
     * @return
     */
    @Override
    public ArrayList<IMobile> getMobiles() {
        return this.mobiles ;
    }

    /**
     * This method add a new motionless
     * @param motionless
     */
    @Override
    public void addMotionless (IMobile motionless) {
        this.motionless.add(motionless) ;
        motionless.setBoulderDashModel(this);
    }

    /**
     * This method remove this motionless
     * @param motionless
     */
    @Override
    public void removeMotionless (IMobile motionless) {
        this.motionless.remove(motionless) ;
    }

    /**
     * Allows to have the list of all motionless
     * @return motionless
     */
    @Override
    public ArrayList<IMobile> getMotionless () {
        return this.motionless ;
    }

    /**
     * This method set the movement of mobile
     */
    @Override
    public void setMobilesHavesMoved() {
        this.setChanged() ;
        this.notifyObservers() ;
    }

    /**
     * This method add a new player
     * @param hero
     * @see IMobile
     */
    public void addPlayer(IMobile hero) throws Exception {
        if (!Objects.equals(hero.getName(), "class model.Hero"))
            throw new Exception("Parameter should be an Hero object !") ;
        this.hero = hero ;
        hero.setBoulderDashModel(this);
        this.addMobile(this.hero);
    }

    @Override
    public IMobile getPlayer() {
        return this.hero ;
    }
}
