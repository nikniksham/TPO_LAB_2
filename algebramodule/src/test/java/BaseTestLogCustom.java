import com.nikolausus.tpo_lab_2.LogCustom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class BaseTestLogCustom {
    @Test
    @DisplayName("Проверка невозможности вычислить значение < 0")
    public void cantCalcBelowZero() {
        try {
            LogCustom.calcLogWithBase(-1, 2);
            Assertions.assertTrue(false, "Логарифм вычислился, так не должно быть!");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "ln(x) -> x должен быть > 0", "Ошибка неправильная");
        }
    }

    @Test
    @DisplayName("Проверка невозможности вычислить значение == 0")
    public void cantCalcZero() {
        try {
            LogCustom.calcLogWithBase(0, 2);
            Assertions.assertTrue(false, "Логарифм вычислился, так не должно быть!");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "ln(x) -> x должен быть > 0", "Ошибка неправильная");
        }
    }

    @Test
    @DisplayName("Проверка невозможности вычислить логарифм с основанием < 0")
    public void cantCalcBaseBelowZero() {
        try {
            LogCustom.calcLogWithBase(1, -1);
            Assertions.assertTrue(false, "Логарифм вычислился, так не должно быть!");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "Основание логарифма должно быть > 0", "Ошибка неправильная");
        }
    }

    @Test
    @DisplayName("Проверка невозможности вычислить логарифм с основанием == 1")
    public void cantCalcBaseOne() {
        try {
            LogCustom.calcLogWithBase(1, 1);
            Assertions.assertTrue(false, "Логарифм вычислился, так не должно быть!");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "Основание логарифма не может быть равно 1", "Ошибка неправильная");
        }
    }

    @Test
    @DisplayName("Проверка погрешности вычислений")
    public void checkTableComputation() {
        double accuracy = 0.1;
        double[] test = {0.01, 0.05, 0.1, 0.25, 0.4, 0.5, 0.8, 1, 1.25, 1.5, 2, 3, 5, 10, 100, 5000, 124421};
        double[] bases = {0.1, 0.25, 0.5, 1.25, 1.5, 2, 3, 5, 10, 100, 5000};

        for (double val : test) {
            for (double bas : bases) {
                double my_res = LogCustom.calcLogWithBase(val, bas);
                double exactly_res = Math.log(val) / Math.log(bas);
                double diff = Math.abs(my_res - exactly_res);
//                System.out.println(val + " " + bas + " ---> " + diff);
                Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + val + ", основание: " + bas);
            }
        }
    }

    @Test
    @DisplayName("Тест с экспортируемым результатом в csv файл")
    public void testWithExport() throws IOException {
        FileWriter fileWriter = new FileWriter("test_results_logCustom.csv");
        fileWriter.append("X value;Base;Result\n");

        double step = 0.1;
        double start_val = 0.1;
        double finish_val = 10;
        double base = 10;

        double current_val = start_val;
        while (current_val < finish_val) {
            fileWriter.append(String.format("%.2f;%.2f;%.5f\n", current_val, base, LogCustom.calcLogWithBase(current_val, base)));
            current_val += step;
        }

        fileWriter.flush();
        fileWriter.close();

    }
}

