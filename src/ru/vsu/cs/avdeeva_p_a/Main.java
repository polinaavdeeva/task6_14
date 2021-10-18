package ru.vsu.cs.avdeeva_p_a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double x = readDouble();
        double n = readDouble();
        double e = Math.E;

        countSequence(x, n, e);
    }

    private static double readDouble() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input x : ");
        double x = sc.nextDouble();

        if (x < -1) {
            System.out.println("Using the properties of the logarithm, 'x' cannot be less than -1");
        }

        System.out.print("Input x : ");
        double n = sc.nextDouble();

        if (n < 0) {
            System.out.println("'n' cannot be less than zero");
        }

        return sc.nextDouble();
    }

    private static void countSequence(double x, double n, double e) {
        double sumN = 0;
        double sumE = 0;
        double sumE01 = 0;
        double sumSimple = Math.log(1 + x);
        for (int i = 1; i <= n; i++) {
            double a = Math.pow(-1, i + 1) * Math.pow(x, i) / i;
            sumN += a;
            if (Math.abs(a) > e) sumE += a;
            if (Math.abs(a) > e / 10) sumE01 += a;
        }
        printResult(sumN, sumE, sumE01, sumSimple);
    }

    private static void printResult(double sumN, double sumE, double sumE01, double sumSimple) {
        System.out.println("The sum of 'n' terms is equal to " + sumN);
        System.out.println("The sum of the members >e is equal to " + sumE);
        System.out.println("The sum of the members >e/10 is equal to " + sumE01);
        System.out.println("The function is equal to " + sumSimple);
    }

}