package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    @DisplayName("자동차 이름을 입력하지 않은 경우 예외 발생")
    void carNameMustNotBeEmpty() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백을 포함하는 자동차 이름을 입력한 경우 예외 발생")
    void carNameMustNotContainBlank() {
        assertThatThrownBy(() -> new CarName("h i"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다섯 글자 이상의 자동차 이름을 입력한 경우 예외 발생")
    void carNameMustLessThanFiveLetters() {
        assertThatThrownBy(() -> new CarName("wooteco"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
