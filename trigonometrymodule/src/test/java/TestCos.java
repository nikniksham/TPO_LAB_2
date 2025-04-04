import com.nikolausus.tpo_lab_2.Cos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class TestCos {
    @Test
    @DisplayName("Проверка погрешности вычислений")
    public void checkTableComputation() {
        double accuracy = 0.001;
        for (int i = -600; i < 601; ++i) {
            double test_val = (double)i/10 * Math.PI;
            double my_res = Cos.calcCos(test_val);
            double exactly_res = Math.cos(test_val);
            double diff = Math.abs(my_res - exactly_res);
//            System.out.println(test_val + " ---> " + diff);
            Assertions.assertFalse(diff > accuracy, "Нарушена заданная точность в " + accuracy + ", переданное значение: " + test_val);
        }
    }

    @Test
    @DisplayName("Тест с экспортируемым результатом в csv файл")
    public void testWithExport() throws IOException {
        FileWriter fileWriter = new FileWriter("test_results_Cos.csv");
        fileWriter.append("X value;Result\n");

        double step = 1;
        double start_val = -50;
        double finish_val = 50;

        double current_val = start_val;
        while (current_val < finish_val) {
            fileWriter.append(String.format("%.2f;%.5f\n", current_val, Cos.calcCos(current_val)));
            current_val += step;
        }

        fileWriter.flush();
        fileWriter.close();

    }
}
