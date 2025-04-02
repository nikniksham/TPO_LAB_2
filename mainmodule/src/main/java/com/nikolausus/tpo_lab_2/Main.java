package com.nikolausus.tpo_lab_2;

public class Main {
    public static void main(String[] args) {
//        for (int i = -10; i < 10; i++) {
//            double x = Math.PI * i + Math.PI * 0.32;
//            System.out.println(Sec.calc(x) - 1/Math.cos(x));
//        }

        for (int i = 1; i < 31; ++i) {
            double math = Math.log((double) i / 10);
            double my = LogNatural.calcPlusOne((double) i / 10 - 1);
            System.out.println((double)i/10 + " ---> " + (math - my));
        }
//        System.out.println(Math.ceil(-5.12) + " " + Math.ceil(5.12));
//        System.out.println(Math.floor(-5.12) + " " + Math.floor(5.12));
    }
}