package com.nikolausus.tpo_lab_2;

public class Sec {
    public static double calcSec(double x) {
        double cos = Cos.calcCos(x);
        if (cos == 0) {
            throw new RuntimeException("sec(x) не может быть вычислен для x = pi * 1/2, pi * 3/2 ...");
        }
        return 1 / cos;
    }
}
