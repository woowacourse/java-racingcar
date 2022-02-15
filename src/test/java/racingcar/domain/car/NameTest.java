package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameBlankException;
import racingcar.exception.CarNameLengthException;

public class NameTest {

    private Name testName;

    @BeforeEach
    void setUp() {
        testName = new Name("pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void carNameIsNotBlank(String input) {
        assertThatExceptionOfType(CarNameBlankException.class)
            .isThrownBy(() -> new Name(input))
            .withMessageContaining("자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("null 값으로 이름을 생성할 수 없다.")
    public void errorOnCarNameNull() {
        // given
        String input = null;
        // then
        Assertions.assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carNameWithRightFormat() {
        String input = "pobi";
        Assertions.assertThat(new Name(input)).isEqualTo(testName);
    }

    @Test
    void carNameGreaterThanFive() {
        String input = "hellow";
        assertThatExceptionOfType(CarNameLengthException.class)
            .isThrownBy(() -> new Name(input))
            .withMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
    }
}
