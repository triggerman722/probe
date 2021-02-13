package com.rymart;

import java.util.Scanner;

public class Probe2 {

    public static void main(String[] args) {
        Scanner Beep = new Scanner(System.in);
        int rows = 1;
        int cols = 1;
        do {
            if (rows < 1 || cols < 1) {
                System.out.println("These are faulty values. Enter some new values.");
            }

            System.out.print("Enter a number for the amount of rainfall"
                    + " readings for each planet(rows): ");
            rows = Beep.nextInt();
            System.out.print("Enter the number of planets that are "
                    + "being monitered (cols): ");
            cols = Beep.nextInt();
            System.out.println();
        } while (rows <= 0 || cols <= 0);

        double[][] array = new double[rows][cols];
        int count = 0;
        int gho = 0;
        for (int x = 0; x < array.length; x++) {
            count++;
            for (int y = 0; y < array[x].length; y++) {
                gho++;
                System.out.print("Enter a value for " + count + ", " + gho + ": ");
                array[x][y] = Beep.nextDouble();
            }
            gho = 0;
            System.out.println();
        }

        for (int i = 0; i < array.length; i++) {
//for each row
            for (int j = 0; j < array[i].length; j++) {
//for each col
                System.out.print(array[i][j] + "	");
            }
            System.out.println();
        }
        //double r = (rows - 1);
        //double c = (cols - 1);
        double x = Range(array);
        System.out.println("The range is: " + x);
        AvgRain(array, cols, rows);
//System.out.println("The average rainfall amount is : " + y);
        TotRain(array);
        double z = MaxRain(array);
        System.out.println("The highest amount of rainfall: " + z + "mm.");

    }

    public static double Range(double[][] array) {
        double max = 0;
        double min = 10000000;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max)
                    max = array[i][j];
                if (array[i][j] < min)
                    min = array[i][j];
            }
        }
        double ran = (max - min);
        return ran;
    }

    public static void AvgRain(double[][] array, double col, double row) {

        //Because the number of columns and rows were provided in this method,
        //we can loop through the array
        for (int i = 0; i<col;i++) {
            double rainFallAmount = 0.0;
            for (int y=0;y<row;y++){
                rainFallAmount += array[y][i];
            }
            System.out.println("The average of planet " + i + "= " + rainFallAmount/row);
        }


//This is about cols
        /*for (int z = 0; z < array.length; z++) {
            double sum = 0;
            for (int j = 0; j < array[z].length; j++) {
                double colrainAmount = array[z][j];
                sum += colrainAmount;

            }
            System.out.println("The average of planet " + z + " = " + sum / array[z].length);

        }*/
    }


    public static void TotRain(double[][] array) {
//This is about rows
        double sum = 0;
        for (int z = 0; z < array.length; z++) {
            for (int j = 0; j < array[z].length; j++) {
                sum = sum + array[z][j];
            }
            System.out.println("The total rainfall per recording cycle " + z + " = " + sum);
            sum = 0;
        }
    }

    public static double MaxRain(double[][] array) {
        double max = 0;
        double x = 0;
        double y = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("The max rainfall is located at: " + x + ", " + y);
        return max;
    }

}