package com.company;

import java.util.Scanner;

public class Main {

    public static int fact(int nr)
    {
        int prod = 1;
        for(int i=2; i<=nr; i++)
            prod *= i;
        return prod;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int nr = in.nextInt();
        System.out.println(fact(nr));
    }
}
