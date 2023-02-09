package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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