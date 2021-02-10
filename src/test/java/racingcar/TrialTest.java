package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
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

    @ParameterizedTest
    @DisplayName("정상적인 이동 시도할 회수 입력")
    @CsvSource(value = {"1,1", "2,2", "50,50", "2147483647,2147483647"}, delimiter = ',')
    void parseTrialTest_정상입력(String input, Integer expected) {
        final Trial actual = Trial.getInstance(input);
        assertThat(actual).isEqualTo(new Trial(expected));
    }

    @ParameterizedTest
    @DisplayName("이동 시도할 회수가 Integer 범위 밖인 경우 예외 처리")
    @ValueSource(strings = {"2147483648", "9999999999"})
    void parseTrialTest_범위_밖의_숫자(String input) {
        assertThatThrownBy(() -> {
            Trial.getInstance(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Integer");
    }

    @ParameterizedTest
    @DisplayName("이동 시도할 회수가 숫자가 아닌 입력을 한 경우 예외 처리")
    @EmptySource
    @ValueSource(strings = {"2-1", "abc", "894-", "+3"})
    void parseTrialTest_정수가_아닌_입력(String input) {
        assertThatThrownBy(() -> {
            Trial.getInstance(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
