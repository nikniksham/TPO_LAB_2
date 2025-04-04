import com.nikolausus.tpo_lab_2.LogNatural;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class BaseTestLogNatural {
    @Test
    @DisplayName("Проверка невозможности вычислить значение < 0")
    public void cantCalcBelowZero() {
        try {
            LogNatural.calcLog(-1);
            Assertions.assertTrue(false, "Логарифм вычислился, так не должно быть!");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "ln(x) -> x должен быть > 0", "Ошибка неправильная");
        }
    }

    @Test
    @DisplayName("Проверка невозможности вычислить значение == 0")
    public void cantCalcZero() {
        try {
            LogNatural.calcLog(0);
            Assertions.assertTrue(false, "Логарифм вычислился, так не должно быть!");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "ln(x) -> x должен быть > 0", "Ошибка неправильная");
        }
    }

    @Test
    @DisplayName("Проверка погрешности вычислений")
    public void checkTableComputation() {
        double accuracy = 0.01;
        double[] test = {0.01, 0.05, 0.1, 0.25, 0.4, 0.5, 0.8, 1, 1.25, 1.5, 2, 3, 5, 10, 100, 5000, 124421};
        for (double val : test) {
            double my_res = LogNatural.calcLog(val);
            double exactly_res = Math.log(val);
            double diff = Math.abs(my_res - exactly_res);
//            System.out.println(val + " ---> " + diff);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + val);
        }
    }

    @Test
    @DisplayName("Тест с экспортируемым результатом в csv файл")
    public void testWithExport() throws IOException {
        FileWriter fileWriter = new FileWriter("test_results_logNatural.csv");
        fileWriter.append("X value;Result\n");

        double step = 0.1;
        double start_val = 0.1;
        double finish_val = 10;

        double current_val = start_val;
        while (current_val < finish_val) {
            fileWriter.append(String.format("%.2f;%.5f\n", current_val, LogNatural.calcLog(current_val)));
            current_val += step;
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
