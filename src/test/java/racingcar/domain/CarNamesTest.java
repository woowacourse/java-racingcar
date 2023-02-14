package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void getNamesTest() {
        String input = "test1, test2, test3";
        CarNames carNames = new CarNames(input);

        assertThat(carNames.getNames()).containsExactly("test1", "test2", "test3");
    }

    @Test
    @DisplayName("중복된 자동차 이름 입력시 예외 발생 테스트")
    void duplicatedNameExceptionTest() {
        String input = "test, test2, test";

        assertThatThrownBy(() -> new CarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_INPUT.getMessage());
    }

}
