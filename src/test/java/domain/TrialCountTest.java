package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TrialCount;

import static org.assertj.core.api.Assertions.*;

public class TrialCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    @DisplayName("생성자 정상 동작 테스트")
    void validTrialCountTest(int value) {
        assertThat(new TrialCount(value)).isInstanceOf(TrialCount.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 0})
    @DisplayName("생성자 예외 발생 테스트")
    void invalidTrialCountTest(int value) {
        assertThatThrownBy(() -> {
            new TrialCount(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
