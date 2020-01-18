package com.rymart;

import java.util.Scanner;

public class Probe {

    public static void main(String[] args) {
        double[][] planets = getPlanetInput();
        double[][] rainfallInput = getRainfallInput(planets);
        printTable(rainfallInput);
        printRange(rainfallInput);
        printAverages(rainfallInput);
        printTotals(rainfallInput);
        printMaximum(rainfallInput);
        printMinimum(rainfallInput);
        double[][] flippedRainInput = flipInput(rainfallInput);
        printRecordingCycles(flippedRainInput);
    }

    private static double[][] getPlanetInput() {
        Scanner Beep = new Scanner(System.in);
        int rows = 1;
        int cols = 1;
        do {
            if (rows < 1 || cols < 1) {
                System.out.println("These are faulty values. Enter some new values.");
            }
            System.out.print("Enter a number for the amount of rainfall" + " readings for each planet: ");
            rows = Beep.nextInt();
            System.out.print("Enter the number of planets that are " + "being monitered: ");
            cols = Beep.nextInt();
            System.out.println();
        } while (rows <= 0 || cols <= 0);
        return new double[rows][cols];
    }
    private static double[][] getRainfallInput(double[][] planets) {
        Scanner Beep = new Scanner(System.in);
        for (int x = 0; x < planets.length; x++) {
            for (int y = 0; y < planets[x].length; y++) {
                System.out.print("Enter a the rainfall reading " + x + " for planet " + y + ": ");
                planets[x][y] = Beep.nextDouble();
            }
            System.out.println();
        }
        return planets;
    }
    private static void printTable(double[][] rainfallInput) {
        for (int i = 0; i < rainfallInput.length; i++) {
            for (int j = 0; j < rainfallInput[i].length; j++) {
                double rainAmount = rainfallInput[i][j];
                System.out.print(rainAmount + " ");
            }
            System.out.println();
        }
    }
    private static void printRange(double[][] rainfallInput) {
        double max = 0;
        double min = 10000000;
        for (int i = 0; i < rainfallInput.length; i++) {
            for (int j = 0; j < rainfallInput[i].length; j++) {
                max = Math.max(max, rainfallInput[i][j]);
                min = Math.min(min, rainfallInput[i][j]);
            }
        }
        double ran = (max - min);
        System.out.println("The range is: " + ran);
    }
    private static void printAverages(double[][] rainfallInput) {
        for (int i = 0; i < rainfallInput.length; i++) {
            double rowTotal = 0.0;
            for (int j = 0; j < rainfallInput[i].length; j++) {
                double rainAmount = rainfallInput[i][j];
                rowTotal += rainAmount;
            }
            System.out.println("The average for planet " + i + " is " + rowTotal / rainfallInput[i].length);
        }
    }
    private static void printTotals(double[][] rainfallInput) {
        for (int i = 0; i < rainfallInput.length; i++) {
            double rowTotal = 0.0;
            for (int j = 0; j < rainfallInput[i].length; j++) {
                double rainAmount = rainfallInput[i][j];
                rowTotal += rainAmount;
            }
            System.out.println("The total for planet " + i + " is " + rowTotal);
        }
    }
    private static void printMaximum(double[][] rainfallInput) {
        for (int i = 0; i < rainfallInput.length; i++) {
            double max = 0;
            for (int j = 0; j < rainfallInput[i].length; j++) {
                double rainAmount = rainfallInput[i][j];
                max = Math.max(max, rainAmount);
            }
            System.out.println("The maximum rain for planet " + i + " is: " + max);
        }
    }
        private static void printMinimum(double[][] rainfallInput) {
        for (int i = 0; i < rainfallInput.length; i++) {
            double min = 99999999;
            for (int j = 0; j < rainfallInput[i].length; j++) {
                double rainAmount = rainfallInput[i][j];
                min = Math.min(min, rainAmount);
            }
            System.out.println("The minimum rain for planet " + i + " is: " + min);
        }
    }
    private static double[][] flipInput(double[][] rainfallInput) {
        int originalrows = rainfallInput.length;
        int originalcols = rainfallInput[0].length; //null pointer risk here
        double [][] flipped = new double[originalcols][originalrows];

        for (int i = 0; i < flipped.length; i++) {
            for (int j = 0; j < flipped[i].length; j++) {
                flipped[i][j] = rainfallInput[j][i];

            }
        }
        return flipped;
    }
    private static void printRecordingCycles(double[][] flippedRainInput) {
        for (int i = 0; i < flippedRainInput.length; i++) {
            double rowTotal = 0.0;
            for (int j = 0; j < flippedRainInput[i].length; j++) {
                double rainAmount = flippedRainInput[i][j];
                rowTotal += rainAmount;
            }
            System.out.println("The average rainfall per recording cycle " + i + " = " + rowTotal / flippedRainInput[i].length);
        }
    }













}