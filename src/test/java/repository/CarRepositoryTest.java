package repository;

import domain.Car;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {

    private CarRepository carRepository;

    @BeforeEach
    void before() {
        carRepository = new CarRepository();
    }

    @Test
    void 참가자_등록_테스트() {
        //given
        final String name1 = "asd";
        final String name2 = "asdf";
        List<Car> cars = List.of(new Car(name1, 0), new Car(name1, 1), new Car(name2, 0));
        //when
        carRepository.add(name1);
        carRepository.add(name1);
        carRepository.add(name2);
        //then
        List<Car> results = carRepository.findAll();
        Assertions.assertThat(results.size()).isEqualTo(3);
        Assertions.assertThat(results.get(0).toString()).isEqualTo(cars.get(0).toString());
        Assertions.assertThat(results.get(1).toString()).isEqualTo(cars.get(1).toString());
        Assertions.assertThat(results.get(2).toString()).isEqualTo(cars.get(2).toString());
    }
}