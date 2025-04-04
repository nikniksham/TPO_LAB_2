package com.nikolausus.tpo_lab_2;

public class Main {
    public static void main(String[] args) {
//        for (int i = -10; i < 10; i++) {
//            double x = Math.PI * i + Math.PI * 0.32;
//            System.out.println(Sec.calcSec(x) - 1/Math.cos(x));
//        }
//
//        for (int i = 1; i < 41; ++i) {
//            double math = Math.log((double) i / 10);
//            double my = LogNatural.calcLog((double) i / 10);
//            System.out.println((double)i/10 + " ---> " + (math - my));
//        }

//        for (int i = 1; i < 10; ++i) {
//            for (int base = 2; base < 10; ++base) {
//                double math = Math.log(i) / Math.log(base);
//                double my = LogCustom.calcLogWithBase(i, base);
//                System.out.println(base + " >>> " + i + " ---> " + (math - my));
//            }
//        }
    }

    public static double calcFunc(double x) {
        if (x <= 0) {
            return Sec.calcSec(x);
        } else {
            return (((Math.pow(LogCustom.calcLogWithBase(x, 10), 3) / LogNatural.calcLog(x)) + LogCustom.calcLogWithBase(x, 2)) * (LogNatural.calcLog(x) + LogCustom.calcLogWithBase(x, 3))) + LogNatural.calcLog(x);
        }
    }
}