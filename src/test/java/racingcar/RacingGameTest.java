package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static Car newCar(String name, int position) {
        final Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.tryToMove(4);
        }
        return car;
    }

    @ParameterizedTest
    @DisplayName("우승자 판별 테스트")
    @MethodSource("provideRacingGameForFindWinner")
    void findWinnerTest(RacingGame racingGame, List<String> expected) {
        final List<String> actual = racingGame.getWinners();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRacingGameForFindWinner() {
        return Stream.of(
            Arguments.of(new RacingGame(provideCars_우승자_한명(), 0), Arrays.asList("루트")),
            Arguments.of(new RacingGame(provideCars_우승자_두명(), 0), Arrays.asList("루트", "소롱")),
            Arguments.of(new RacingGame(provideCars_모두_움직이지_않음(), 0), Arrays.asList("루트", "소롱", "포비"))
        );
    }

    private static List<Car> provideCars_우승자_한명() {
        List<Car> cars = new ArrayList<>();
        cars.add(newCar("루트", 5));
        cars.add(newCar("소롱", 3));
        cars.add(newCar("포비", 1));

        return cars;
    }

    private static List<Car> provideCars_우승자_두명() {
        List<Car> cars = new ArrayList<>();
        cars.add(newCar("루트", 5));
        cars.add(newCar("소롱", 5));
        cars.add(newCar("포비", 1));

        return cars;
    }

    private static List<Car> provideCars_모두_움직이지_않음() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("루트"));
        cars.add(new Car("소롱"));
        cars.add(new Car("포비"));

        return cars;
    }
}