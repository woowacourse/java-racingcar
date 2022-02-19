package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.GameTurn;

@SuppressWarnings("NonAsciiCharacters")
public class GameTurnTest {

    @Test
    public void 횟수_음수_확인() {
        assertThatThrownBy(() -> new GameTurn(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 횟수_양수_확인() {
        assertThatCode(() -> new GameTurn(1))
                .doesNotThrowAnyException();
    }

    @Test
    public void 남은_횟수_확인() {
        GameTurn gameTurn = new GameTurn(1);
        boolean result = gameTurn.isPositive();
        assertThat(result).isEqualTo(true);
    }
}
