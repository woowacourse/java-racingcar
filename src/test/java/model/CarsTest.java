package model;

import static fixture.CarFixture.자동차;
import static fixture.CarFixture.자동차들;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;
import support.MovableNumberGenerator;
import util.NumberGenerator;

class CarsTest {
    private final NumberGenerator movableNumberGenerator = new MovableNumberGenerator();

    @Test
    void 중복된_자동차가_존재하지_않으면_예외가_발생하지_않는다() {
        // given

        Car car1 = 자동차("pobi");
        Car car2 = 자동차("crong");
        Car car3 = 자동차("honux");
        List<Car> cars = List.of(car1, car2, car3);

        // when & then
        assertDoesNotThrow(() -> new Cars(cars));
    }

    @Test
    void 중복된_자동차가_존재하면_예외가_발생한다() {
        // given
        Car car1 = 자동차("pobi");
        Car car2 = 자동차("pobi");
        Car car3 = 자동차("honux");
        List<Car> cars = List.of(car1, car2, car3);

        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 단독_우승자를_찾는다() {
        // given
        Car car1 = 자동차("prin");
        Car car2 = 자동차("mark");
        Car car3 = 자동차("pobi");
        Cars cars = 자동차들(car1, car2, car3);
        car1.moveForward(movableNumberGenerator);

        // when
        List<String> winners = cars.findWinners();

        // then
        assertThat(winners).hasSize(1)
                .contains(car1.getName());
    }

    @Test
    void 공동_우승자를_찾는다() {
        // given
        Car car1 = 자동차("prin");
        Car car2 = 자동차("mark");
        Car car3 = 자동차("pobi");
        Cars cars = 자동차들(car1, car2, car3);
        car2.moveForward(movableNumberGenerator);
        car3.moveForward(movableNumberGenerator);

        // when
        List<String> winners = cars.findWinners();

        // then
        assertThat(winners).hasSize(2)
                .contains(car2.getName(), car3.getName());
    }
}
