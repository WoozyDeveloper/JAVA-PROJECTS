package com.company;

import java.util.Scanner;

public class P2 {

    public static int cmmdc(int nr1,int nr2)
    {
        int c;
        while(nr2 > 0)
        {
            c = nr1 % nr2;
            nr1 = nr2;
            nr2 = c;
        }
        return nr1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nr1 = in.nextInt();
        int nr2 = in.nextInt();
        int nr3 = nr1 + nr2;
        System.out.print(cmmdc(nr1,nr2));
    }
}
