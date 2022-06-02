package com.example;

import org.testng.annotations.Test;
import org.testng.internal.ParameterInfo;

import java.io.IOException;
import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static List<Path> myClasses = new ArrayList<>();
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String path = "D:\\FolderDeTest";
        myClasses = Files.walk(Paths.get(path))
                    .filter(p -> !Files.isDirectory(p))
                    .collect(Collectors.toList());

        for(int i=0;i<myClasses.size();i++) {
            URLClassLoader ucl = new URLClassLoader(new URL[]{myClasses.get(i).toUri().toURL()});
            String workingPath = myClasses.get(i).toString().replace("\\",".");
            workingPath = workingPath.replace(".java","");
            //String[] str = workingPath.split(".",-2)
            workingPath = workingPath.substring(2);
            Class<?> myCurrentClasses = ucl.loadClass("com.example" + workingPath);
            System.out.println(myCurrentClasses.getSimpleName());

            for (Method m : Class.forName(myCurrentClasses.getName()).getMethods()) {
                if (m.isAnnotationPresent(Test.class)) {
                    try {
                        System.out.println("Name of the function: " + m.getName());
                        Class<?>[] params = m.getParameterTypes();
                        for(Class c : params) {
                            //if(c.getSimpleName().equals("String"))
                            System.out.println(c.getSimpleName());
                        }
                    } catch (Throwable ex) {
                        System.out.println("Eroare method. . .");
                    }
                }
            }
        }

        //System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}
