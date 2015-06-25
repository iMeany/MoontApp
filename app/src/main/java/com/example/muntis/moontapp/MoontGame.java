package com.example.muntis.moontapp;

import android.app.Activity;
import android.widget.Button;

import java.util.Arrays;
import java.util.Random;

public class MoontGame {
    public int[][] gameBoard = new int[8][8];
    private Activity curActivity;
    private Button[][] buttonBoard = new Button[8][8];

    MoontGame(Activity a) {
        curActivity = a;
        initializeBoard(a);
    }

    public void initializeBoard(Activity a) {
        curActivity = a;
        // assuming at first all fields have values from 0 to 2

        gatherBoard();

        Random rand = new Random();
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                buttonBoard[i][j].setText(rand.nextInt(3));
                //System.out.print(gameBoard[i][j]);
            }
            //System.out.println();
        }

    }

    public void setA1 (int a) {
        buttonBoard[0][0].setText(a);
        return;
    }

    private void gatherBoard() {

        buttonBoard[0][0] = (Button) curActivity.findViewById(R.id.a1);
        buttonBoard[0][1] = (Button) curActivity.findViewById(R.id.a2);
        buttonBoard[0][2] = (Button) curActivity.findViewById(R.id.a3);
        buttonBoard[0][3] = (Button) curActivity.findViewById(R.id.a4);
        buttonBoard[0][4] = (Button) curActivity.findViewById(R.id.a5);
        buttonBoard[0][5] = (Button) curActivity.findViewById(R.id.a6);
        buttonBoard[0][6] = (Button) curActivity.findViewById(R.id.a7);
        buttonBoard[0][7] = (Button) curActivity.findViewById(R.id.a8);

        buttonBoard[1][0] = (Button) curActivity.findViewById(R.id.b1);
        buttonBoard[1][1] = (Button) curActivity.findViewById(R.id.b2);
        buttonBoard[1][2] = (Button) curActivity.findViewById(R.id.b3);
        buttonBoard[1][3] = (Button) curActivity.findViewById(R.id.b4);
        buttonBoard[1][4] = (Button) curActivity.findViewById(R.id.b5);
        buttonBoard[1][5] = (Button) curActivity.findViewById(R.id.b6);
        buttonBoard[1][6] = (Button) curActivity.findViewById(R.id.b7);
        buttonBoard[1][7] = (Button) curActivity.findViewById(R.id.b8);

        buttonBoard[2][0] = (Button) curActivity.findViewById(R.id.c1);
        buttonBoard[2][1] = (Button) curActivity.findViewById(R.id.c2);
        buttonBoard[2][2] = (Button) curActivity.findViewById(R.id.c3);
        buttonBoard[2][3] = (Button) curActivity.findViewById(R.id.c4);
        buttonBoard[2][4] = (Button) curActivity.findViewById(R.id.c5);
        buttonBoard[2][5] = (Button) curActivity.findViewById(R.id.c6);
        buttonBoard[2][6] = (Button) curActivity.findViewById(R.id.c7);
        buttonBoard[2][7] = (Button) curActivity.findViewById(R.id.c8);

        buttonBoard[3][0] = (Button) curActivity.findViewById(R.id.d1);
        buttonBoard[3][1] = (Button) curActivity.findViewById(R.id.d2);
        buttonBoard[3][2] = (Button) curActivity.findViewById(R.id.d3);
        buttonBoard[3][3] = (Button) curActivity.findViewById(R.id.d4);
        buttonBoard[3][4] = (Button) curActivity.findViewById(R.id.d5);
        buttonBoard[3][5] = (Button) curActivity.findViewById(R.id.d6);
        buttonBoard[3][6] = (Button) curActivity.findViewById(R.id.d7);
        buttonBoard[3][7] = (Button) curActivity.findViewById(R.id.d8);

        buttonBoard[4][0] = (Button) curActivity.findViewById(R.id.e1);
        buttonBoard[4][1] = (Button) curActivity.findViewById(R.id.e2);
        buttonBoard[4][2] = (Button) curActivity.findViewById(R.id.e3);
        buttonBoard[4][3] = (Button) curActivity.findViewById(R.id.e4);
        buttonBoard[4][4] = (Button) curActivity.findViewById(R.id.e5);
        buttonBoard[4][5] = (Button) curActivity.findViewById(R.id.e6);
        buttonBoard[4][6] = (Button) curActivity.findViewById(R.id.e7);
        buttonBoard[4][7] = (Button) curActivity.findViewById(R.id.e8);

        buttonBoard[5][0] = (Button) curActivity.findViewById(R.id.f1);
        buttonBoard[5][1] = (Button) curActivity.findViewById(R.id.f2);
        buttonBoard[5][2] = (Button) curActivity.findViewById(R.id.f3);
        buttonBoard[5][3] = (Button) curActivity.findViewById(R.id.f4);
        buttonBoard[5][4] = (Button) curActivity.findViewById(R.id.f5);
        buttonBoard[5][5] = (Button) curActivity.findViewById(R.id.f6);
        buttonBoard[5][6] = (Button) curActivity.findViewById(R.id.f7);
        buttonBoard[5][7] = (Button) curActivity.findViewById(R.id.f8);

        buttonBoard[6][0] = (Button) curActivity.findViewById(R.id.h1);
        buttonBoard[6][1] = (Button) curActivity.findViewById(R.id.h2);
        buttonBoard[6][2] = (Button) curActivity.findViewById(R.id.h3);
        buttonBoard[6][3] = (Button) curActivity.findViewById(R.id.h4);
        buttonBoard[6][4] = (Button) curActivity.findViewById(R.id.h5);
        buttonBoard[6][5] = (Button) curActivity.findViewById(R.id.h6);
        buttonBoard[6][6] = (Button) curActivity.findViewById(R.id.h7);
        buttonBoard[6][7] = (Button) curActivity.findViewById(R.id.h8);

        buttonBoard[7][0] = (Button) curActivity.findViewById(R.id.g1);
        buttonBoard[7][1] = (Button) curActivity.findViewById(R.id.g2);
        buttonBoard[7][2] = (Button) curActivity.findViewById(R.id.g3);
        buttonBoard[7][3] = (Button) curActivity.findViewById(R.id.g4);
        buttonBoard[7][4] = (Button) curActivity.findViewById(R.id.g5);
        buttonBoard[7][5] = (Button) curActivity.findViewById(R.id.g6);
        buttonBoard[7][6] = (Button) curActivity.findViewById(R.id.g7);
        buttonBoard[7][7] = (Button) curActivity.findViewById(R.id.g8);

    }

    // print out board in console
    public void printBoard() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    // converts board to string (concat)
    public String boardToString(){
        String boardStr = "";
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                boardStr += gameBoard[i][j];
            }
        }
        //System.out.println(boardStr);
        return boardStr;
    }


    // sets game board with given values
    public void setBoard(int[][] board) {
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                gameBoard[i][j]=board[i][j];
            }
        }
    }

    // marks field with value
    public void markField(int x, int y, int value) {
        gameBoard[x][y]=value;
    }

    //marks field and cross (nearest titles)
    public void markCross(int x, int y, int value){

        // marks field and fields on right, left, top, bot of it
        gameBoard[x][y]= value;
        gameBoard[x + 1 % 8][y] = value;
        gameBoard[x - 1 % 8][y] = value;
        gameBoard[x][y + 1 % 8] = value;
        gameBoard[x][y - 1 % 8] = value;
    }


}

