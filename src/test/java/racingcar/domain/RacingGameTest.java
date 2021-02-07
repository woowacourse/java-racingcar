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

    @DisplayName("목표 라운드가 음수일 때 에러가 나는지")
    @Test
    void 목표_라운드가_음수이면_에러(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(testCases, -1));
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
        int beforeRound = racingGame.getCurrentRound();
        racingGame.playRound();
        int afterRound = racingGame.getCurrentRound();

        assertThat(beforeRound + 1).isEqualTo(afterRound);
    }
}