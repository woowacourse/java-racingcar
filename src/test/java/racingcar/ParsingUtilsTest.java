package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.utils.ParsingUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParsingUtilsTest {

    @Test
    void parseCarNamesTest_정상입력() {
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("루트"));
        expected.add(new Car("소롱"));

        List<Car> actual = ParsingUtils.parseCarNames("루트,소롱");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한대의자동차", "자동차#;"})
    void parseCarNamesTest_자동차_입력_수(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"루트,소롱,루트", "루트,루트,루트"})
    void parseCarNamesTest_중복되는_자동차_입력(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "50,50", "2147483647,2147483647"}, delimiter = ',')
    void parseTrialTest_정상입력(String input, Integer expected) {
        Integer actual = ParsingUtils.parseTrial(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "0"})
    void parseTrialTest_범위_밖의_숫자(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseTrial(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2-1", "abc", "894-", "+3"})
    void parseTrialTest_정수가_아닌_입력(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseTrial(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
