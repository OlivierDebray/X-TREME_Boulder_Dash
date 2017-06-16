package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Théo on 16/06/2017.
 */
public class BoulderDashModel extends Observable implements IBoulderDashModel {
    private Map map;
    private  ArrayList<IMobile> mobiles;
    private  ArrayList<Motionless> motionless;

    public BoulderDashModel(){

    }

}
