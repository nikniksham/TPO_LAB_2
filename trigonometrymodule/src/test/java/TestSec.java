import com.nikolausus.tpo_lab_2.Sec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class TestSec {
    @Test
    @DisplayName("Проверка погрешности вычислений")
    public void checkTableComputation() {
        double accuracy = 0.001;
        for (int i = -60; i < 61; ++i) {
            double test_val = (double)i * Math.PI;
            double my_res = Sec.calcSec(test_val);
            double exactly_res = 1/Math.cos(test_val);
            double diff = Math.abs(my_res - exactly_res);
//            System.out.println(test_val + " ---> " + diff);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + test_val);
        }
    }

//    @Test
//    @DisplayName("Проверка граничных значений")
//    public void testBord() {
//        try {
//            Sec.calcSec(-Math.PI/2);
//            Assertions.assertTrue(false, "Логарифм вычислился, так не должно быть!");
//        } catch (Exception e) {
//            Assertions.assertEquals(e.getMessage(), "sec(x) не может быть вычислен для x = pi * 1/2, pi * 3/2 ...", "Ошибка неправильная");
//        }
//    }

    @Test
    @DisplayName("Тест с экспортируемым результатом в csv файл")
    public void testWithExport() throws IOException {
        FileWriter fileWriter = new FileWriter("test_results_Sec.csv");
        fileWriter.append("X value;Result\n");

        double step = 1;
        double start_val = -50;
        double finish_val = 50;

        double current_val = start_val;
        while (current_val < finish_val) {
            fileWriter.append(String.format("%.2f;%.5f\n", current_val, Sec.calcSec(current_val)));
            current_val += step;
        }

        fileWriter.flush();
        fileWriter.close();

    }
}
