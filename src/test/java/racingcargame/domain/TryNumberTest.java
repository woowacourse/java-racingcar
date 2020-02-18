package racingcargame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.exception.InvalidTryNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class TryNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1번", "두 번", "3.5"})
    void 정수가_아닌_값_입력(String input) {
        assertThatThrownBy(() ->
                                   new TryNumber(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 최소시도회수_1보다_작은_값_입력(String input) {
        assertThatThrownBy(() ->
                                   new TryNumber(input))
                .isInstanceOf(InvalidTryNumberException.class);
    }

    @Test
    void 회수검증() {
        int tryCount = 3;
        int number = 0;
        TryNumber tryNumber = new TryNumber(String.valueOf(tryCount));
        while (tryNumber.next()) {
            number++;
        }
        assertThat(number).isSameAs(tryCount);
    }
}