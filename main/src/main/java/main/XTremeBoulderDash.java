package main;

import controller.BoulderDashController;
import model.BoulderDashModel;
import view.BoulderDashView;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 16/06/2017
 */

public class XTremeBoulderDash {
    public static void main (String[] args) {
        final BoulderDashModel boulderDashModel = new BoulderDashModel();

        /*
        Créer ici de quoi instancier tous les éléments visibles du jeu (héros, ennemis, map, ...)
         */

        final BoulderDashController boulderDashController = new BoulderDashController(boulderDashModel);
        final BoulderDashView dogfightView = new BoulderDashView(boulderDashController, boulderDashModel, boulderDashModel);
        boulderDashController.setViewSystem(dogfightView);
        boulderDashController.play();
    }
}
