package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

        List<Name> names = List.of(new Name("pobi"), new Name("hoho"), new Name("rich"));

        assertThat(racingGame.getCars()).extracting(Car::getName) // 치킨4마리의 이름을 모두
            .usingRecursiveFieldByFieldElementComparator() // 이름만 담아놓은 리스트의 원소와 하나씩 필드 비교
            .isEqualTo(names);
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
