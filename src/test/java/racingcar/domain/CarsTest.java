package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차의_이름들이_빈_문자열인지_검증() {
        String input = "";
        assertThatThrownBy(() -> {
            Cars.validateNames(input);
        }).isInstanceOf(Exception.class);
    }
}
