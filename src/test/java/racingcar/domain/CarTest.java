package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Nested
    @DisplayName("자동차 이름 길이 테스트")
    class TestNameLength {
        @ParameterizedTest(name = "{index} ==> name : ''{0}''")
        @ValueSource(strings = {"", "abcdef", "pobiiiiii"})
        @DisplayName("자동차 이름의 길이가 0 이하거나 5보다 클 경우 예외 발생")
        void Should_ThrowException_길이가_0이하거나_5보다_큰_경우(String name) {
            assertThatThrownBy(() -> new Car(name, 0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 자동차 이름의 길이는 1부터 5 사이여야 합니다.");
        }

        @ParameterizedTest(name = "{index} ==> name : ''{0}''")
        @ValueSource(strings = {"a", "abc", "abcde"})
        @DisplayName("자동차 이름의 길이가 1 이상 5 이하인 경우 성공")
        void Should_Success_길이가_1이상_5이하인_경우(String name) {
            assertDoesNotThrow(() -> new Car(name, 0));
        }
    }
}
