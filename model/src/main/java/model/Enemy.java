package model;

/**
 * Created by Théo on 15/06/2017.
 */
public class Enemy extends Characters {
    private boolean doDropDiamonds ;
    private boolean clockWiseMove ;

    public Enemy(Direction direction, Position position, Dimension dimension, int levelType , String enemyType) {
        super(direction, position, dimension, "/Sprites/type_"+ levelType +"/"+ enemyType +".png");

        switch (enemyType) {
            case "Enemy_1" :
                this.doDropDiamonds = false ;
                this.clockWiseMove = true ;
            case "Enemy_2" :
                this.doDropDiamonds = true ;
                this.clockWiseMove = false ;
            case "Amoeba" :
                this.doDropDiamonds = true ;
                this.clockWiseMove = true ;
        }
    }
}
