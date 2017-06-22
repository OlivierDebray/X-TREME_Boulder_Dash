package contract;

import java.util.ArrayList;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 * Made on 14/06/2017
 */

public interface IBoulderDashModel {
    void buildArea (int width , int height) ;
    IArea getArea () ;
    void addMobile (IMobile mobile) ;
    void removeMobile (IMobile mobile) ;
    ArrayList<IMobile> getMobiles () ;
    void addMotionless (IMobile mobile) ;
    void removeMotionless (IMobile mobile) ;
    ArrayList<IMobile> getMotionless () ;
    void setMobilesHavesMoved() ;
    IMobile getPlayer () throws Exception;
}
