package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.car.Car;
import racingCar.domain.car.Cars;
import racingCar.domain.car.Engine.FixedEngine;

public class CarsTest {

    @Test
    public void create() {
        final Cars cars = new Cars(
            Arrays.asList(
                new Car("jason", new FixedEngine(2)),
                new Car("pobi", new FixedEngine(3))
            )
        );
        assertThat(cars.toList()).contains(new Car("jason", new FixedEngine(2)),
            new Car("pobi", new FixedEngine(3)));
    }

    @DisplayName("경주하는 자동차는 2개 이상이어야 한다")
    @Test
    public void 자동차_갯수_2개_이상_negative() {
        // given, when
        final List<Car> carList = new ArrayList<>();
        carList.add(new Car("jason", new FixedEngine(0)));

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Cars(carList));
    }

    @Test
    public void 방어적_복사() {
        final List<Car> cars = new ArrayList<>();
        final Cars actual = new Cars(cars);

        cars.add(new Car("jason", new FixedEngine(0)));

        assertThat(actual.toList()).isEmpty();

        actual.toList().add(new Car("jason", new FixedEngine(0)));
        assertThat(actual.toList()).isEmpty();
    }

    @Test
    public void 우승자_찾기() {
        final Cars cars = new Cars(
            Arrays.asList(
                new Car("jason", 5, new FixedEngine(2)),
                new Car("pobi", 10, new FixedEngine(3)),
                new Car("hodol", 10, new FixedEngine(3))
            )
        );
        assertThat(cars.findWinners()).isEqualTo("pobi, hodol");
    }

}
