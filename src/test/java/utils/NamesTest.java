package utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NamesTest {

    @ParameterizedTest
    @CsvSource({"'a,'", "porsche"})
    void validateInvalidNamesTest(String line) {
        assertThatThrownBy(() -> new Names(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 1글자부터 5글자까지 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource({"a,b,c", "my,name,is,odo"})
    void validateValidNamesTest(String line) {
        assertThatCode(() -> new Names(line))
                .doesNotThrowAnyException();
    }
}
