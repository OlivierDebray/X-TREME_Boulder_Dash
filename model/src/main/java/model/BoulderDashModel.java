package model;

import contract.IArea;
import contract.IBoulderDashModel;
import contract.IMobile;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Théo on 16/06/2017.
 */

public class BoulderDashModel extends Observable implements IBoulderDashModel {
    private Map map;
    private Level level ;
    private ArrayList<IMobile> mobiles;
    private ArrayList<IMobile> motionless;
    private IMobile hero ;
    private int levelType ;
    private int zoom ;

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

    @Override
    public void buildArea(int width , int height) {
        this.map = new Map(width*16 , height*16 , this.levelType) ;
    }

    @Override
    public IArea getArea() {
        return this.map ;
    }

    @Override
    public void addMobile(IMobile mobile) {
        this.mobiles.add(mobile) ;
        mobile.setBoulderDashModel(this) ;
    }

    @Override
    public void removeMobile(IMobile mobile) {
        this.mobiles.remove(mobile) ;
    }

    @Override
    public ArrayList<IMobile> getMobiles() {
        return this.mobiles ;
    }

    @Override
    public void addMotionless (IMobile motionless) {
        this.motionless.add(motionless) ;
        motionless.setBoulderDashModel(this);
    }

    @Override
    public void removeMotionless (IMobile motionless) {
        this.motionless.remove(motionless) ;
    }

    @Override
    public ArrayList<IMobile> getMotionless () {
        return this.motionless ;
    }

    @Override
    public void setMobilesHavesMoved() {
        this.setChanged() ;
        this.notifyObservers() ;
    }

    public void addPlayer(IMobile hero) {
        this.hero = hero ;
        hero.setBoulderDashModel(this);
        this.addMobile(this.hero);
    }

    @Override
    public IMobile getPlayer() {
        return this.hero ;
    }
}
