package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    @DisplayName("자동차의 이름이 5글자를 초과하는 경우 예외가 발생한다.")
    void overNameLength() {
        final var overName = "아아아아아아";
        final List<String> duplicatedNames = List.of("abc", "def", "ref", overName);
        assertThatThrownBy(() -> InputValidator.validateCarName(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름들 중 중복된 이름이 있는 경우 예외가 발생한다.")
    void duplicatedNamesTest() {
        final var duplicatedName = "abd";
        final List<String> duplicatedNames = List.of(duplicatedName, "def", "ref", duplicatedName);
        assertThatThrownBy(() -> InputValidator.validateCarName(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름 중 영어가 아닌 다른 문자가 있는 경우 예외가 발생한다.")
    void isAlphabetic() {
        final List<String> wrongName = List.of("rar1");
        assertThatThrownBy(() -> InputValidator.validateCarName(wrongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 영어로만 이루어져야 합니다.");
    }

    @Test
    @DisplayName("이동 횟수가 자연수가 아닌 경우 예외가 발생한다.")
    void isNatural() {
        final int wrongNumber = -1;
        assertThatThrownBy(() -> InputValidator.validateMoveCount(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 자연수여야 합니다.");
    }
}
