package racingcar.view.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ErrorMessage;

class CarNamesRequestTest {
    @DisplayName("자동차 이름 입력에 빈 값이 입력될 수 없습니다")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void validateRangeTest(String input) {
        assertThatThrownBy(() -> {
            new CarNamesRequest(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_NULL.message());
    }
}
