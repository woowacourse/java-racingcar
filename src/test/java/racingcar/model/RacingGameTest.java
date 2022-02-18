package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RacingGameTest {

    List<Car> cars = new ArrayList<>();
    Car c;

    @BeforeEach
    void init() {
        Car a = new Car("a");
        a.move(0);
        cars.add(a);

        Car b = new Car("b");
        b.move(9);
        cars.add(b);

        c = new Car("c");
        c.move(0);
        cars.add(c);
    }

    @Test
    void 단일_우승자() {
        assertThat(getWinners(cars).size()).isEqualTo(1);
    }

    @Test
    void 공동_우승자() {
        c.move(9);

        assertThat(getWinners(cars).size()).isEqualTo(2);
    }

    @Test
    void 게임횟수_카운트_검증() {
        String[] cars = {"test"};
        RacingGame racingGame = new RacingGame(cars, "5");

        while (!racingGame.isEnd()) {
            racingGame.race();
        }

        assertThat(racingGame.isEnd()).isTrue();
    }

    public List<String> getWinners(List<Car> cars) {
        return cars.stream()
            .filter(car -> car.getPosition() == findMaxPosition(cars))
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}