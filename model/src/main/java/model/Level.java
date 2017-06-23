package model;

import model.dao.QueryLevel;

import java.sql.SQLException;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 21/06/2017
 */

class Level {
    private BoulderDashModel boulderDashModel ;
    private int levelType ;
    private char[][] levelText ;

    Level(int levelType , int levelID) {
        this.levelType = levelType ;
        this.levelText = new char[30][30] ;
        this.levelText[0][0] = '@' ;
        this.levelText[5][5] = 'X' ;
        this.levelText[7][5] = 'D' ;
        this.levelText[5][6] = 'D' ;
        this.levelText[7][6] = 'X' ;
        this.levelText[5][7] = 'X' ;
        this.levelText[7][7] = 'X' ;
        this.levelText[5][8] = 'D' ;
        this.levelText[7][8] = 'D' ;
        this.levelText[5][12] = 'X' ;
        this.levelText[27][15] = 'H' ;
    }

    public void getLevel (int levelID) {
        QueryLevel queryLevel = new QueryLevel() ;
        try {
            queryLevel.getQuerySelectByIdMap(levelID) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buildLevel () {
        for (int y = 0 ; y < 30 ; y++) {
            this.levelText[29][y] = 'O' ;
            this.levelText[28][y] = 'O' ;
            for (int x = 0 ; x < 30 ; x++) {
                switch (levelText[y][x]) {
                    case 'D' :
                        this.boulderDashModel.addMobile(new Diamond(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "diamond" , x+(y*10)));
                        break ;
                    case 'X' :
                        this.boulderDashModel.addMobile(new Boulder(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "boulder" , x+(y*10)));
                        break ;
                    case '^' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "enemy_1" , x+(y*10)));
                        break ;
                    case 'B' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "enemy_2" , x+(y*10)));
                        break ;
                    case '¤' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "amoeba" , x+(y*10)));
                        break ;
                    case '@' :
                        this.boulderDashModel.addPlayer(new Hero(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16), levelType, "hero" , x+(y*10)));
                        break ;
                    case 'O' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16 , 16) , "Dirt" , levelType , "dirt" , x+(y*10)));
                        break ;
                    case 'H' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16 , 16) , "Wall" , levelType , "wall" , x+(y*10)));
                        break ;
                    case '|' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16 , 16) , "Exit" , levelType , "exit" , x+(y*10)));
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
