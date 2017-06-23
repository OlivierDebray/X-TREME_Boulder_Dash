package model;

import model.dao.QueryLevel;

import java.sql.SQLException;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 21/06/2017
 */

public class Level {
    private BoulderDashModel boulderDashModel ;
    private int levelType ;
    private char[][] levelText ;


    Level(int levelType , int levelID) {
        this.levelType = levelType ;
        this.levelText = new char[30][30] ;


        this.levelText[0][0] = 'X' ;
        this.levelText[10][0] = '@' ;
        this.levelText[5][4] = 'B' ;
        this.levelText[6][5] = 'H' ;
        this.levelText[5][5] = 'H' ;
        this.levelText[4][5] = 'H' ;
        this.levelText[5][10] = '^' ;
        this.levelText[0][10] = 'X' ;
        this.levelText[0][11] = 'X' ;
        this.levelText[7][5] = 'X' ;
        this.levelText[5][6] = 'D' ;
        this.levelText[7][6] = 'X' ;
        this.levelText[5][7] = 'X' ;
        this.levelText[7][7] = 'X' ;
        this.levelText[5][8] = 'D' ;
        this.levelText[7][8] = 'D' ;
        this.levelText[5][12] = 'X' ;
        this.levelText[8][22] = 'B' ;
        this.levelText[14][23] = 'O' ;
        this.levelText[13][23] = 'O' ;
        this.levelText[12][23] = 'O' ;
        this.levelText[11][23] = 'O' ;
        this.levelText[10][23] = 'O' ;
        this.levelText[9][23] = 'O' ;
        this.levelText[8][23] = 'O' ;
        this.levelText[7][23] = 'X' ;
        this.levelText[22][23] = 'H' ;
        this.levelText[21][23] = 'H' ;
    }

    public void getLevel(int levelID) {
        QueryLevel queryLevel = new QueryLevel();
        String map = "";
        try {
            map = queryLevel.getQuerySelectByIdMap(levelID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(map);
        System.out.println(map.length());

        int i = 0 ;

            for (int y = 0; y < 25; y++) {
                for (int x = 0; x < 25; x++) {
                    this.levelText[y][x] = map.charAt(i);
                    System.out.print(this.levelText[y][x]) ;
                    i++ ;
                }
            }

    }

    public void buildLevel () {
        for (int y = 0 ; y < 25 ; y++) {

            this.levelText[24][y] = 'H' ;
            this.levelText[23][y] = 'H' ;

            for (int x = 0 ; x < 25 ; x++) {
                switch (this.levelText[y][x]) {
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
