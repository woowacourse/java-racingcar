package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.ParsingUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParsingUtilsTest {

    @Test
    @DisplayName("정상적인 경주할 자동차 이름들 입력")
    void parseCarNamesTest_정상입력() {
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car("루트"));
        cars.add(new Car("소롱"));
        final Cars expected = new Cars(cars);

        final Cars actual = ParsingUtils.parseCarNames("루트,소롱");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
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
    @EmptySource
    @ValueSource(strings = {"2-1", "abc", "894-", "+3"})
    void parseTrialTest_정수가_아닌_입력(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseTrial(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
