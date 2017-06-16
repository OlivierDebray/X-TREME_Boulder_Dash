package contract;

import java.util.ArrayList;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 * Made on 14/06/2017
 */

public interface IBoulderDashModel {
    void buildArea (Dimension dimension) ;
    IArea getArea () ;
    void addMobile (IMobile mobile) ;
    void removeMobile (IMobile mobile) ;
    ArrayList<IMobile> getMobiles () ;
    void setMobilesHavesMoved() ;
}