package com.nikolausus.tpo_lab_2;

public class LogNatural {
    public static double calcPlusOne(double x) {

        if (x + 1 <= 0) {
            throw new RuntimeException("ln(x) -> x должен быть > 0");
        }

        int n_terms = 1000;
        if (x > 1) {
            double scale = 0;
            double x_scaled = x;
            while (x_scaled >= 2) {
                x_scaled /= 2;
                scale += 1;
            }
            while (x_scaled < 0.5) {
                x_scaled *= 2;
                scale -= 1;
            }

            double u = x_scaled - 1;
            double ln_x_scalded = 0;
            for (int n = 1; n < n_terms + 1; ++n) {
                ln_x_scalded += Math.pow(-1, n + 1) * Math.pow(u, n) / n;
            }

            double ln_2 = 0;
            for (int n = 1; n < n_terms + 1; ++n) {
                ln_2 += Math.pow(-1, n + 1) / n;
            }

            double ln_x = ln_x_scalded + scale * ln_2;

            return ln_x + LogNatural.calcPlusOne(1d / x);
        }

        double ln_x = 0;
        for (int n = 1; n < n_terms+1; ++n) {
            ln_x += Math.pow(-1, n + 1) * Math.pow(x, n) / n;
        }
        return ln_x;
    }
}
