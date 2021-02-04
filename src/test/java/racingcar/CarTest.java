package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("joy");
    }

    @ParameterizedTest
    @DisplayName("4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.")
    @CsvSource(value = {"3,1", "4,2"})
    void drive_validNumber(Integer input, Integer expected) {
        car.drive(input);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("drive에 범위를 벗어난 값을 줌")
    @CsvSource(value = {"-1", "10"})
    void drive_invalidNumber(Integer input) {
        assertThatThrownBy(() -> {
            car.drive(input);
        }).isInstanceOf(RuntimeException.class);
    }
}