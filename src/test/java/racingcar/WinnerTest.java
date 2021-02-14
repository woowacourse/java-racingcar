package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {

    @DisplayName("우승자 리스트 테스트")
    @Test
    void winnerTest() {
        List<String> splittedCarNames = Arrays.asList("pho", "crong", "honux");
        Cars cars = new Cars(splittedCarNames);
        List<Car> unmodifiableCars = cars.getCars();
        racing(unmodifiableCars);
        assertEquals(cars.getWinners().size(), 2);
    }

    private void racing(List<Car> cars) {
        cars.get(0).move(1);
        cars.get(1).move(4);
        cars.get(2).move(5);
        cars.get(0).move(1);
        cars.get(1).move(4);
        cars.get(2).move(5);
    }

}
