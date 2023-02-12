package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0,-1,-10})
    @DisplayName("시도횟수가 0 이하의 숫자일 때, 예외가 발생하는지 확인한다")
    void TryCountInitializerTest(int tries) {
        assertThatThrownBy(() -> new TryCount(tries))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1이상의 숫자여야 합니다.");
    }


    @ParameterizedTest
    @CsvSource(value = {"1,1", "12,12"})
    @DisplayName("1이상의 시도횟수를 제대로 저장하는지 확인한다")
    void getTries(int inputTries, int savedTries) {
        TryCount tryCount = new TryCount(inputTries);
        assertThat(tryCount.getTries())
                .isEqualTo(savedTries);
    }
}
