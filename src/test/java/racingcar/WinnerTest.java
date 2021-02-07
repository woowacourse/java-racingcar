package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {

    @Test
    void winnerSortingTest() {
        List<String> splittedCarNames = Arrays.asList("pho", "crong", "honux");
        CarRepository.addCars(splittedCarNames);
        List<Car> cars = CarRepository.getCars();
        racing(cars);
        assertEquals(CarRepository.getWinners().size(), 2);

    }

    private void racing(List<Car> cars) {
        cars.get(0).moveForwardByRandomNumber(1);
        cars.get(1).moveForwardByRandomNumber(4);
        cars.get(2).moveForwardByRandomNumber(5);
        cars.get(0).moveForwardByRandomNumber(1);
        cars.get(1).moveForwardByRandomNumber(4);
        cars.get(2).moveForwardByRandomNumber(5);
    }

}
