package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.trycount.TryCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarsTest {
    @DisplayName("moveAll 메소드는")
    @Test
    void 모든_차를_움직인다() {
        Cars cars = Cars.create();
        cars.add(Car.of("car1", 0, (min, max) -> 5));
        cars.add(Car.of("car2", 0, (min, max) -> 0));
        cars.add(Car.of("car3", 0, (min, max) -> 5));
        cars.moveAll(TryCount.from(1));

        assertThat(cars.toString())
                .isEqualTo("car1 : -\ncar2 : \ncar3 : -");
    }

    @DisplayName("getFirstPosition 메소드는")
    @Nested
    class GetFirstPosition {
        @Test
        void 가장_멀리간_차의_위치를_가져온다() {
            Cars cars = Cars.create();
            cars.add(Car.of("car1", 5));
            cars.add(Car.of("car2", 3));
            cars.add(Car.of("car3", 8));

            assertThat(cars.getFirstPosition())
                    .isEqualTo(Position.from(8));
        }

        @Test
        void 아무_차가_없다면() {
            Cars cars = Cars.create();
            assertThatThrownBy(cars::getFirstPosition)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

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
