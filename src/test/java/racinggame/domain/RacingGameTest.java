package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.condition.FixedMoveCondition;

class RacingGameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(
                () -> new RacingGame(Cars.of(List.of(Name.from("아톰"), Name.from("이상"))), new FixedMoveCondition()))
                .doesNotThrowAnyException();
    }

    @DisplayName("라운드 수 만큼 경주를 진행할 수 있다.")
    @Test
    void race() {
        RacingGame game = new RacingGame(Cars.of(List.of(Name.from("아톰"), Name.from("이상"))), new FixedMoveCondition());
        List<RoundResult> results = game.race(Round.from(3));

        assertThat(results).isEqualTo(List.of(
                new RoundResult(List.of(new CarInfo("아톰", 1), new CarInfo("이상", 1))),
                new RoundResult(List.of(new CarInfo("아톰", 2), new CarInfo("이상", 2))),
                new RoundResult(List.of(new CarInfo("아톰", 3), new CarInfo("이상", 3)))
        ));
    }

    @DisplayName("우승자를 선정한다.")
    @Test
    void findWinners() {
        RacingGame game = new RacingGame(Cars.of(List.of(Name.from("아톰"), Name.from("이상"))), new FixedMoveCondition());

        List<String> expected = game.findWinnerName();

        assertThat(expected).containsExactly("아톰", "이상");
        assertThat(expected.size()).isEqualTo(2);
    }
}
