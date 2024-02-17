package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.TryCount;

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
        @Test
        @DisplayName("시도 횟수를 한 번 소비하면, 값이 1만큼 감소하는지 확인")
        void testConsume() {
            TryCount count = new TryCount("5");
            count.consume();

            int actualValue = count.getValue();
            int expectedValue = 4;

            assertThat(actualValue).isEqualTo(expectedValue);
        }

        @ParameterizedTest
        @CsvSource({"0,false",
                "1,true"})
        @DisplayName("시도 횟수 값이 게임엔드라인(0) 이하인지 아닌지를 잘 구별하는지 확인")
        void testUntilZero(String given, boolean expected) {
            TryCount count = new TryCount(given);

            boolean actual = count.untilEndLine();

            assertThat(actual).isEqualTo(expected);
        }
    }
}
