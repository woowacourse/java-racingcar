package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

class CarTest {

    @DisplayName("Car 객체 생성 시")
    @Nested
    class ValidationTest {
        @ParameterizedTest
        @DisplayName("validation이 정상적으로 작동한다.")
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

    @DisplayName("자동차 경주시,")
    @Nested
    class MoveTest {

        @ParameterizedTest
        @ValueSource(ints = {4, 9})
        @DisplayName("랜덤값이 4 이상이면 자동차가 전진한다.")
        void givenFourMoreNumber_thenCarMove(int randomNumber) {
            Car car = Car.of("BMW");
            car.move(randomNumber);
            assertThat(car.getCarStatus().getPosition()).isEqualTo(2);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 3})
        @DisplayName("랜덤값이 4 이하면 자동차가 이동하지 않는다.")
        void givenThreeLessNumber_thenCarMove(int randomNumber) {
            Car car = Car.of("BMW");
            car.move(randomNumber);
            assertThat(car.getCarStatus().getPosition()).isEqualTo(1);
        }

    }

}