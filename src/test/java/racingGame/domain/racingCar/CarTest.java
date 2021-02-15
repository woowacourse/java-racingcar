package racingGame.domain.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class CarTest {

    @DisplayName("이름의 길이가 유효하지 않는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "abcdefg"})
    void expectInvalidLengthExceptionTest(String name) {
        assertThatThrownBy(() ->
                Car.createByName(Name.create(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름으로 null이 입력된 경우")
    @ParameterizedTest
    @NullSource
    void expectNullExceptionTest(String name) {
        assertThatThrownBy(() ->
                Car.createByName(Name.create(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 유효한 경우의 Car 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "jin", "corgi"})
    void checkInstanceWithValidName(String name) {
        Car.createByName(Name.create(name));
    }

    private Car testCar;

    @BeforeEach
    void set() {
        testCar = Car.createByName(Name.create("test"));
    }

    @DisplayName("4이상의 값에 자동차 이동")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    void hasToMove(int injectionValue) {
        int initialPosition = 0;

        assertThat(testCar.isOnPosition(initialPosition)).isEqualTo(true);

        testCar.tryToMove(injectionValue);

        assertThat(testCar.isOnPosition(initialPosition + 1)).isEqualTo(true);
    }

    @DisplayName("3이하의 값에 자동차 이동")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void hasToStop(int injectionValue) {
        int initialPosition = 0;

        assertThat(testCar.isOnPosition(initialPosition)).isEqualTo(true);

        testCar.tryToMove(injectionValue);

        assertThat(testCar.isOnPosition(initialPosition)).isEqualTo(true);
    }
}
