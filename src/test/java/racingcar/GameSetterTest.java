package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameSetterTest {

    @Test
    void setCarsTest_정상입력() {
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("루트"));
        expected.add(new Car("소롱"));

        List<Car> actual = GameSetter.setCars("루트,소롱");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한대의자동차", "자동차#;"})
    void setCarsTest_자동차_입력_수(String input) {
        assertThatThrownBy(() -> {
            GameSetter.setCars(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"루트,소롱,루트", "루트,루트,루트"})
    void setCarsTest_중복되는_자동차_입력(String input) {
        assertThatThrownBy(() -> {
            GameSetter.setCars(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "50,50", "2147483647,2147483647"}, delimiter = ',')
    void setTrial_정상입력(String input, Integer expected) {
        Integer actual = GameSetter.setTrial(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "0"})
    void setTrial_범위_밖의_숫자(String input) {
        assertThatThrownBy(() -> {
            GameSetter.setTrial(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2-1", "abc", "894-", "1.3"})
    void setTrial_정수가_아닌_입력(String input) {
        assertThatThrownBy(() -> {
            GameSetter.setTrial(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
