package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarNameParserTest {
    @ParameterizedTest
    @MethodSource("파싱_테스트_데이터_생성")
    @DisplayName("Parser를 사용한 문자열 파싱 테스트")
    public void 파싱_테스트(String text, List<String> expected) {
        Assertions.assertThat(CarNameParser.parsing(text)).isEqualTo(expected);
    }

    static Stream<Arguments> 파싱_테스트_데이터_생성() {
        return Stream.of(
                Arguments.of("a,b,c", List.of("a", "b", "c")),
                Arguments.of("a", List.of("a"))
        );
    }
}