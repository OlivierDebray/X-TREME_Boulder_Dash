package main;

import controller.BoulderDashController;
import model.BoulderDashModel;
import view.BoulderDashView;
import view.GraphicsBuilder;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public class XTremeBoulderDash {
    public static void main (String[] args) {
        final BoulderDashModel boulderDashModel = new BoulderDashModel(1 , 1);

        boulderDashModel.buildArea(30 , 30);

        final BoulderDashController boulderDashController = new BoulderDashController(boulderDashModel);
        final BoulderDashView boulderDashView = new BoulderDashView(boulderDashController, boulderDashModel, boulderDashModel);
        boulderDashController.setViewSystem(boulderDashView);

        boulderDashController.play();
    }
}
