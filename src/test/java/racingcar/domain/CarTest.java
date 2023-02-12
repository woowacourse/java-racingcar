package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.provider.TestProvider;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.constant.CarConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

public class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = TestProvider.createTestCar("pobi");
    }

    @ParameterizedTest
    @DisplayName("Car 객체 생성 시 validation 정상적으로 작동한다.")
    @ValueSource(strings = {"junpk", "jney", "pobi", "neo"})
    void givenNormalCarName_thenSuccess(String carName) {
        assertThatCode(() -> Car.createCar(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("5글자 초과의 이름이 들어왔을 경우 예외가 발생한다.")
    @ValueSource(strings = {"junpak", "journey", "pobiconan", "neocat"})
    void givenFiveOverLength_thenFail(String carName) {
        assertThatThrownBy(() -> Car.createCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LENGTH_MESSAGE.getValue(), CAR_NAME_MAX_LENGTH.getValue()));
    }

    @ParameterizedTest
    @DisplayName("이름이 공백일 경우 예외가 발생한다.")
    @EmptySource
    void givenBlankName_thenFail(String carName) {
        assertThatThrownBy(() -> Car.createCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "이름"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("랜덤값이 4 이상이면 자동차가 전진한다.")
    void givenFourMoreNumber_thenCarMove(int randomNumber) {
        // given
        int initPosition = car.getPosition();

        // when
        car.move(randomNumber);

        // then
        assertThat(car.getPosition())
                .isEqualTo(initPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("랜덤값이 3 이하면 자동차가 정지한다.")
    void givenThreeLessNumber_thenCarStop(int randomNumber) {
        // given
        int initPosition = car.getPosition();

        // when
        car.move(randomNumber);

        // then
        assertThat(car.getPosition())
                .isEqualTo(initPosition);
    }
}
