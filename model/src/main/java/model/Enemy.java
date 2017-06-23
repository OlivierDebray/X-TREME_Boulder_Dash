package model;

/**
 * Created by Théo on 15/06/2017.
 */
public class Enemy extends Characters {
    private boolean doDropDiamonds ;
    private boolean clockWiseMove ;

    public Enemy(Direction direction, Position position, Dimension dimension, int levelType , String enemyType , int properID) {
        super(direction, position, dimension, enemyType , levelType , properID);

        switch (enemyType) {
            case "enemy_1" :
                this.doDropDiamonds = false ;
                this.clockWiseMove = true ;
                break ;
            case "enemy_2" :
                this.doDropDiamonds = true ;
                this.clockWiseMove = false ;
                break ;
            case "amoeba" :
                this.doDropDiamonds = true ;
                this.clockWiseMove = true ;
                break ;
        }
    }

    @Override
    public boolean isEnemy() {
        return true;
    }

    @Override
    public boolean hit() {
        return true;
    }

    @Override
    public boolean clockWiseMove () {return this.clockWiseMove;}
}
