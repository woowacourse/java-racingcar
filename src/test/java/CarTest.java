import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("jerry");
    }

    @Test
    void testToString() {
        for (int i = 0; i < 5; i++) {
            car.move(4);
        }
        assertThat(car.toString().split(": ")[1].length())
                .isEqualTo(car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void moveTest(int number) {
        for (int i = 0; i < number; i++) {
            car.move(4);
        }
        Assertions.assertEquals(car.getPosition(), number);
    }
}