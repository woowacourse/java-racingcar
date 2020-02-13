package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 덧셈() {
        int result = StringCalculator.plusByDelimiterFrom("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 덧셈세개() {
        int result = StringCalculator.plusByDelimiterFrom("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 덧셈커스텀() {
        int result = StringCalculator.plusByDelimiterFrom("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }


    @Test
    void 음수_예외처리() {
        assertThatThrownBy(() -> StringCalculator.plusByDelimiterFrom("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 비어있는_문자열_null_전달시_예외() {
        assertThat(StringCalculator.plusByDelimiterFrom("")).isEqualTo(0);

        assertThat(StringCalculator.plusByDelimiterFrom(null)).isEqualTo(0);
    }

    @Test
    void 숫자_하나만_넣었을경우_그대로_리턴() {
        assertThat(StringCalculator.plusByDelimiterFrom("1")).isEqualTo(1);
    }

    @Test
    void split학습테스트() {
        String[] values = "1,2:3,4:5".split(",|:");
        assertThat(values.length).isEqualTo(5);
    }

    @Test
    void 정규표현식학습테스트() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("//;\n1,2,3");
        if (m.find()) {
            assertThat(m.group(1)).isEqualTo(";");
            assertThat(m.group(2)).isEqualTo("1,2,3");
        }
    }

    @Test
    void 정규표현식학습테스트2() {
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher("//\n1,2,3");
        if (m.find()) {
            assertThat(m.group(1)).isEqualTo("");
            assertThat(m.group(2)).isEqualTo("1,2,3");
        }
    }
}
