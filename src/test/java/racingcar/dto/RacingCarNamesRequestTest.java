package racingcar.dto;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarNamesRequestTest {

    @ParameterizedTest
    @DisplayName("자동차의 이름이 6글자를 초과하면 예외가 발생해야 한다.")
    @ValueSource(strings = {"carcar", "car,carcar", "car,car2,carcar"})
    void car_nameLengthOverThanSix(String input) {
        // expect
        assertThatThrownBy(() -> RacingCarNamesRequest.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_CAR_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @DisplayName("중복된 자동차 이름이 검증되어야 한다.")
    @ValueSource(strings = "car1,car2,car1")
    void validate_duplicateCarNames(String input) {
        // expect
        assertThatThrownBy(() -> RacingCarNamesRequest.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @DisplayName("중복되지 않는 자동차 이름이 검증되어야 한다.")
    @ValueSource(strings = "car1,car2,car3")
    void validate_noDuplicateCarNames(String input) {
        // expect
        assertThatCode(() -> RacingCarNamesRequest.of(input))
                .doesNotThrowAnyException();
    }
}
