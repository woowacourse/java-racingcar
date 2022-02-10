package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름을 구분자로 구분하여 게임을 시작한다.")
    void splitCarNames() {
        RacingGame game = new RacingGame("pobi,crong,honux");
        List<String> carNames = game.getCarNames();
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }
}
