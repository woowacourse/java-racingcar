package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @DisplayName("4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.")
    @CsvSource(value = {"3,0", "4,1"})
    void drive(Integer input, Integer expected) {
        car.drive(input);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}