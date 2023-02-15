package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Nested
    @DisplayName("자동차 이름에 대한 예외 테스트")
    class CarNameLengthTest {
        @Test
        @DisplayName("자동차 이름의 길이가 5자를 초과하면 예외가 발생한다.")
        void overLengthCarNameTest() {
            assertThatThrownBy(() -> new CarName("hello world"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름의 길이는 1이상 5이하여야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"  ", ""})
        @DisplayName("자동차 이름의 길이가 1자 미만이거나 빈칸으로만 이루어진 경우 예외가 발생한다.")
        void underLengthCarNameTest(String name) {
            assertThatThrownBy(() -> new CarName(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름의 길이는 1이상 5이하여야 합니다.");
        }
    }
}
