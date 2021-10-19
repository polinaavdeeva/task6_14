package ru.vsu.cs.avdeeva_p_a;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readDoubleX();
        double n = readDouble("n");
        double e = readDouble("e");

        double sumN = countSequenceN(x, n);
        double sumE = countSequenceE(x, n, e);
        double sumE01 = countSequenceE(x, n, e / 10);
        double sumSimple = countFunction(x);

        printResult(sumN, sumE, sumE01, sumSimple);

    }

    private static double readDoubleX() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input x : ");
        double x = sc.nextDouble();

        if (Math.abs(x) > 1) {
            System.out.println("Using the properties of the logarithm, 'x' cannot be less than -1");
            System.exit(1);
        }

        return x;
    }

    private static double readDouble(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Input %s: ", text);
        double num = sc.nextDouble();

        if (num < 0) {
            System.out.println("'n' 'e' cannot be less than zero");
            System.exit(1);
        }
        
        return num;
    }

    private static double countSequenceN(double x, double n) {
        double sumN = 0;

        for (int i = 1; i <= n; i++) {
            double a = Math.pow(-1, i + 1) * Math.pow(x, i) / i;
            sumN += a;
        }
        
        return sumN;
    }

    private static double countSequenceE(double x, double n, double e) {
        double sumE = 0;

        for (int i = 1; i <= n; i++) {
            double a = Math.pow(-1, i + 1) * Math.pow(x, i) / i;

            if (Math.abs(a) > e) {
                sumE += a;
            }
        }
        
        return sumE;
    }

    private static double countFunction(double x) {
        return Math.log(1 + x);
    }

    private static void printResult(double sumN, double sumE, double sumE01, double sumSimple) {
        System.out.println("The sum of 'n' terms is equal to " + sumN);
        System.out.println("The sum of the members > e is equal to " + sumE);
        System.out.println("The sum of the members > e/10 is equal to " + sumE01);
        System.out.println("The function is equal to " + sumSimple);
    }

}
