package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerFinderTest {

    private List<Car> cars;
    private WinnerFinder winnerFinder;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        winnerFinder = new WinnerFinder();
        cars.add(new Car("루트"));
        cars.add(new Car("소롱"));
    }

    @Test
    void getWinnersTest_한명() {
        cars.get(0).tryToMove(5);
        cars.get(1).tryToMove(3);

        List<String> expected = new ArrayList<>();
        expected.add(cars.get(0).getName());

        List<String> actual = winnerFinder.getWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWinnersTest_두명_이상() {
        cars.get(0).tryToMove(5);
        cars.get(1).tryToMove(5);

        List<String> expected = new ArrayList<>();
        for (Car car : cars) {
            expected.add(car.getName());
        }

        List<String> actual = winnerFinder.getWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWinnerTest_모두_움직이지_않음() {
        List<String> expected = new ArrayList<>();
        for (Car car : cars) {
            expected.add(car.getName());
        }

        List<String> actual = winnerFinder.getWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }
}
