package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    private RacingGame racingGame;
    private List<String> testCases = Arrays.asList("똘이", "멍이", "순이");

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(testCases, 5);
    }



    @DisplayName("주어진 이름대로 자동차 생성되는지 테스트")
    @Test
    void 자동차_생성되는지() {
        Cars cars = racingGame.getCars();
        for (int i = 0; i < testCases.size(); i++) {
            assertThat(cars.getCars().get(i).getName()).isEqualTo(testCases.get(i));
        }
    }

    @DisplayName("라운드가 진행되는지 확인")
    @Test
    void 레이싱게임_라운드_진행() {
        Round beforeRound = racingGame.getCurrentRound();
        racingGame.playRound();
        Round afterRound = racingGame.getCurrentRound();

        assertThat(afterRound.isBiggerThan(beforeRound)).isTrue();
    }
}