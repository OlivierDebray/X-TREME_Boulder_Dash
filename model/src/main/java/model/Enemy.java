package model;

/**
 * @author Théo Robineau théo.robineau@viacesi.fr
 *         Made on 15/06/2017.
 */
public class Enemy extends Characters {
    private boolean doDropDiamonds ;
    private boolean clockWiseMove ;

    /**
     * Builder of Enemy
     * @param direction
     * @param position
     * @param dimension
     * @param levelType
     * @param enemyType
     * @param properID
     * @see Direction
     * @see Position
     * @see Dimension
     * */
    public Enemy(Direction direction, Position position, Dimension dimension, int levelType , String enemyType , int properID) {
        super(direction, position, dimension, enemyType , levelType , properID);

        /**
         * Describes Enemy's moves
         */
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

    /**
     * @return enemy exist or not
     */
    @Override
    public boolean isEnemy() {
        return true;
    }

    /**
     * @return if enemy touch the player
     */
    @Override
    public boolean hit() {
        return true;
    }

    /**
     * @return if the enemy has a circular trajectory
     */
    @Override
    public boolean clockWiseMove () {return this.clockWiseMove;}
}
