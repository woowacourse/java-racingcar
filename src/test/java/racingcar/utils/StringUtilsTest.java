package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

    @Test
    @DisplayName("자동차 이름을 쉼표(,) 기준으로 분리 테스트")
    void splitNameTest() {
        String values = "pobi,crong,honux";
        String[] expected = {"pobi", "crong", "honux"};

        String[] result = StringUtils.splitInputName(values);

        Assertions.assertThat(result).containsExactly(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"po bi", "  pobi  "})
    void removeAllBlankInName(String name) {
        String expected = "pobi";
        String result = StringUtils.removeAllBlank(name);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "", "     "})
    void removeAllBlankInName_When_EmptyString(String name) {
        String expected = "";
        String result = StringUtils.removeAllBlank(name);
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
