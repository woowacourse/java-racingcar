package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;
import racingcar.model.RacingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("경주 게임 정상 종료 조건")
    void checkEndRaceCondition() {
        RacingGame racingGame = new RacingGame("aaa", "1");
        racingGame.race();

        assertThat(racingGame.isEnd()).isTrue();
    }

    @Test
    @DisplayName("최종 우승자 출력")
    void findWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new Name("bom"), 3));
        carList.add(new Car(new Name("sun"), 4));
        Cars cars = new Cars(carList);

        String actual = cars.findWinnerName(cars.findMaxPosition()).stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        String expected = "sun";

        assertThat(actual).isEqualTo(expected);
    }
}
