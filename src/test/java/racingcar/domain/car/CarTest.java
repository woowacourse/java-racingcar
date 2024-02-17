package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidCarNameLengthException;

class CarTest {

    private Car car;
    private static final String VALID_CAR_NAME = "조조는조조";

    @BeforeEach
    void initCar() {
        car = new Car(VALID_CAR_NAME);
    }

    @DisplayName("이름이 1자 미만 5자 초과이면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"점심은순두부", "1234567", ""})
    void testInvalidNameLength(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(InvalidCarNameLengthException.class);
    }

    @DisplayName("이름이 1자 이상 5자 이내이면 예외를 던지지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"점심순두부", "1"})
    void testValidNameLength(String carName) {
        assertDoesNotThrow(() -> new Car(carName));
    }

    @DisplayName("오일이 4 미만이면 이동하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void testDoNotGoIfOilNotEnough(int oil) {
        car.goIfOilEnough(oil);
        assertTrue(() -> car.isSameDistance(0));
    }

    @DisplayName("오일이 4 이상이면 이동한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testGoIfOilEnough(int oil) {
        car.goIfOilEnough(oil);
        assertTrue(() -> car.isSameDistance(1));
    }
}
