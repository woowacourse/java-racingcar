package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void validatePositiveNumber(int negativeNumber) {
        assertThatThrownBy(() -> {
            new TryCount(negativeNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TryCount.POSITIVE_CRITERIA + "이상의 수를 입력해야합니다.");
    }
}