package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.exception.round.WrongRoundCountException;
import racingcar.exception.round.RoundCountExceptionStatus;

class RoundTest {

    private static final int DECREASING_COUNT = 1;
    private static final int CONDITION_TO_FINISH = 0;

    @DisplayName("실행횟수는 양수여야 한다")
    @ParameterizedTest()
    @ValueSource(ints = {-3, -2, -1, 0})
    void roundNotPositiveExceptionTest(final int count) {
        assertThatThrownBy(() -> new Round(count))
                .isInstanceOf(WrongRoundCountException.class)
                .hasMessageContaining(RoundCountExceptionStatus.ROUND_IS_NOT_POSITIVE.getMessage());
    }

    @DisplayName("생성자 기능 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 10, 20})
    void constructorTest(final int count) {
        assertDoesNotThrow(() -> new Round(count));
    }

    @DisplayName("실행횟수는 하나씩 감소해야 한다.")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 10, 20})
    void decreaseCountTest(final int count) {
        final Round round = new Round(count);
        round.decreaseCount();

        final int actual = round.getCount();
        final int expected = count - DECREASING_COUNT;
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("실행횟수가 0인지 확인하는 기능 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 10, 20})
    void isNotFinishedTest(final int count) {
        final Round round = new Round(count);
        repeatDecreaseCount(round, count);

        final int actual = round.getCount();
        assertThat(actual).isEqualTo(CONDITION_TO_FINISH);
    }

    private void repeatDecreaseCount(final Round round, final int count) {
        for (int i = 0; i < count; i++) {
            round.decreaseCount();
        }
    }

}
