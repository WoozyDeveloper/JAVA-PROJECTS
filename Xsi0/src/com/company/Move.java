package com.company;

import java.util.Random;

public class Move extends Table{

    public Move(int dim) {
        super(dim);
    }

    public Move() {
        super();
    }

    public static boolean checkForWinner() {
        char checking_character = 'X';
        boolean found_position = false;

        //diagonala principala
        boolean found = true;
        for (int i = 0; i < table_size; i++)
            if (board[i][i] != checking_character) {
                found = false;
                break;
            }
        if (found == true)
            return true;

        //diagonala secundara
        found = true;
        for (int i = 0; i < table_size; i++)
            for (int j = 0; j < table_size; j++)
                if (i + j == table_size - 1) {
                    if (board[i][j] != checking_character) {
                        found = false;
                        break;
                    }
                }
        if (found == true)
            return true;

        //linii
        for (int line = 0; line < table_size; line++) {
            found = true;
            for (int col = 0; col < table_size; col++)
                if (board[line][col] != checking_character) {
                    found = false;
                    break;
                }
            if (found == true)
                return true;
        }

        //coloane
        for (int col = 0; col < table_size; col++) {
            found = true;
            for (int line = 0; line < table_size; line++)
                if (board[line][col] != checking_character) {
                    found = false;
                    break;
                }
            if (found == true)
                return true;
        }


        checking_character = 'Y';
        found_position = false;

        //diagonala principala
        found = true;
        for (int i = 0; i < table_size; i++)
            if (board[i][i] != checking_character) {
                found = false;
                break;
            }
        if (found == true)
            return true;

        //diagonala secundara
        found = true;
        for (int i = 0; i < table_size; i++)
            for (int j = 0; j < table_size; j++)
                if (i + j == table_size - 1) {
                    if (board[i][j] != checking_character) {
                        found = false;
                        break;
                    }
                }
        if (found == true)
            return true;

        //linii
        for (int line = 0; line < table_size; line++) {
            found = true;
            for (int col = 0; col < table_size; col++)
                if (board[line][col] != checking_character) {
                    found = false;
                    break;
                }
            if (found == true)
                return true;
        }

        //coloane
        for (int col = 0; col < table_size; col++) {
            found = true;
            for (int line = 0; line < table_size; line++)
                if (board[line][col] != checking_character) {
                    found = false;
                    break;
                }
            if (found == true)
                return true;
        }
        return false;
    }

    public static void makeRandomMove()
    {
        boolean free_spot = false;
        while(free_spot == false) {
            Random rand = new Random();
            int x = rand.nextInt(table_size);
            int y = rand.nextInt(table_size);
            if (board[x][y] == '*') {
                //System.out.print("X= " + x + ", Y= " + y);
                free_spot = true;
                board[x][y] = player;
                if (player == 'X') {
                    boolean res = checkForWinner();
                    if(res == true) {
                        printTable();
                        System.out.println("X is the winner! ! !");
                        System.exit(0);
                    }
                    player = 'Y';
                }
                else {
                    boolean res = checkForWinner();
                    if(res == true) {
                        printTable();
                        System.out.println("Y is the winner! ! !");
                        System.exit(0);
                    }
                    player = 'X';
                }
            }
        }
    }
}
