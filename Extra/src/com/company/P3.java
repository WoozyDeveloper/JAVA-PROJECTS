package com.company;

import java.util.Scanner;

public class P3 {

    public static void printDivs(int nr)
    {
        for(int i = 1; i <= nr / 2; i++)
            if(nr % i == 0)
                System.out.print(i + " ");
        System.out.print(nr);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nr = in.nextInt();
        printDivs(nr);
    }
}
