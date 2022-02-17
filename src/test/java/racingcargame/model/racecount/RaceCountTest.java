package racingcargame.model.racecount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceCountTest {

    @DisplayName("입력된 경주횟수가 없는 경우 테스트")
    @Test
    void checkRightCount_EmptyCount() {
        assertThatThrownBy(() -> {
            final RaceCount raceCount = new RaceCount(null);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }

    @DisplayName("입력된 경주횟수가 0~9의 숫자로 이루어지지 않은 경우 테스트")
    @Test
    void checkRightCount_RightNumber() {
        assertThatThrownBy(() -> {
            final RaceCount raceCount = new RaceCount("1x9");
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.");
    }

    @DisplayName("입력된 자동차 이름이 없는 경우 테스트")
    @Test
    void checkRightCount_IncorrectStart() {
        assertThatThrownBy(() -> {
            final RaceCount raceCount = new RaceCount("068");
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 경주횟수는 1이상의 값을 입력해주세요.");
    }
}