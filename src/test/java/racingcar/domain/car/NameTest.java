package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameBlankException;
import racingcar.exception.CarNameLengthException;

class NameTest {

    public static final String SAMPLE_NAME = "pobi";

    private Name testName;

    @BeforeEach
    void setUp() {
        testName = new Name(SAMPLE_NAME);
    }

    @DisplayName("자동차 이름은 공백일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void carNameIsNotBlank(String input) {
        assertThatExceptionOfType(CarNameBlankException.class)
            .isThrownBy(() -> new Name(input))
            .withMessageContaining("자동차 이름은 공백이 될 수 없습니다.");
    }

    @DisplayName("Name이 정상적으로 생성")
    @Test
    void carNameWithRightFormat() {
        Assertions.assertThat(new Name(SAMPLE_NAME)).isEqualTo(testName);
    }

    @DisplayName("자동차 이름은 5글자를 초과할 경우 예외 발생")
    @Test
    void carNameGreaterThanFive() {
        String input = "hellow";
        assertThatExceptionOfType(CarNameLengthException.class)
            .isThrownBy(() -> new Name(input))
            .withMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
    }
}
