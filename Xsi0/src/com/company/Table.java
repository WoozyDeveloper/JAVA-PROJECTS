package com.company;

public class Table{
    static int table_size;
    static char player = 'X';
    static boolean freePosition;
    public static char[][] board = new char[20][20];

    public Table(int dim)
    {
        this.table_size = dim;
        for(int i = 0; i < this.table_size; i++)
            for(int j = 0;j < this.table_size; j++)
                board[i][j] = '*';
    }

    public Table()
    {
        this.table_size = 3;
        for(int i = 0; i < this.table_size; i++)
            for(int j = 0; j < this.table_size; j++)
                board[i][j] = '*';
    }

    public static boolean printTable()
    {
        freePosition = false;
        for(int i = 0; i < table_size; i++)
        {
            for(int j = 0; j < table_size; j++) {
                System.out.print(board[i][j] + "   ");
                if(board[i][j] == '*')
                    freePosition = true;
            }
            System.out.println();
        }
        System.out.println("- - - - - - - - - - - - - - - - - -");
        return freePosition;
    }
}
