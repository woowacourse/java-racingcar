package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NoneAsciiCharacters")
public class RacingCarGameTest {
    @Test
    void 입력값을_null로_생성_시도할_경우_예외발생() {
        String incorrectInput = null;
        MoveStrategy correctMoveStrategy = new RandomMoveStrategy();

        assertThatThrownBy(() -> new RacingCarGame(incorrectInput, correctMoveStrategy))
            .hasMessageContaining("입력값은 null이 될수 없습니다.");
    }

    @Test
    void MoveStrategy를_null로_생성_시도할_경우_예외발생() {
        String correctInput = "어썸오,칙촉";
        MoveStrategy incorrectMoveStrategy = null;

        assertThatThrownBy(() -> new RacingCarGame(correctInput, incorrectMoveStrategy)).isInstanceOf(
                IllegalArgumentException.class)
            .hasMessageContaining("null이 사용될수 없습니다. MoveStrategy 타입을 이용하세요.");
    }

    @Test
    void 올바른_매개변수로_생성되는_경우() {
        String correctInput = "어썸오,칙촉";
        MoveStrategy correctMoveStrategy = new RandomMoveStrategy();

        assertThatCode(() -> new RacingCarGame(correctInput, correctMoveStrategy))
            .doesNotThrowAnyException();
    }
}
