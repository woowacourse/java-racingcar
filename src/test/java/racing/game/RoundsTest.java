package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundsTest {
    @Test
    void 기준점이상을입력시True를반환하는지() {
        assertThat(Rounds.canMove(4)).isTrue();
        assertThat(Rounds.canMove(5)).isTrue();
        assertThat(Rounds.canMove(6)).isTrue();
        assertThat(Rounds.canMove(7)).isTrue();
        assertThat(Rounds.canMove(8)).isTrue();
        assertThat(Rounds.canMove(9)).isTrue();
    }

    @Test
    void 기준점미만을입력시False를반환하는지() {
        assertThat(Rounds.canMove(0)).isFalse();
        assertThat(Rounds.canMove(1)).isFalse();
        assertThat(Rounds.canMove(2)).isFalse();
        assertThat(Rounds.canMove(3)).isFalse();
    }
}
