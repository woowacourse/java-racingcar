package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {

    @Test
    @DisplayName("CarDto를 받아서 Car객체로 반환한다.")
    void toCar() {
        CarService carService = new CarService();
        String name = "범고래";
        CarDto carDto = new CarDto(name);

        Car car = carService.toCar(carDto);
        assertThat(car).isEqualTo(new Car(name));
    }

    @Test
    @DisplayName("CarDto 리스트를 받아서 Car 리스트로 반환한다.")
    void toCars() {
        CarService carService = new CarService();
        String name1 = "범고래";
        String name2 = "소주캉";
        List<CarDto> input = Arrays.asList(new CarDto(name1), new CarDto(name2));

        List<Car> result = carService.toCars(input);

        List<Car> expected = Arrays.asList(new Car(name1), new Car(name2));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 갯수 만큼 Random리스트를 생성한다.")
    void createRandomNumbers() {
        CarService carService = new CarService();
        String name1 = "범고래";
        String name2 = "소주캉";
        List<Car> cars = Arrays.asList(new Car(name1), new Car(name2));
        carService.createCars(cars);

        List<Integer> randomNumbers = carService.createRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(cars.size());
    }

    @Test
    @DisplayName("자동차 리스트와 라운드를 입력받아 저장한다..")
    void convertToCars() {
        CarService carService = new CarService();
        int round = 1;
        String name = "범고레";
        List<Car> cars = List.of(new Car(name));
        carService.addScoreBoard(round, cars);
    }
}
