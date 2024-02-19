package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {

    @Nested
    class ValidateInput {
        @Test
        @DisplayName("입력값이 문자이면 예외를 발생한다.")
        void testIsNotNumeric() {
            String given = "문자열";
            assertThatThrownBy(() -> new TryCount(given))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값이 음수이면 예외를 발생한다.")
        void testIsMinusValue() {
            String given = "-1";
            assertThatThrownBy(() -> new TryCount(given))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Feature {
        @ParameterizedTest
        @CsvSource({ "0,false",
                "1,true" })
        @DisplayName("시도회수가 1 이상이면 시도가 가능하고, 0이면 시도를 할 수 없다.")
        void testUntilZero(String given, boolean expected) {
            TryCount count = new TryCount(given);
            boolean actual = count.checkTryable();
            assertThat(actual).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 2, 3, 4, 5, 10 })
        @DisplayName("설정한 시도회수 만큼 반복문이 동작한다.")
        void testConsume(Integer givenCount) {
            TryCount count = new TryCount(givenCount.toString());
            int repeatCount = 0;

            while (count.checkTryable()) {
                repeatCount++;
                count.consume();
            }

            assertThat(repeatCount).isEqualTo(givenCount);
        }
    }

}
