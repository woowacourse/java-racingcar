package racingcargame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame;
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("lawn");
        racingCarGame = new RacingCarGame(carNames, 0);
    }

    @Test
    @DisplayName("생성한 자동차 객체 갯수 확인")
    void storeCarName() {
        assertThat(racingCarGame.startRace().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 확인")
    void findCarName() {
        assertThat(racingCarGame.findRacingGameWinner().get(0).contains("liver")
                || racingCarGame.findRacingGameWinner().get(0).contains("lawn")).isTrue();
    }
}