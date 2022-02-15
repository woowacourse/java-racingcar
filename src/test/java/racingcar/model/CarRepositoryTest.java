package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRepositoryTest {

    @Test
    @DisplayName("자동차를 CarRepository에 저장할 때는 Car로 하지만 읽어올 때는 CarDtos로 읽어온다.")
    void getCars() {
        CarRepository carRepository = new CarRepository();
        Car car = new Car("범고래");
        carRepository.save(car);

        List<CarDto> cars = carRepository.getCarDtos();
        CarDto carDto = new CarDto(car);
        assertThat(cars.contains(carDto)).isTrue();
    }

    @Test
    @DisplayName("가장 많이 움직인 자동차가 우승한다.")
    void getWinners() {
        CarRepository carRepository = new CarRepository();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 4));
        Car car1 = new Car("범고래");
        Car car2 = new Car("소주캉");
        carRepository.save(car1);
        carRepository.save(car2);

        carRepository.move(numbers);
        List<CarDto> winners = carRepository.getWinners();

        CarDto expected = new CarDto(car2);
        assertThat(winners.contains(expected)).isTrue();
    }
}
