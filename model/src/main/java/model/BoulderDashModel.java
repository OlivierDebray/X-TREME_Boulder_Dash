package model;

import contract.IArea;
import contract.IBoulderDashModel;
import contract.IMobile;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Théo on 16/06/2017.
 */

/**
 * This class will be the Hearth of the program, where the most important methods will be defined or called
 */
public class BoulderDashModel extends Observable implements IBoulderDashModel {

    /**
     * @see Map
     */
    private Map map;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    /**
     * @see ArrayList<IMobile></IMobile>
     */
    private ArrayList<IMobile> mobiles;

    /**
     * @see ArrayList<Motionless></Motionless>
     */
    private ArrayList<Motionless> motionless;

    /**
     * Builder of BoulderDashModel
     */
    public BoulderDashModel(){
=======
    private Level level ;
    private ArrayList<IMobile> mobiles;
    private ArrayList<IMobile> motionless;
    private IMobile hero ;
    private int levelType ;

    public BoulderDashModel(int levelType , int levelID){
        this.mobiles = new ArrayList<>() ;
        this.motionless = new ArrayList<>() ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b

        this.levelType = levelType ;

=======
    private Level level ;
    private ArrayList<IMobile> mobiles;
    private ArrayList<IMobile> motionless;
    private IMobile hero ;
    private int levelType ;

    public BoulderDashModel(int levelType , int levelID){
        this.mobiles = new ArrayList<>() ;
        this.motionless = new ArrayList<>() ;

        this.levelType = levelType ;

>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
    private Level level ;
    private ArrayList<IMobile> mobiles;
    private ArrayList<IMobile> motionless;
    private IMobile hero ;
    private int levelType ;

    public BoulderDashModel(int levelType , int levelID){
        this.mobiles = new ArrayList<>() ;
        this.motionless = new ArrayList<>() ;

        this.levelType = levelType ;

>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
        this.level = new Level(levelType , levelID) ;
        this.level.setBoulderDashModel(this);
        //this.level.getLevel(levelID);
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        this.mobiles.add(mobile) ;
        mobile.setBoulderDashModel(this) ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
        this.mobiles.add(mobile) ;
        mobile.setBoulderDashModel(this) ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
        this.mobiles.add(mobile) ;
        mobile.setBoulderDashModel(this) ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }

    @Override
    public void removeMobile(IMobile mobile) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        this.mobiles.remove(mobile) ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
        this.mobiles.remove(mobile) ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
        this.mobiles.remove(mobile) ;
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
        this.setChanged() ;
        this.notifyObservers() ;
    }

    public void addPlayer(IMobile hero) {
        this.hero = hero ;
        hero.setBoulderDashModel(this);
        this.addMobile(this.hero);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }

    @Override
    public IMobile getPlayer() {
        return this.hero ;
    }
}
