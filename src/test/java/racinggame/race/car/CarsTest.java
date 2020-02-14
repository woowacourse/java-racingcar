package racinggame.race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.race.car.engine.FixedEngine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("우승한 차량 찾기")
    @Test
    void getWinner1() {
        //given
        Car car1 = new Car("a", new FixedEngine());
        Car car2 = new Car("b", new FixedEngine());
        Car car3 = new Car("c", new FixedEngine());
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        //when
        car1.move();
        car2.move();

        //then
        assertThat(cars.getWinner()).isEqualTo(new Winners(Arrays.asList(car1, car2)));
    }

    @DisplayName("전체 차량 움직이기")
    @Test
    void move1() {
        //given
        Car car1 = new Car("a", new FixedEngine());
        Car car2 = new Car("b", new FixedEngine());
        Cars cars = new Cars(Arrays.asList(car1, car2));

        //when
        cars.move();

        //then
        assertThat(car1.getDistance()).isEqualTo(2);
        assertThat(car2.getDistance()).isEqualTo(2);
    }
}