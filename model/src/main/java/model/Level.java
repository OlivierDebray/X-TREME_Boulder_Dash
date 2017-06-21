package model;

/**
 * @author Olivier Debray olivier.debray@viacesi.fr
 *         Made on 21/06/2017
 */

class Level {
    private BoulderDashModel boulderDashModel ;
    private int levelType ;
    private char[][] levelText = new char[30][30] ;

    Level(int levelType , int levelID) {
        this.levelType = levelType ;
    }

    public void buildLevel () {
        for (int y = 0 ; y < 30 ; y++) {
            for (int x = 0 ; x < 30 ; x++) {
                switch (levelText[y][x]) {
                    case 'D' :
                        this.boulderDashModel.addMobile(new Diamond(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "diamond"));
                        break ;
                    case 'X' :
                        this.boulderDashModel.addMobile(new Boulder(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "boulder"));
                        break ;
                    case '^' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "enemy_1"));
                        break ;
                    case 'B' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "enemy_2"));
                        break ;
                    case '¤' :
                        this.boulderDashModel.addMobile(new Enemy(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16) , levelType , "amoeba"));
                        break ;
                    case '@' :
                        this.boulderDashModel.addMobile(new Hero(Direction.NONE , new Position(x*16 , y*16) , new Dimension(16 , 16), levelType, "hero" ));
                        break ;
                    case 'O' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16 , 16) , "Dirt" , levelType));
                        break ;
                    case 'H' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16 , 16) , "Wall" , levelType));
                        break ;
                    case '|' :
                        this.boulderDashModel.addMotionless(new Motionless(new Position(x*16 , y*16) , new Dimension(16 , 16) , "Exit" , levelType));
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
