package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarsTest {
    @DisplayName("add 메소드는")
    @Nested
    class Add {
        @Test
        void 중복_이름이_입력되었다면() {
            Cars cars = Cars.create();
            cars.add(Car.from("car1"));

            assertThatThrownBy(() -> cars.add(Car.from("car1")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 중복_이름이_입력되지았다면() {
            Cars cars = Cars.create();
            cars.add(Car.from("car1"));

            assertDoesNotThrow(() -> cars.add(Car.from("car2")));
        }
    }
}
