package stringCalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    static class StringCalculator {
        private static final String DEFAULT_DELIMITER = ",|:";
        private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

        public static int splitAndSum(String expression) {
            if (isNullOrEmpty(expression)) {
                return 0;
            }
            Matcher matcher = PATTERN.matcher(expression);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                String[] tokens = matcher.group(2)
                        .split(customDelimiter);
                return sumValues(tokens);

            }

            String[] values = expression.split(DEFAULT_DELIMITER);
            return sumValues(values);
        }

        public static boolean isNullOrEmpty(String expression) {
            return Objects.isNull(expression) || expression.isEmpty();
        }

        public static int sumValues(String[] values) {
            return Arrays.stream(values)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
    }
}