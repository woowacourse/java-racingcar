package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameSetterTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "50,50", "2147483647,2147483647"}, delimiter = ',')
    void setTrial_정상입력(String input, Integer expected) {
        Integer actual = GameSetter.setTrial(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "0"})
    void setTrial_범위_밖의_숫자(String input) {
        assertThatThrownBy(() ->
            GameSetter.setTrial(input)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2-1", "abc", "가나다", "894-", "1.3"})
    void setTrial_정수가_아닌_입력(String input) {
        assertThatThrownBy(() ->
            GameSetter.setTrial(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
