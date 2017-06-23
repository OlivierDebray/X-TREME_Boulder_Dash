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

    }

    @Override
    public void buildArea(int width , int height) {
        Dimension dimension = new Dimension(width , height) ;
    }

    @Override
    public IArea getArea() {
        return null;
    }

    @Override
    public void addMobile(IMobile mobile) {
    }

    @Override
    public void removeMobile(IMobile mobile) {
    }

    @Override
    public ArrayList<IMobile> getMobiles() {
        return null;
    }

    @Override
    public void setMobilesHavesMoved() {
    }

    @Override
    public IMobile getPlayer() {
        return null;
    }
}
