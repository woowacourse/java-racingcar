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
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        //when
        car1.moveWith(new FixedEngine());
        car2.moveWith(new FixedEngine());

        //then
        assertThat(cars.getWinner()).isEqualTo(new Winners(Arrays.asList(car1, car2)));
    }

    @DisplayName("전체 차량 움직이기")
    @Test
    void move1() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        //when
        cars.move(new FixedEngine());

        //then
        Car expect1 = new Car("a");
        Car expect2 = new Car("b");
        Car expect3 = new Car("c");
        expect1.moveWith(new FixedEngine());
        expect2.moveWith(new FixedEngine());
        expect3.moveWith(new FixedEngine());

        assertThat(cars).isEqualTo(new Cars(Arrays.asList(expect1, expect2, expect3)));
    }
}