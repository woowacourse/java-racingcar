package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @DisplayName("공백 포함시 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"asd ", "asd ", " asd ", "a s d"})
    void hasBlankException(String carName) {
        assertThatThrownBy(() -> new CarName(carName)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백");
    }

    @DisplayName("문자열 5글자 초과 때 잡는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바", "123456"})
    void overFive(String carName) {
        assertThatThrownBy(() -> new CarName(carName)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자 이상 이름은 허용되지 않습니다");
    }
}
