package com.company;

public class Main {

    public static void main(String[] args) {
        Table myTable = new Table();
        Move move = new Move(3);
        boolean result = false;
        while(true)
        {
            move.makeRandomMove();
            boolean res = myTable.printTable();
            if(res == false){
                System.out.println("Remiza");
                System.exit(0);
            }
        }
    }
}
