package racingcargame.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class RaceCountInputValidatorTest {  
    @Test
    void 경주_횟수_숫자가_아닌_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount("a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 시도 횟수는 숫자만 입력해주세요. ");
    }
}