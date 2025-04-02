package com.nikolausus.tpo_lab_2;

public class Cos {
    public static double pi = Math.PI;
    public static double pi2 = pi * 2;

    public static double roundRad(double x) {
//        System.out.println(x);
        if (Math.abs(x) > -pi2) {
//            System.out.println("Cond: " + Math.floor(x / pi) % 2 + ", true: " + Math.ceil(x / pi2) + ", false: " + Math.floor(x / pi2));
            x = x - pi2 * (Math.abs(Math.floor(x / pi) % 2) == 1 ? Math.ceil(x / pi2) : Math.floor(x / pi2));
        }
        return x;
    }

    public static long factorial(long x) {
        if (x <= 1) {
            return 1;
        }
        return factorial(x-1) * x;
    }

    public static double calc(double x) {
        double result = 0d;
//        System.out.println("---------------------------");
        x = roundRad(x);
//        System.out.println(x);
        for (int n = 0; n < 7; ++n) {
            result += Math.pow(-1, n) * Math.pow(x, 2*n) / factorial(2*n);
        }
        return result;
    }
}
