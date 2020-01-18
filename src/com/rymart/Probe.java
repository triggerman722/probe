package com.rymart;

import java.util.Scanner;

public class Probe {

    public static void main(String[] args) {
        Scanner Beep = new Scanner(System.in);
        int rows = 1;
        int cols = 1;
        do {
            if (rows < 1 || cols < 1) {
                System.out.println("These are faulty values. Enter some new values.");
            }

            System.out.print("Enter a number for the amount of rainfall"+ " readings for each planet: ");
            rows = Beep.nextInt();
            System.out.print("Enter the number of planets that are "+ "being monitered: ");
            cols = Beep.nextInt();
            System.out.println();
        }while (rows <= 0 || cols <= 0);

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

        for (int i = 0; i<array.length; i++) {
            //for each row
            double rowTotal = 0.0;
            double min =99999999, max = 0.0;
            for(int j = 0; j<array[i].length; j++) {
                //for each col
                double rainAmount = array[i][j];
                System.out.print(rainAmount + " ");
                rowTotal += rainAmount;
                min = Math.min(min, rainAmount);
                max = Math.max(max, rainAmount);
            }
            System.out.print(" Total: " + rowTotal + "; Average: " + rowTotal/rows + "; Min: " + min + "; Max: " + max);
            System.out.println();
        }
        for (int i = 0; i<cols; i++) {
            double colTotal = 0.0;
            double colmin=99999999, colmax=0.0;
            for (int y=0;y<rows;y++) {
                double colrainAmount = array[y][i];
                colTotal += colrainAmount;
                colmin = Math.min(colmin, colrainAmount);
                colmax = Math.max(colmax, colrainAmount);
            }
            System.out.print(" Total: " + colTotal + "; Average: " + colTotal/cols + "; Min: " + colmin + "; Max: " + colmax);
        }
//int r = rows;
        //int c = cols;
        //double x = Range(array);
        //System.out.println("The range is: " + x);
        //AvgRain(array, c);
        //System.out.println("The average rainfall amount is : " + y);
        //TotRain(array, r);
        //double z = MaxRain(array);
        //System.out.println("The highest amount of rainfall: " + z);

    }

    public static double Range (double[][] array) {
        double max = 0;
        double min = 10000000;
        for (int i = 0; i<array.length; i++) {
            for(int j = 0; j<array[i].length; j++) {
                if(array[i][j] > max)
                    max = array[i][j];
                if(array[i][j] < min)
                    min = array[i][j];
            }
        }
        double ran = (max - min);
        return ran;
    }
    public static void AvgRain (double[][] array, int x) {
        double sum = 0;
        for (int z = 0; z < array[x].length; z++) {
            for(int j = 0; j < array.length; j++) {
                sum = sum + array[j][x];
            }
            double avg = sum/x;
            System.out.println("The average of planet " + z + " = " + avg);
            sum = 0;
            avg = 0;
        }
    }

    public static void TotRain (double[][] array, int x) {
        double sum = 0;
        for (int z = 0; z < array.length; z++) {
            for(int j = 0; j < array[x].length; j++) {
                sum = sum + array[x][j];
            }
            double avg = sum/x;
            System.out.println("The average rainfall per recording cycle " + z + " = " + avg);
            sum = 0;
            avg = 0;
        }
    }
/*
public static double AvgRain (double[][] array, int x) {
   double sum = 0;
   for(int j = 0; j<=array.length; j++) {
       sum = sum + array[j][x];
   }
   double avg = sum/x;
   System.out.println("The average of planet " + x + " = " + avg);
   sum = 0;
 return sum;
}


public static double TotRain (double[][] array, int x) {
   double sum = 0;

   for(int j = 0; j>array[x].length; j++) {
       if (x <= array.length -1 || x <= 0 ) {
           return sum;
       }
       else
           sum = sum + array[x][j];
   }
}
*/
}