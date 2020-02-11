package stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileInputStream;
import java.util.Scanner;

public class StringCalculatorTest {

    public static final String INPUT_EXPECTED_DIVIDER = "->";

    @Test
    @DisplayName("콤마 계산 테스트")
    void commmaCalculateTest() throws Exception {
        String input;
        String expected;
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/commaCalculateTestcase");
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            String[] raw = scanner.nextLine().split(INPUT_EXPECTED_DIVIDER);
            input = raw[0];
            expected = raw[1];
            
            Assertions.assertThat(Calculator.calculate(input)).isEqualTo(Double.parseDouble(expected));
        }
        fileInputStream.close();
    }

    @Test
    @DisplayName("콤마, 콜론 혼용 계산 테스트")
    void commmaColonCalculateTest() throws Exception {
        String input;
        String expected;
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/commaColonCalculateTestcase");
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            String[] raw = scanner.nextLine().split(INPUT_EXPECTED_DIVIDER);
            input = raw[0];
            expected = raw[1];

            Assertions.assertThat(Calculator.calculate(input)).isEqualTo(Double.parseDouble(expected));
        }
        fileInputStream.close();
    }
}
