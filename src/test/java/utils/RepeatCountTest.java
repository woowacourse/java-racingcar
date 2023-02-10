package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RepeatCountTest {

    @ParameterizedTest
    @CsvSource({"''", "abc", "+-", ",./"})
    void validateNotNumberTest(String line) {
        assertThatThrownBy(() -> new RepeatCount(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 횟수는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({"-1", "0", "100"})
    void validateInvalidCountTest(String line) {
        assertThatThrownBy(() -> new RepeatCount(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 횟수는 1부터 99까지 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource({"1", "5"})
    void validateTest2(String line) {
        assertThatCode(() -> new RepeatCount(line))
                .doesNotThrowAnyException();
    }

    @Test
    void hasNextTest() {
        RepeatCount repeatCount = new RepeatCount("5");
        int count = 0;
        while (repeatCount.hasNext()) {
            count++;
        }
        assertThat(count).isEqualTo(5);
    }
}
