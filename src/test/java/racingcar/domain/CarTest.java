package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차")
class CarTest {

    @DisplayName("적절하지 않은 이름은 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"chocochip"})
    public void testInvalidName(String name) {
        //given & when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
}