package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.exception.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"carca24r", "dfjaksl", "dkfsiqrfjkvsj", "125231242"})
    @DisplayName("이름 길이가 6보다 커서는 안 된다.")
    void shouldBeNameLengthLowerThanSix(String input) {
        // expected
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_CAR_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @DisplayName("공백인 자동차 이름이 검증되어야 한다.")
    @ValueSource(strings = {" ", "", "\n", "    "})
    void validate_blankCarName(String input) {
        // expected
        Assertions.assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }
}
