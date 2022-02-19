package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Winners;
import racingcar.vo.CarValue;
import racingcar.domain.vo.Name;

class RacingGameTest {

    @Test
    @DisplayName("시도횟수가 있다면 레이싱을 진행할 수 있다")
    void existsTrial_possible_race() {
        String carNames = "pobi, hoho, rich";
        int trial = 1;
        RacingGame racingGame = new RacingGame(carNames, trial);

        assertThat(racingGame.isEnd()).isFalse();
    }

    @Test
    @DisplayName("시도횟수가 없다면 레이싱을 진행할 수 없다")
    void notExistsTrial_impossible_race() {
        String carNames = "pobi, hoho, rich";
        int trial = 1;
        RacingGame racingGame = new RacingGame(carNames, trial);
        racingGame.race();

        assertThat(racingGame.isEnd()).isTrue();
    }

    @Test
    @DisplayName("자동차 경주에 참여한 자동차를 조회한다")
    void getCars() {
        String carNames = "pobi, hoho, rich";
        int trial = 1;
        RacingGame racingGame = new RacingGame(carNames, trial);

        assertThat(racingGame.getCars())
            .containsExactly(
                new CarValue("pobi", 0),
                new CarValue("hoho", 0),
                new CarValue("rich", 0));
    }

    @Test
    @DisplayName("자동차 경주에 우승한 우승자를 조회한다")
    void getWinners() {
        String carNames = "pobi, hoho, rich";
        int trial = 1;
        RacingGame racingGame = new RacingGame(carNames, trial);
        Winners winners = racingGame.getWinners();

        assertThat(winners.getWinners())
            .containsExactly(new Name("pobi"), new Name("hoho"), new Name("rich"));
    }
}
