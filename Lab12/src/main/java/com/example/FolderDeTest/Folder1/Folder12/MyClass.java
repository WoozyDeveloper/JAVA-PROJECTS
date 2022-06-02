package com.example.FolderDeTest.Folder1.Folder12;

import org.testng.annotations.Test;

public class MyClass {
    @Test
    public void print1(int x, String y, int z){
        System.out.println("Print 1 " + x);
    }

    @Test
    public void print2(String x){
        System.out.println("Print 2 " + x);
    }
}
