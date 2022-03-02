package com.company;

import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s1 = new String();
        String s2 = new String();
        Scanner scan = new Scanner(System.in);

        s1 = scan.next();
        s2 = scan.next();

        int[] values = new int[300];

        int sum = 0;
        for(int i = 0; i < s2.length(); i++)
        {
            Random rand = new Random();
            values[i] = rand.nextInt(100) + 1;
            for(int j = 0; j < s1.length(); j++)
            {
                if(s2.charAt(i) == s1.charAt(j))
                    sum += values[i] + j + 1;
            }
        }



        if(sum <= 100)
            System.out.println("CRIPTARE NEVALIDA");
        else
            System.out.println("CRIPTARE VALIDA");

        System.out.print("Valorile asociate elementelor din sirul B: ");
        for(int i = 0; i < s2.length(); i++)
            System.out.print(values[i]+ " ");
        System.out.print("\nS = " + sum);
    }
}
