package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {
    public static final String DELIMITER = ",";

    @ParameterizedTest
    @MethodSource("파싱_테스트_데이터_생성")
    @DisplayName("Parser를 사용한 문자열 파싱 테스트")
    public void 파싱_테스트(String text, String delimiter, List<String> expected) {
        Assertions.assertThat(Parser.parsing(text, delimiter)).isEqualTo(expected);
    }

    static Stream<Arguments> 파싱_테스트_데이터_생성() {
        return Stream.of(
                Arguments.of("a,b,c", DELIMITER, Arrays.asList("a", "b", "c")),
                Arguments.of("a", DELIMITER, List.of("a"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "a a", " bb", "a ,bb"})
    @DisplayName("공백이 포함된 경우 파싱 예외 테스트")
    public void 파싱_예외_테스트(String text) {
        Assertions.assertThatThrownBy(() -> Parser.parsing(text, DELIMITER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 포함된 문자는 입력할 수 없습니다.");
    }
}