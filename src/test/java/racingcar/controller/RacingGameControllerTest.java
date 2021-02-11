package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameControllerTest {
    RacingGameController racingGameController;
    List<String> names = Arrays.asList("똘이", "멍이", "순이");

    @BeforeEach
    void setUp() {
        racingGameController = new RacingGameController();
        racingGameController.setUpGame(names, 5);
    }

    @DisplayName("라운드 진행 테스트")
    @Test
    void 라운드_진행_테스트() {
        CarsDto before = racingGameController.progressRound();
        int beforeRound = before.getCurrentRound();

        CarsDto after = racingGameController.progressRound();
        int afterRound = after.getCurrentRound();

        assertThat(beforeRound).isLessThan(afterRound);
    }

    @DisplayName("우승자 반환 테스트")
    @Test
    void 우승자_반환_테스트() {
        Car car = new Car("웨지");
        Car car2 = new Car("재연링");
        Car car3 = new Car("포비");

        car.move(5);

        Cars cars = Cars.createCars(Arrays.asList(car, car2, car3));

        racingGameController.setUpGame(cars, 5);
        WinnersDto winners = racingGameController.announceWinners();

        assertThat(String.join(",", winners.getNames())).isEqualTo("웨지");
    }
}
