package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.GameTotalCount.createGameTotalCount;

@SuppressWarnings("NonAsciiCharacters")
class GameTotalCountTest {

    @Test
    @DisplayName("정수로 변환이 가능한 문자열이 입력되었을 때 테스트")
    public void 정상_입력_테스트() {
        //given
        String attempt = "5";
        int attemptNumber = Integer.parseInt(attempt);

        //when
        GameTotalCount gameTotalCount = createGameTotalCount(attempt);

        //then
        assertThat(attemptNumber).isEqualTo(gameTotalCount.getTotalAttemptCount());
    }

    @Test
    @DisplayName("시도 횟수가 정수인지 테스트")
    public void 시도횟수_정수인지_테스트() {
        // given
        String attempt = "숫자";

        //then
        assertThrows(IllegalArgumentException.class, () -> createGameTotalCount(attempt));
    }

    @Test
    @DisplayName("시도 횟수가 음수인 경우 테스트")
    public void 시도횟수_음수_테스트() {
        // given
        String attempt = "-3";

        //then
        assertThrows(IllegalArgumentException.class, () -> createGameTotalCount(attempt));
    }
}