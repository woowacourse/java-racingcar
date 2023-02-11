package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"3,3", "0,0", "213,213"}, delimiter = ',')
    void carMoveTest(final int moveCount, final int expectedPosition) {
        Car car = new Car("dummy");

        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hadddy", "edannnn", "abcdef"})
    @DisplayName("자동차 이름은 5자가 넘으면 안된다.")
    void carConstructTest(final String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름의 길이가 5글자를 넘습니다.");
    }
}
