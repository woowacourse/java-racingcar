package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.enumType.ExceptionMessage.*;

public class CarTest {

    @ParameterizedTest
    @DisplayName("Car 객체 생성 시 validation 정상적으로 작동한다.")
    @ValueSource(strings = {"junpk", "jney", "pobi", "neo"})
    void givenNormalCarName_thenSuccess(String carName) {
        assertThatCode(() -> Car.of(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("5글자 초과의 이름이 들어왔을 경우 예외가 발생한다.")
    @ValueSource(strings = {"junpak", "journey", "pobiconan", "neocat"})
    void givenFiveOverLength_thenFail(String carName) {
        assertThatThrownBy(() -> Car.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_MESSAGE.getValue());
    }

    @ParameterizedTest
    @DisplayName("이름이 공백일 경우 예외가 발생한다.")
    @EmptySource
    void givenBlankName_thenFail(String carName) {
        assertThatThrownBy(() -> Car.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_MESSAGE.getValue());
    }
}
