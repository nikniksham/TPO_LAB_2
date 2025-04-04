import com.nikolausus.tpo_lab_2.LogCustomMock;
import com.nikolausus.tpo_lab_2.LogNaturalMock;
import com.nikolausus.tpo_lab_2.SecMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestMockIntegrationFullhausShitFuck {
    public static double[] keys = {
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
            2.00,
            3.00,
            4.00,
            5.00,
            6.00,
            7.00,
            8.00,
            9.00
    };

    public static double[] results = {
            -1.19180,
            -1.09755,
            -6.87285,
            1.32643,
            1.04148,
            3.52532,
            -1.52989,
            -1.01016,
            -2.40300,
            1.85082,
            1.00000,
            2.06817,
            4.63207,
            7.10058,
            9.39735,
            11.53723,
            13.53302,
            15.40284,
            17.15497
    };

    private double calcMath(double x) {
        if (x <= 0) {
            return 1 / Math.cos(x);
        } else {
            double log10 = Math.log10(x);  // log₁₀(x)
            double ln = Math.log(x);       // ln(x)

            // Вычисляем log₂(x) = ln(x)/ln(2)
            double log2 = ln / Math.log(2);

            // Вычисляем log₃(x) = ln(x)/ln(3)
            double log3 = ln / Math.log(3);

            // Вычисляем числитель: log₁₀(x)³
            double log10Cubed = Math.pow(log10, 3);

            // Вычисляем первую часть: (log₁₀(x)³ / ln(x))
            double firstPart = log10Cubed / ln;

            // Вторая часть в первых скобках: + log₂(x)
            double firstBrackets = firstPart + log2;

            // Вторые скобки: (ln(x) + log₃(x))
            double secondBrackets = ln + log3;

            // Умножаем результаты скобок
            double multiplication = firstBrackets * secondBrackets;

            // Добавляем окончательный ln(x)
            return multiplication + ln;
        }
    }

    @Test
    @DisplayName("Интеграционное тестирование, введение sec(x) в игру")
    public void testSec() {
        double accuracy = 0.001;
        double res;
        for (double x : keys) {
            if (x <= 0) {
                res = SecMock.calcSecMock(x);
            } else {
                double log10 = Math.log10(x);  // log₁₀(x)
                double ln = Math.log(x);       // ln(x)

                // Вычисляем log₂(x) = ln(x)/ln(2)
                double log2 = ln / Math.log(2);

                // Вычисляем log₃(x) = ln(x)/ln(3)
                double log3 = ln / Math.log(3);

                // Вычисляем числитель: log₁₀(x)³
                double log10Cubed = Math.pow(log10, 3);

                // Вычисляем первую часть: (log₁₀(x)³ / ln(x))
                double firstPart = log10Cubed / ln;

                // Вторая часть в первых скобках: + log₂(x)
                double firstBrackets = firstPart + log2;

                // Вторые скобки: (ln(x) + log₃(x))
                double secondBrackets = ln + log3;

                // Умножаем результаты скобок
                double multiplication = firstBrackets * secondBrackets;

                // Добавляем окончательный ln(x)
                res = multiplication + ln;
            }
            double diff = Math.abs(res - calcMath(x));
//            System.out.println(res + " " + diff);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + x);
        }
    }

    @Test
    @DisplayName("Интеграционное тестирование, введение ln(x) в игру")
    public void testLn() {
        double accuracy = 0.1;
        double res;
        for (double x : keys) {
            if (x <= 0) {
                res = SecMock.calcSecMock(x);
            } else {
                double log10 = Math.log10(x);  // log₁₀(x)
                double ln = LogNaturalMock.calcLogNaturalMock(x);       // ln(x)

                // Вычисляем log₂(x) = ln(x)/ln(2)
                double log2 = ln / Math.log(2);

                // Вычисляем log₃(x) = ln(x)/ln(3)
                double log3 = ln / Math.log(3);

                // Вычисляем числитель: log₁₀(x)³
                double log10Cubed = Math.pow(log10, 3);

                // Вычисляем первую часть: (log₁₀(x)³ / ln(x))
                double firstPart = log10Cubed / ln;

                // Вторая часть в первых скобках: + log₂(x)
                double firstBrackets = firstPart + log2;

                // Вторые скобки: (ln(x) + log₃(x))
                double secondBrackets = ln + log3;

                // Умножаем результаты скобок
                double multiplication = firstBrackets * secondBrackets;

                // Добавляем окончательный ln(x)
                res = multiplication + ln;
            }
            double diff = Math.abs(res - calcMath(x));
//            System.out.println(diff + " " + x);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + x);
        }
    }

    @Test
    @DisplayName("Интеграционное тестирование, введение log₂(x) в игру")
    public void testLn2() {
        double accuracy = 0.1;
        double res;
        for (double x : keys) {
            if (x <= 0) {
                res = SecMock.calcSecMock(x);
            } else {
                double log10 = Math.log10(x);  // log₁₀(x)
                double ln = LogNaturalMock.calcLogNaturalMock(x);       // ln(x)

                // Вычисляем log₂(x) = ln(x)/ln(2)
                double log2 = LogCustomMock.calcLogWithBaseMock(x, 2);

                // Вычисляем log₃(x) = ln(x)/ln(3)
                double log3 = ln / Math.log(3);

                // Вычисляем числитель: log₁₀(x)³
                double log10Cubed = Math.pow(log10, 3);

                // Вычисляем первую часть: (log₁₀(x)³ / ln(x))
                double firstPart = log10Cubed / ln;

                // Вторая часть в первых скобках: + log₂(x)
                double firstBrackets = firstPart + log2;

                // Вторые скобки: (ln(x) + log₃(x))
                double secondBrackets = ln + log3;

                // Умножаем результаты скобок
                double multiplication = firstBrackets * secondBrackets;

                // Добавляем окончательный ln(x)
                res = multiplication + ln;
            }
            double diff = Math.abs(res - calcMath(x));
//            System.out.println(diff + " " + x);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + x);
        }
    }

    @Test
    @DisplayName("Интеграционное тестирование, введение log₃(x) в игру")
    public void testLn3() {
        double accuracy = 0.1;
        double res;
        for (double x : keys) {
            if (x <= 0) {
                res = SecMock.calcSecMock(x);
            } else {
                double log10 = Math.log10(x);  // log₁₀(x)
                double ln = LogNaturalMock.calcLogNaturalMock(x);       // ln(x)

                // Вычисляем log₂(x) = ln(x)/ln(2)
                double log2 = LogCustomMock.calcLogWithBaseMock(x, 2);

                // Вычисляем log₃(x) = ln(x)/ln(3)
                double log3 = LogCustomMock.calcLogWithBaseMock(x, 3);

                // Вычисляем числитель: log₁₀(x)³
                double log10Cubed = Math.pow(log10, 3);

                // Вычисляем первую часть: (log₁₀(x)³ / ln(x))
                double firstPart = log10Cubed / ln;

                // Вторая часть в первых скобках: + log₂(x)
                double firstBrackets = firstPart + log2;

                // Вторые скобки: (ln(x) + log₃(x))
                double secondBrackets = ln + log3;

                // Умножаем результаты скобок
                double multiplication = firstBrackets * secondBrackets;

                // Добавляем окончательный ln(x)
                res = multiplication + ln;
            }
            double diff = Math.abs(res - calcMath(x));
//            System.out.println(diff + " " + x);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + x);
        }
    }

    @Test
    @DisplayName("Интеграционное тестирование, введение log₁₀(x) в игру")
    public void testLn10() {
        double accuracy = 0.1;
        double res;
        for (double x : keys) {
            if (x <= 0) {
                res = SecMock.calcSecMock(x);
            } else {
                double log10 = LogCustomMock.calcLogWithBaseMock(x, 10);  // log₁₀(x)
                double ln = LogNaturalMock.calcLogNaturalMock(x);       // ln(x)

                // Вычисляем log₂(x) = ln(x)/ln(2)
                double log2 = LogCustomMock.calcLogWithBaseMock(x, 2);

                // Вычисляем log₃(x) = ln(x)/ln(3)
                double log3 = LogCustomMock.calcLogWithBaseMock(x, 3);

                // Вычисляем числитель: log₁₀(x)³
                double log10Cubed = Math.pow(log10, 3);

                // Вычисляем первую часть: (log₁₀(x)³ / ln(x))
                double firstPart = log10Cubed / ln;

                // Вторая часть в первых скобках: + log₂(x)
                double firstBrackets = firstPart + log2;

                // Вторые скобки: (ln(x) + log₃(x))
                double secondBrackets = ln + log3;

                // Умножаем результаты скобок
                double multiplication = firstBrackets * secondBrackets;

                // Добавляем окончательный ln(x)
                res = multiplication + ln;
            }
            double diff = Math.abs(res - calcMath(x));
//            System.out.println(diff + " " + x);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + x);
        }
    }
}
