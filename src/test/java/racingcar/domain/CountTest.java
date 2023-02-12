package racingcar.domain;

import static java.text.MessageFormat.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {

    @ParameterizedTest(name = "횟수: {0}")
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("횟수가 0이거나 음수라면 예외를 던진다.")
    void should_throwException_when_numberIsZeroOrNegative(final int value) {
        assertThatThrownBy(() -> new Count(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(format("입력된 횟수[{0}]: 횟수는 1이상, 100이하의 정수만 가능합니다.", value));
    }

    @ParameterizedTest(name = "횟수: {0}")
    @ValueSource(ints = {1, 10, 100})
    @DisplayName("횟수가 유효하다면 예외를 던지지 않는다.")
    void should_notThrowException_when_validNumber(final int value) {
        assertThatNoException().isThrownBy(() -> new Count(value));
    }

    @ParameterizedTest(name = "횟수: {0}")
    @ValueSource(ints = {101, 1000, 50000})
    @DisplayName("횟수가 최대 범위를 벗어나면 예외를 던진다.")
    void should_throwException_when_numberOverMaximum(final int value) {
        assertThatThrownBy(() -> new Count(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(format("입력된 횟수[{0}]: 횟수는 1이상, 100이하의 정수만 가능합니다.", value));
    }

    @ParameterizedTest(name = "진행 가능 횟수가 {0}인 경우 {1}을 반환한다.")
    @CsvSource({"5,true", "2,true", "1,false"})
    @DisplayName("isPlayable 메서드는 ")
    void should_returnState_when_callIsPlayable(final int value, final boolean state) {
        final Count count = new Count(value);

        count.decrease();

        assertThat(count.isPlayable()).isEqualTo(state);
    }
}
