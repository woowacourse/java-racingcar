package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Trial;

public class TrialTest {

    @ParameterizedTest
    @DisplayName("정상적인 Trial 생성")
    @ValueSource(ints = {1, Integer.MAX_VALUE})
    void newTrialTest_정상_입력(int trialNumber) {
        assertThatCode(() -> {
            new Trial(trialNumber);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("범위 밖의 Trial 생성시 예외 처리")
    void newTrialTest_범위_밖_입력() {
        assertThatThrownBy(() -> {
            new Trial(0);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이하여야 합니다.");
    }
}
