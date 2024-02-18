package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @DisplayName("자동차 이름에는 null 값이나, 1~5 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "123456"})
    void exceptionInvalidInput(String given) {
        //given, when, then
        assertThatThrownBy(() -> new CarName(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 1-5")
                .hasMessageContaining("자 사이의 길이로 입력되지 않았습니다.");
    }
}
