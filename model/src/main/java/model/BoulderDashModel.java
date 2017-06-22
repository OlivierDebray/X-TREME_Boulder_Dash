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
    private ArrayList<Motionless> motionless;
    private int levelType ;

    public BoulderDashModel(int levelType , int levelID){
        this.mobiles = new ArrayList<>() ;
        this.motionless = new ArrayList<>() ;
        this.levelType = levelType ;
        this.level = new Level(levelType , levelID) ;
        this.level.setBoulderDashModel(this);
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

    public void addMotionless (Motionless motionless) {
        this.motionless.add(motionless) ;
        motionless.setBoulderDashModel(this);
    }

    public void removeMotionless (Motionless motionless) {
        this.motionless.remove(motionless) ;
    }

    public ArrayList<Motionless> getMotionless () {
        return this.motionless ;
    }

    @Override
    public void setMobilesHavesMoved() {
        this.setChanged() ;
        this.notifyObservers() ;
    }

    @Override
    public IMobile getPlayer() throws Exception {
        for (IMobile mobile : mobiles) {
            if (mobile.getClass().toString() == "class model.hero") {
                return mobile ;
            }
            else {
                throw new Exception("Should return a mobile object corresponding to the hero object") ;
            }
        }
        return null ;
    }
}
