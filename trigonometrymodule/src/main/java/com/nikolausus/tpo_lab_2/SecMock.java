package com.nikolausus.tpo_lab_2;

public class SecMock {
    public static double calcSecMock(double x) {
        double cos = CosMock.calcCosMock(x);
        if (cos == 0) {
            throw new RuntimeException("sec(x) не может быть вычислен для x = pi * 1/2, pi * 3/2 ...");
        }
        return 1 /cos;
    }
}
