package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.TestMoveNumberGenerator;

class RacingGameTest {

    private final String car1 = "car1";
    private final String car2 = "car2";
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(List.of(car1, car2), new TestMoveNumberGenerator());
    }

    @Test
    @DisplayName("RacingGame 객체 생성 테스트")
    void createNewGame() {
        //given
        //when
        //then
        assertThat(racingGame.getCurrentStatus().size()).isEqualTo(2);
        assertThat(racingGame.getCurrentStatus().values()).containsOnly(1);
        assertThat(racingGame.getCurrentStatus().keySet()).containsOnly(car1, car2);
    }

    @Test
    @DisplayName("모든 차 이동 후 결과 반환 테스트")
    void playTurn() {
        //given
        //when
        Map<String, Integer> result = racingGame.playTurn();

        //then
        assertThat(result.values()).containsOnly(2);
    }

    @Test
    @DisplayName("모든 차 이동 후 우승자 반환 테스트")
    void getResult() {
        //given
        //when
        racingGame.playTurn();

        //then
        assertThat(racingGame.getResult()).containsOnly(car1, car2);
    }
}