package com.nikolausus.tpo_lab_2;

public class LogCustom {
    public static double calcLogWithBase(double x, double base) {
        if (base <= 0) {
            throw new RuntimeException("Основание логарифма должно быть > 0");
        }
        if (base == 1) {
            throw new RuntimeException("Основание логарифма не может быть равно 1");
        }
        return LogNatural.calcLog(x)/LogNatural.calcLog(base);
    }
}
