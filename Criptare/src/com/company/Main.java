package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s1 = new String();
        String s2 = new String();
        Scanner scan = new Scanner(System.in);
        boolean[] ap = new boolean[300];

        s1 = scan.next();
        s2 = scan.next();

        int[] values = new int[300];
        for(int i = 0; i < s2.length(); i++)
        {
            Random rand = new Random();
            values[i] = rand.nextInt(100) + 1;
            int index = (int)s2.charAt(i);
            ap[index] = true;
        }

        int sum = 0;
        for(int i = 0; i < s1.length(); i++)
        {
            int index = (int)s1.charAt(i);
            if(ap[index] == true)
            {
                sum += values[i] + i + 1;
            }
        }
        if(sum <= 100)
            System.out.println("CRIPTARE NEVALIDA");
        else
            System.out.println("CRIPTARE VALIDA");
        System.out.print("S = " + sum);
    }
}
