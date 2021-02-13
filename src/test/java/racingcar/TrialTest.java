package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Trial;

public class TrialTest {

    @ParameterizedTest
    @DisplayName("정상적인 이동 시도할 회수 입력")
    @ValueSource(ints = {1, 2, 40, 2147483647})
    void newTrialTest_정상입력(int number) {
        assertThatCode(() -> {
            final Trial trial = new Trial(number);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이동 시도할 회수가 범위 밖인 경우 예외 처리")
    @ValueSource(ints = {0})
    void newTrialTest_범위_밖의_숫자(int number) {
        assertThatThrownBy(() -> {
            final Trial trial = new Trial(number);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이하여야 합니다.");
    }
}
