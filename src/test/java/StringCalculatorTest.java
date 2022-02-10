import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 콤마_더하기() {
        int actual = StringCalculator.calculate("1,2");
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void 콜론_더하기() {
        int actual = StringCalculator.calculate("1:2:3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 혼합_더하기() {
        int actual = StringCalculator.calculate("1,2:3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 구분자로_나누기() {
        String radix = ",|:";
        String[] splitString = "1,2,3".split(radix);
        assertThat(splitString).contains("1", "2", "3");
    }

    @Test
    void 정수형_배열로_바꾸기() {
        String[] testData = {"1", "2", "3"};
        int[] changed = StringCalculator.toIntArray(testData);
        assertThat(changed).contains(1, 2, 3);
    }

    @Test
    void 배열_더하기() {
        int[] numberList = {1, 2, 3};
        int sum = StringCalculator.sumOfList(numberList);
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 구분자_추출() {
        String target = "//;\n";
        String deli = StringCalculator.extractCustomDelimiter(target);
        assertThat(deli).isEqualTo(";");
    }
}
