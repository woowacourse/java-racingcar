package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.engine.FixedEngine;

class CarsTest {

    Car movableCar1;
    Car nonMovableCar1;

    @BeforeEach
    public void setUp() {
        movableCar1 = new Car("pobi", new FixedEngine(9));
        nonMovableCar1 = new Car("lose1", new FixedEngine(0));
    }

    @Test
    public void 자동차_움직임_테스트() {
        // given
        Cars cars = new Cars(Arrays.asList(movableCar1, nonMovableCar1));

        // when
        for (int i = 0; i < 5; i++) {
            cars.move();
        }

        // then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(Position.of(5));
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(Position.of(0));
    }

    @Test
    public void 우승자_판별_테스트() {
        // given
        Car movableCar2 = new Car("crong", new FixedEngine(9));
        Car movableCar3 = new Car("kim", new FixedEngine(9));

        Car nonMovableCar2 = new Car("lose2", new FixedEngine(0));
        Cars cars = new Cars(Arrays.asList(movableCar1, movableCar2, movableCar3, nonMovableCar1, nonMovableCar2));

        // when
        for (int i = 0; i < 5; i++) {
            cars.move();
        }

        // then
        assertThat(cars.getWinners()).isEqualTo("pobi,crong,kim");
    }

}