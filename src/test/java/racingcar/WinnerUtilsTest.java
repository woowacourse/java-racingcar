package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.WinnerUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerUtilsTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
    }

    private Car newCar(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.tryToMove(4);
        }
        return car;
    }

    @Test
    @DisplayName("우승자가 한명인 경우")
    void findWinnersTest_한명() {
        cars.add(newCar("루트", 5));
        cars.add(newCar("소롱", 3));
        cars.add(newCar("포비", 1));

        List<String> expected = new ArrayList<>();
        expected.add(cars.get(0).getName());

        List<String> actual = WinnerUtils.findWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자가 두명인 경우")
    void findWinnersTest_두명_이상() {
        cars.add(newCar("루트", 5));
        cars.add(newCar("소롱", 5));
        cars.add(newCar("포비", 1));

        List<String> actual = WinnerUtils.findWinners(cars);
        List<String> expected = new ArrayList<>();
        expected.add(cars.get(0).getName());
        expected.add(cars.get(1).getName());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("모두 움직이지 않은 경우")
    void findWinnerTest_모두_움직이지_않음() {
        cars.add(new Car("루트"));
        cars.add(new Car("소롱"));
        cars.add(new Car("포비"));

        List<String> expected = cars.stream().map(Car::getName).collect(Collectors.toList());

        List<String> actual = WinnerUtils.findWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }
}