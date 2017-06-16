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
    private ArrayList<IMobile> mobiles;
    private ArrayList<Motionless> motionless;

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
}
