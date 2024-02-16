package model;

import static fixture.CarFixture.자동차;
import static fixture.CarFixture.자동차들;
import static fixture.RacingGameFixture.레이싱게임;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;
import support.MovableNumberGenerator;
import util.NumberGenerator;

class RacingGameTest {
    private final NumberGenerator movableNumberGenerator = new MovableNumberGenerator();

    @Test
    void 중복된_자동차가_존재하지_않으면_예외가_발생하지_않는다() {
        // given
        final String uniqueCarName1 = "pobi";
        final String uniqueCarName2 = "crong";
        final String uniqueCarName3 = "honux";

        // when & then
        assertDoesNotThrow(() -> new RacingGame(자동차들(uniqueCarName1, uniqueCarName2, uniqueCarName3)));
    }

    @Test
    void 중복된_자동차가_존재하면_예외가_발생한다() {
        // given
        final String duplicateCarName1 = "pobi";
        final String duplicateCarName2 = "pobi";
        final String uniqueCarName = "crong";

        // when & then
        assertThatThrownBy(() -> new RacingGame(자동차들(duplicateCarName1, duplicateCarName2, uniqueCarName)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 단독_우승자를_찾는다() {
        // given
        final Car winner = 자동차("prin");
        final Car loser1 = 자동차("mark");
        final Car loser2 = 자동차("pobi");
        final RacingGame racingGame = 레이싱게임(winner, loser1, loser2);
        winner.moveForward(movableNumberGenerator);

        // when
        final List<String> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(1)
                .contains(winner.getName());
    }

    @Test
    void 공동_우승자를_찾는다() {
        // given
        final Car loser = 자동차("prin");
        final Car winner1 = 자동차("mark");
        final Car winner2 = 자동차("pobi");
        final RacingGame racingGame = 레이싱게임(loser, winner1, winner2);
        winner1.moveForward(movableNumberGenerator);
        winner2.moveForward(movableNumberGenerator);

        // when
        final List<String> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(2)
                .contains(winner1.getName(), winner2.getName());
    }
}
