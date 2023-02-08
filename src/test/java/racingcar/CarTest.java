package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "wugawuga"})
    @DisplayName("자동차 생성 시 이름이 한 글자에서 다섯 글자가 아닐 때 예외")
    void validateName(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 최소 한글자, 최대 다섯글자까지 가능해요.");
    }
}