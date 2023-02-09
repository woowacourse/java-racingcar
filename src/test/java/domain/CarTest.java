package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"3,3", "0,0", "213,213"}, delimiter = ',')
    void move(int moveCount, int expectedPosition) {
        Car car = new Car("dummy");

        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}