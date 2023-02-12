package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TrialCount;

public class TrialCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 0})
    @DisplayName("생성자 예외 발생 테스트")
    void invalidTrialCountTest(int value) {
        Assertions.assertThatThrownBy(() -> {
            new TrialCount(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
