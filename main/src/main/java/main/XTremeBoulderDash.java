package main;

import controller.BoulderDashController;
import model.BoulderDashModel;
import view.BoulderDashView;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public class XTremeBoulderDash {
    private static int ZOOM = 2 ;

    public static void main (String[] args) {

        final BoulderDashModel boulderDashModel = new BoulderDashModel(1 , 2 , ZOOM);

        boulderDashModel.buildArea(25 , 25);

        final BoulderDashController boulderDashController = new BoulderDashController(boulderDashModel);
        final BoulderDashView boulderDashView = new BoulderDashView(boulderDashController, boulderDashModel, boulderDashModel , ZOOM);
        boulderDashController.setViewSystem(boulderDashView);
        boulderDashController.play();
    }
}
