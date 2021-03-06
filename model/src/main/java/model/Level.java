package model;

import model.dao.QueryLevel;

import java.sql.SQLException;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 21/06/2017
 */

public class Level {

    /**
     * @see BoulderDashModel
     */
    private BoulderDashModel boulderDashModel ;
    private int levelType ;
    private char[][] levelText ;
    private int zoom ;

    Level(int levelType , int zoom) {
        this.zoom = zoom ;
        this.levelType = levelType ;
        this.levelText = new char[30][30] ;
    }

    /**
     * This getter allows to read the Map save in the BDD BoulderDash
     * @param levelID
     */
    public void getLevel(int levelID) {
        QueryLevel queryLevel = new QueryLevel();
        String map = "";
        try {
            map = queryLevel.getQuerySelectByIdMap(levelID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        int i = 0 ;

            for (int y = 0; y < 25; y++) {
                for (int x = 0; x < 25; x++) {
                    this.levelText[y][x] = map.charAt(i);
                    i++ ;
                }
            }

    }

    /**
     * This method build the level with the corresponding characters
     * @see BoulderDashModel
     * @see Position
     * @see Dimension
     * @see Diamond
     * @see Direction
     * @see Diamond
     * @see Enemy
     * @see Boulder
     * @see Motionless
     * @see Hero
     */
    public void buildLevel () {
        for (int y = 0 ; y < 25 ; y++) {

            for (int x = 0 ; x < 25 ; x++) {
                switch (this.levelText[y][x]) {
                    case 'D' :
                        this.boulderDashModel.addMobile(new Diamond(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , levelType , "diamond" , x+(y*10)));
                        break ;
                    case 'X' :
                        this.boulderDashModel.addMobile(new Boulder(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , levelType , "boulder" , x+(y*10)));
                        break ;
                    case 'B' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , levelType , "enemy_1" , x+(y*10)));
                        break ;
                    //case 'B' :
                        //this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , levelType , "enemy_2" , x+(y*10)));
                        //break ;
                    case '^' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , levelType , "amoeba" , x+(y*10)));
                        break ;
                    case '@' :
                        try {
                            this.boulderDashModel.addPlayer(new Hero(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , levelType, "hero" , x+(y*10)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break ;
                    case 'O' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , "Dirt" , levelType , "dirt" , x+(y*10)));
                        break ;
                    case 'H' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , "Wall" , levelType , "wall" , x+(y*10)));
                        break ;
                    case '|' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16  * zoom, 16 * zoom) , "Exit" , levelType , "exit" , x+(y*10)));
                        break ;
                    default :
                        break ;
                }
            }
        }
    }

    public void setBoulderDashModel (BoulderDashModel boulderDashModel) {
        this.boulderDashModel = boulderDashModel ;
    }
}
