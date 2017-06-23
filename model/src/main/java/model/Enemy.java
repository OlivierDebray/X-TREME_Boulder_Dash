package model;

/**
 * Created by Théo on 15/06/2017.
 */

/**
 * This class gather the functionality of the Enemy
 */
public class Enemy extends Characters {
    private boolean doDropDiamonds ;
    private boolean clockWiseMove ;

<<<<<<< HEAD
    /**
     * Builder of Enemy
     * @param direction
     * @param position
     * @param dimension
     * @param speed
     * @param image
     * @see Direction
     * @see Position
     * @see Dimension
     */
    public Enemy(Direction direction, Position position, Dimension dimension, int speed, String image) {
        super(direction, position, dimension, speed, image);
=======
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
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
    }

    @Override
    public boolean hit() {
        return true;
    }

    @Override
    public boolean clockWiseMove () {return this.clockWiseMove;}
}
