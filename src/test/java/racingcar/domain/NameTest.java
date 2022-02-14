package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("자동차 이름이 null이 들어올 경우 예외가 발생해야 한다.")
    void checkRacingCarNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(null))
            .withMessageMatching("자동차 이름은 null이 들어올 수 없다.");
    }

    @Test
    @DisplayName("자동차의 이름이 공백이 들어올 경우 예외가 발생해야 한다.")
    void checkRacingCarEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(""))
            .withMessageMatching("자동차 이름은 공백이 들어올 수 없다.");
    }

    @Test
    @DisplayName("자동차의 이름이 5자가 초과될 경우 예외가 발생해야 한다.")
    void checkRacingCarNameLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name("abcede"))
            .withMessageMatching("자동차 이름은 5자를 초과할 수 없다.");
    }

    @Test
    @DisplayName("공백이 제거된 이름을 생성할 수 있다.")
    void createNotBlankName() {
        final String input = " n a m e ";
        final Name expected = new Name("name");
        assertThat(Name.createNotBlankName(input)).isEqualTo(expected);
    }
}