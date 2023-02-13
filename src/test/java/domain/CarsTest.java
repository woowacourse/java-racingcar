package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    Cars cars;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setUp() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        car1.move(4);
        car2.move(4);
        car2.move(4);
        car3.move(4);

        cars = new Cars();

        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
    }


    @Test
    @DisplayName("car1과 같은 위치에 있는 자동차는 car1과 car3")
    void findSamePositionCar() {
        assertThat(cars.findSamePositionCar(car1)).isEqualTo(List.of(car1, car3));
    }

    @Test
    @DisplayName("가장 위치가 높은 자동차는 car2")
    void findMaxPositionCar() {
        assertThat(cars.findMaxPositionCar()).isEqualTo(car2);
    }
}