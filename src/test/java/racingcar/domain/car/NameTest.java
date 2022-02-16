package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(input))
            .withMessageContaining("자동차 이름은 공백이 될 수 없습니다.");
    }

    @DisplayName("Name이 정상적으로 생성")
    @Test
    void carNameWithRightFormat() {
        assertThat(new Name(SAMPLE_NAME)).isEqualTo(testName);
    }

    @DisplayName("자동차 이름은 5자를 초과할 경우 예외 발생")
    @Test
    void carNameGreaterThanFive() {
        String input = "hellow";
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(input))
            .withMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
    }

    @DisplayName("자동차 이름이 5자일 경우 정상적으로 생성")
    @Test
    void Should_SuccessToCar_When_NameIsFiveLength() {
        String input = "seung";
        Name name = new Name(input);
        assertThat(name.getName()).isEqualTo(input);
    }
}
