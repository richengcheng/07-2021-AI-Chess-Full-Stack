package ryde.UnitTest;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.BeforeClass;

import ryde.InternetChess.Chess;
import ryde.InternetChess.Lion;
import ryde.InternetChess.Cat;
import ryde.InternetChess.Dog;
import ryde.InternetChess.Chick;
import ryde.battle.ChessInfo;
import ryde.gui.ChessBoard;

public class Test1 {

    ChessBoard  chessboard[][]=new ChessBoard[6][11];


    @Before
    public  void Before() throws Exception {
        System.out.println("Start:");

            for (int i = 0; i < 6; i++) {
                //left waiting board setting
                for (int j = 0; j < 3; j++) {
                    chessboard[i][j] = new ChessBoard(i,j,1);
                    chessboard[i][j].setBounds(j * 53+40, i * 53+35, 54, 54);

                }
                //main chess play board
                for (int j = 3; j < 8; j++) {
                    chessboard[i][j] = new ChessBoard(i,j,0);
                    chessboard[i][j].setBounds(j * 53+40, i * 53+35, 54, 54);

                }
                //right waiting board
                for (int j = 8; j < 11; j++) {
                    chessboard[i][j] = new ChessBoard(i,j,2);
                    chessboard[i][j].setBounds(j * 53+40, i * 53+35, 54, 54);
                }
            }


    }



    @After
    public void after() throws Exception {
        System.out.println("Over!");
    }

    /**
     * Method: add(int i, int j)
     */

    @Test
    public void TestCat() throws Exception {

        //TODO: Test goes here...
     //   ChessBoard  chessboard[][]=new ChessBoard[6][11];
        Chess cat1=new Cat( 1,3,true);
        //System.out.println(cat1.isEnemy());
      // org.junit.Assert.assertEquals(false, cat1.isEnemy(), 0);
        org.junit.Assert.assertTrue(cat1.isEnemy());

        org.junit.Assert.assertTrue(cat1.isWalkable(chessboard[2][3],chessboard));
        org.junit.Assert.assertTrue(cat1.isWalkable(chessboard[2][4],chessboard));
        org.junit.Assert.assertTrue(cat1.isWalkable(chessboard[2][2],chessboard));

        org.junit.Assert.assertFalse(cat1.isWalkable(chessboard[1][4],chessboard));
        org.junit.Assert.assertFalse(cat1.isWalkable(chessboard[1][2],chessboard));

    }
}
