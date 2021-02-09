package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    @DisplayName("시도 횟수가 0보다 작을 경우 예외처리 테스트")
    public void check_position_exception(int tryNumber) {
        assertThatThrownBy(() ->  new TryNumber(tryNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[Error] 시도할 횟수는 0보다 커야합니다.\n");
    }

}
