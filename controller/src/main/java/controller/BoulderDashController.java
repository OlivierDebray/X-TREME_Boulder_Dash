package controller;

import contract.IBoulderDashModel;
import contract.IOrderPerformer;
import contract.IUserOrder;
import contract.IViewSystem;

/**
 * Created by Vincent on 16/06/2017.
 */
public class BoulderDashController implements IOrderPerformer {

    private static int TIME_SLEEP = 30;
    private IBoulderDashModel boulderDashModel;
    private boolean isGameOver = false;
    private IViewSystem viewSystem ;

    public BoulderDashController (IBoulderDashModel boulderDashModel){

    }

    public void orderPerform (IUserOrder userOrder) {

    }

    public void play() {

    }

    public void gameLoop(){

    }

    public void setViewSystem (IViewSystem viewSystem){

    }
}