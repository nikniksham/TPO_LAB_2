import com.nikolausus.tpo_lab_2.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class TestMainFunction {
    @Test
    @DisplayName("Тест с экспортируемым результатом в csv файл")
    public void testWithExport() throws IOException {
        FileWriter fileWriter = new FileWriter("test_results_function.csv");
        fileWriter.append("X value;Result\n");

        double step = 1;
        double start_val = -10;
        double finish_val = 10;

        double current_val = start_val;
        while (current_val < finish_val) {
            fileWriter.append(String.format("%.2f;%.5f\n", current_val, Main.calcFunc(current_val)));
            current_val += step;
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
