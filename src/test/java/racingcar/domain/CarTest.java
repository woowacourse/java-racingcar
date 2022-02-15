package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.car.Car;
import racingcar.exception.RacingCarIllegalArgumentException;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameNullException;
import racingcar.exception.car.CarNameTooLongException;

class CarTest {

    private void exceptionTest(Class exceptionClass, String name) {
        assertThrows(exceptionClass, () -> new Car(name));
    }

    @DisplayName("자동차 이름은 NULL이 될 수 없다.")
    @ParameterizedTest
    @NullSource
    void carNameNullExceptionTest(String name) {
        exceptionTest(CarNameNullException.class, name);
    }

    @DisplayName("자동차 이름은 공백이 될 수 없다.")
    @ParameterizedTest
    @EmptySource
    void carNameEmptyExceptionTest(String name) {
        exceptionTest(CarNameEmptyException.class, name);
    }

    @DisplayName("자동차 이름은 5자를 넘길 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "12345678"})
    void carNameTooLongExceptionTest(String name) {
        exceptionTest(CarNameTooLongException.class, name);
    }

    @DisplayName("생성자 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "poby", "if", "hanul"})
    void constructorTest(String name) {
        assertDoesNotThrow(() -> new Car(name));
    }

}
