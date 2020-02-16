package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

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
