package com.nikolausus.tpo_lab_2;

public class CosMock {
    public static double[] keys = {
            -50.00,
            -49.00,
            -48.00,
            -47.00,
            -46.00,
            -45.00,
            -44.00,
            -43.00,
            -42.00,
            -41.00,
            -40.00,
            -39.00,
            -38.00,
            -37.00,
            -36.00,
            -35.00,
            -34.00,
            -33.00,
            -32.00,
            -31.00,
            -30.00,
            -29.00,
            -28.00,
            -27.00,
            -26.00,
            -25.00,
            -24.00,
            -23.00,
            -22.00,
            -21.00,
            -20.00,
            -19.00,
            -18.00,
            -17.00,
            -16.00,
            -15.00,
            -14.00,
            -13.00,
            -12.00,
            -11.00,
            -10.00,
            -9.00,
            -8.00,
            -7.00,
            -6.00,
            -5.00,
            -4.00,
            -3.00,
            -2.00,
            -1.00,
            0.00,
            1.00,
            2.00,
            3.00,
            4.00,
            5.00,
            6.00,
            7.00,
            8.00,
            9.00,
            10.00,
            11.00,
            12.00,
            13.00,
            14.00,
            15.00,
            16.00,
            17.00,
            18.00,
            19.00,
            20.00,
            21.00,
            22.00,
            23.00,
            24.00,
            25.00,
            26.00,
            27.00,
            28.00,
            29.00,
            30.00,
            31.00,
            32.00,
            33.00,
            34.00,
            35.00,
            36.00,
            37.00,
            38.00,
            39.00,
            40.00,
            41.00,
            42.00,
            43.00,
            44.00,
            45.00,
            46.00,
            47.00,
            48.00,
            49.00
    };
    public static double[] vals = {
            0.96497,
            0.30059,
            -0.64014,
            -0.99228,
            -0.43218,
            0.52532,
            0.99984,
            0.55511,
            -0.39999,
            -0.98729,
            -0.66694,
            0.26664,
            0.95507,
            0.76541,
            -0.12796,
            -0.90368,
            -0.84856,
            -0.01328,
            0.83422,
            0.91474,
            0.15425,
            -0.74805,
            -0.96258,
            -0.29214,
            0.64692,
            0.99120,
            0.42418,
            -0.53283,
            -0.99986,
            -0.54773,
            0.40808,
            0.98870,
            0.66032,
            -0.27516,
            -0.95763,
            -0.75969,
            0.13674,
            0.90745,
            0.84385,
            0.00443,
            -0.83907,
            -0.91112,
            -0.14550,
            0.75390,
            0.96017,
            0.28366,
            -0.65364,
            -0.98994,
            -0.41615,
            0.54030,
            1.00000,
            0.54030,
            -0.41615,
            -0.98994,
            -0.65364,
            0.28366,
            0.96017,
            0.75390,
            -0.14550,
            -0.91112,
            -0.83907,
            0.00443,
            0.84385,
            0.90745,
            0.13674,
            -0.75969,
            -0.95763,
            -0.27516,
            0.66032,
            0.98870,
            0.40808,
            -0.54773,
            -0.99986,
            -0.53283,
            0.42418,
            0.99120,
            0.64692,
            -0.29214,
            -0.96258,
            -0.74805,
            0.15425,
            0.91474,
            0.83422,
            -0.01328,
            -0.84856,
            -0.90368,
            -0.12796,
            0.76541,
            0.95507,
            0.26664,
            -0.66694,
            -0.98729,
            -0.39999,
            0.55511,
            0.99984,
            0.52532,
            -0.43218,
            -0.99228,
            -0.64014,
            0.30059,
    };

    public static double calcCosMock(double x) {
        for (int i = 0; i < keys.length; ++i) {
            if (keys[i] == x) {
                return vals[i];
            }
        }
        throw new RuntimeException("Значение вне определённых значений");
    }
}
