package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarProcessingTest {

    CarProcessing carProcessing;
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        carProcessing = new CarProcessing();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
    }

    @Test
    void 제대로_자동차리스트가_리턴되는지_테스트() {
        List<Car> cars = carProcessing.createCar("a,b,c,d".split(","));
        System.out.println(cars.toString());
    }

    @Test
    void 자동차가_움직이는지_테스트() {
        List<Car> resultCars = carProcessing.race(cars, 5);
        assertThat(resultCars.toString()).isEqualTo("[-\n, -\n]");
    }

    @Test
    void 자동차가_안움직이는지_테스트() {
        List<Car> resultCars = carProcessing.race(cars, 4);
        assertThat(resultCars.toString()).isEqualTo("[\n, \n]");
    }
}