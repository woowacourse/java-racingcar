package racingcargame.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class RaceCountInputValidatorTest {  
    @Test
    void 경주_횟수_숫자가_아닌_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount("3a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.");
    }

    @Test
    void 경주_횟수_NULL_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }
}