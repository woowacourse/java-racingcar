package racingcargame.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnersTest {
    @Test
    void 우승자_찾아내기_테스트() {
        List<Car> cars = Arrays.asList(new Car("a", 100), new Car("b", 1), new Car("c", 2));
        Cars testCars = new Cars(cars);
        Winners winners = new Winners(testCars);
        List<Car> checkCars = Arrays.asList(new Car("a", 100));

        assertThat(winners.getWinners()).isEqualTo(checkCars);
    }

    @Test
    void 복수_우승자_찾아내기_테스트() {
        List<Car> cars = Arrays.asList(new Car("a", 100), new Car("b", 100), new Car("c", 2));
        Cars testCars = new Cars(cars);
        Winners winners = new Winners(testCars);
        List<Car> checkCars = Arrays.asList(new Car("a", 100), new Car("b", 100));

        assertThat(winners.getWinners()).isEqualTo(checkCars);
    }
}
