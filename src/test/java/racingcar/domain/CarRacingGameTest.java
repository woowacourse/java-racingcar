package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {
    private CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        Cars cars = new Cars(
                List.of(new Car("pobi"), new Car("crong"), new Car("honux"))
        );
        carRacingGame = new CarRacingGame(cars, new Round(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0"})
    @DisplayName("경주를 진행하면서 random 값이 4 이상일 경우 자동차들을 이동시키고, random 값이 4 미만인 경우 자동차들을 이동시키지 않는다.")
    void playRoundMoveTest(int randomNumber, int expected) {
        carRacingGame.playRound(() -> randomNumber);

        List<Car> carList = carRacingGame.getRoundResult();
        carList.forEach(car -> assertThat(car.getPosition()).isEqualTo(expected));
    }

    @Test
    @DisplayName("자동차 경주 게임 종료 여부를 판별할 수 있다.")
    void isGameEnd() {
        assertThat(carRacingGame.isPlayable()).isTrue();
        carRacingGame.playRound(() -> 3);
        assertThat(carRacingGame.isPlayable()).isFalse();
    }

    @Test
    @DisplayName("우승자를 구할 수 있다.")
    void findWinners() {
        List<Car> winners = carRacingGame.findWinners();
        assertThat(winners.size()).isEqualTo(3);
    }
}
