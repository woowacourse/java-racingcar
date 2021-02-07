package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarsDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    private final int numberOfRounds = 5;
    private RacingGame racingGame;
    private final List<String> testCases = Arrays.asList("똘이","멍이","순이");

    @BeforeEach
    void setUp(){
        this.racingGame = new RacingGame(testCases, numberOfRounds);
    }

    @DisplayName("주어진 이름대로 자동차 생성되는지 테스트")
    @Test
    void 자동차_생성되는지() {
        CarsDto cars = new CarsDto(racingGame.getCars());
        for (int i = 0; i < testCases.size(); i++) {
            assertThat(cars.getCarsDto().get(i).getName()).isEqualTo(testCases.get(i));
        }
    }

    @DisplayName("라운드가 진행되는지 확인")
    @Test
    void 레이싱게임_라운드_진행(){
        int beforeRound = racingGame.getCurrentRound();
        racingGame.playRound();
        int afterRound = racingGame.getCurrentRound();

        assertThat(beforeRound + 1).isEqualTo(afterRound);
    }
}