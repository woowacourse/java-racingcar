package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingGameTest {

    @Test
    @DisplayName("경주를 진행하면서 random 값이 4일 경우, 자동차들을 이동시킬 수 있다.")
    void playRoundMoveTest() {
        CarRacingGame carRacingGame = new CarRacingGame("pobi,crong,honux", "1");
        carRacingGame.playRound(() -> 4);

        List<Car> carList = carRacingGame.getRoundResult();
        carList.forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }

    @Test
    @DisplayName("경주를 진행하면서 ramdom 값이 3인 경우 자동차들은 이동하지 않는다.")
    void playRoundNotMoveTest() {
        CarRacingGame carRacingGame = new CarRacingGame("pobi,crong,honux", "1");
        carRacingGame.playRound(() -> 3);

        List<Car> carList = carRacingGame.getRoundResult();
        carList.forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }
}