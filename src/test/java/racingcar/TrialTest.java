package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "50,50", "2147483647,2147483647"}, delimiter = ',')
    void setTrial_정상입력(String input, Integer expected) {
        Integer actual = new Trial(input).getTrial();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void setTrial_0을_입력() {
        assertThatThrownBy(() ->
            new Trial("0")).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이상의 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "2-1", "abc", "가나다", "894-", "1.3"})
    void setTrial_int가_아닌_입력(String input) {
        assertThatThrownBy(() ->
            new Trial(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
