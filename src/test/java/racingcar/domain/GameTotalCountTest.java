package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTotalCountTest {

    @Test
    @DisplayName("시도 횟수가 정수인지 테스트")
    public void 시도횟수_정수인지_테스트() {
        // given
        String attempt = "숫자";

        //then
        assertThrows(IllegalArgumentException.class, () -> new GameTotalCount(attempt));
    }

    @Test
    @DisplayName("시도 횟수가 음수인 경우 테스트")
    public void 시도횟수_음수_테스트() {
        // given
        String attempt = "-3";

        //then
        assertThrows(IllegalArgumentException.class, () -> new GameTotalCount(attempt));
    }
}