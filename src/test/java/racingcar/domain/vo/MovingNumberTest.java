package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("0과 9사이의 숫자가 아닐 경우 예외를 발생한다")
    void number_between0And9(int value) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new MovingNumber(value))
            .withMessageContaining("숫자는 0과 9사이어야 합니다.");
    }
}