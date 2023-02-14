package racingcar.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.constant.CarConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("정상적인 차 이름이 들어오면 CarName 객체 시 예외가 발생하지 않는다.")
    @ValueSource(strings = {"junpk", "jney", "pobi", "neo"})
    void givenNormalCarName_thenSuccess(final String carName) {
        assertThat(CarName.create(carName))
                .isInstanceOf(CarName.class);

        assertThatCode(() -> CarName.create(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("5글자 초과의 이름이 들어왔을 경우 예외가 발생한다.")
    @ValueSource(strings = {"junpak", "journey", "pobiconan", "neocat"})
    void givenFiveOverLength_thenFail(final String carName) {
        assertThatThrownBy(() -> CarName.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LENGTH_MESSAGE.getValue(), CAR_NAME_MAX_LENGTH.getValue()));
    }

    @ParameterizedTest
    @DisplayName("이름이 공백일 경우 예외가 발생한다.")
    @EmptySource
    void givenBlankName_thenFail(final String carName) {
        assertThatThrownBy(() -> CarName.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "이름"));
    }
}