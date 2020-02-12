package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 자동차_이름이_빈_문자열인지_검증() {
        String input = "";
        assertThatThrownBy(() -> {
            Car.validateName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
