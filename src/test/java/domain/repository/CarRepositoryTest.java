package domain.repository;

import domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarRepositoryTest {

    @DisplayName("자동차 객체가 올바르게 생성되어야 한다.")
    @Test
    void 자동차_객체_생성() {
        String[] carsName = new String[] {"abc"};
        CarRepository carRepository = new CarRepository();

        List<Car> cars = carRepository.createCars(carsName);
        org.assertj.core.api.Assertions.assertThat(cars.get(0).getClass()).isEqualTo(Car.class);
    }

    @DisplayName("자동차 객체가 생성될 때 자동차 이름이 부여된다.")
    @Test
    void 자동차_객체생성시_이름_확인() {
        String[] carsName = new String[] {"abc", "def"};
        CarRepository carRepository = new CarRepository();

        List<Car> cars = carRepository.createCars(carsName);
        Assertions.assertEquals(cars.get(0).getName(), "abc");
        Assertions.assertEquals(cars.get(1).getName(), "def");
    }
}