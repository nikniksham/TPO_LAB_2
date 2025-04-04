package com.nikolausus.tpo_lab_2;

public class LogCustomMock {
    public static double calcLogWithBaseMock(double x, double base) {
        if (base <= 0) {
            throw new RuntimeException("Основание логарифма должно быть > 0");
        }
        if (base == 1) {
            throw new RuntimeException("Основание логарифма не может быть равно 1");
        }
        return LogNaturalMock.calcLogNaturalMock(x)/LogNaturalMock.calcLogNaturalMock(base);
    }
}
