package com.nikolausus.tpo_lab_2;

public class Main {
    public static void main(String[] args) {
        for (int i = -10; i < 10; i++) {
            double x = Math.PI * i - Math.PI * 0.11;
            System.out.println(Cos.calcCos(x) - Math.cos(x));
//            System.out.println(i + " ---> " + Cos.calcCos(x));
        }

//        System.out.println(Math.ceil(-5.12) + " " + Math.ceil(5.12));
//        System.out.println(Math.floor(-5.12) + " " + Math.floor(5.12));
    }
}