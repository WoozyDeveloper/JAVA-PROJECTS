package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;

public class P4 {
    public static boolean prim(int nr)
    {
        if(nr < 2)
            return false;
        if(nr == 2)
            return true;
        if(nr % 2 == 0)
            return false;
        for(int i = 3; i*i <= nr ; i+=2)
            if(nr % i == 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int dim = in.nextInt();
        int[] v = new int[dim];
        for(int i=0; i<dim; i++)
            v[i] = in.nextInt();

        for(int i=0; i<dim; i++)
            if(prim(v[i]))
                System.out.println(v[i] + " este prim");
            else
                System.out.println(v[i] + " nu este prim");
    }
}
