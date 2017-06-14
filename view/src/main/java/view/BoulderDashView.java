package view;

import java.util.Observable;

/**
 * Created by Vincent on 14/06/2017.
 */

public class BoulderDashView implements IViewSystem , Runnable {
    private Observable observable ;
    private EventPerformer eventPerformer ;
    private GraphicsBuilder graphicsBuilder ;
    private GameFrame gameFrame ;

    public BoulderDashView (IOrderPerformer orderPerformer, IBoulderDashModel boulderDashModel, Observable observable ){
        this.observable = observable ;
        this.eventPerformer = new EventPerformer(orderPerformer) ;
        this.graphicsBuilder = new GraphicsBuilder(boulderDashModel) ;
    }

    @Override
    public void run() {

    }
}
