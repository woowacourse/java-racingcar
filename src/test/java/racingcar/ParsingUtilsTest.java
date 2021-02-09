package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("정상적인 경주할 자동차 이름들 입력")
    void parseCarNamesTest_정상입력() {
        final List<Car> expected = new ArrayList<>();
        expected.add(new Car("루트"));
        expected.add(new Car("소롱"));

        final List<Car> actual = ParsingUtils.parseCarNames("루트,소롱");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("경주할 자동차 이름이 하나인 경우 예외 처리")
    @ValueSource(strings = {"한대의자동차", "자동차#;"})
    void parseCarNamesTest_자동차_입력_수(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복되는 경주할 자동차 이름이 있는 경우 예외 처리")
    @ValueSource(strings = {"루트,소롱,루트", "루트,루트,루트"})
    void parseCarNamesTest_중복되는_자동차_입력(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("정상적인 이동 시도할 회수 입력")
    @CsvSource(value = {"1,1", "2,2", "50,50", "2147483647,2147483647"}, delimiter = ',')
    void parseTrialTest_정상입력(String input, Integer expected) {
        final Integer actual = ParsingUtils.parseTrial(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("게임이 불가능한 이동 회수나 Integer 범위 밖의 입력시 예외 처리")
    @ValueSource(strings = {"2147483648", "0"})
    void parseTrialTest_범위_밖의_숫자(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseTrial(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이하여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("이동 시도할 회수가 숫자가 아닌 입력을 한 경우 예외 처리")
    @ValueSource(strings = {"2-1", "abc", "894-", "+3"})
    void parseTrialTest_정수가_아닌_입력(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseTrial(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
