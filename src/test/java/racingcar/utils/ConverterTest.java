package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    @Test
    @DisplayName("자동차 이름을 쉼표(,)를 기준으로 구분할 수 있다.")
    void convert() {
        List<String> result = Converter.convert("pobi,crong,honux");

        assertThat(result).containsExactly("pobi", "crong", "honux");
    }
}
