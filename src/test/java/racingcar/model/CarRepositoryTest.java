package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRepositoryTest {

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

        CarDto expected = new CarDto("소주캉", 1);
        assertThat(winners.contains(expected)).isTrue();
    }
}
