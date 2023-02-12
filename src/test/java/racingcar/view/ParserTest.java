package racingcar.view;

import static java.text.MessageFormat.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    private final Parser parser = new Parser();

    private static Stream<Arguments> generateNamesInput() {
        return Stream.of(
                Arguments.of(",,", List.of("", "", "")),
                Arguments.of("허브,다즐", List.of("허브", "다즐")),
                Arguments.of("우테코", List.of("우테코"))
        );
    }

    @ParameterizedTest(name = "입력: {0} / 출력: {1}")
    @MethodSource("generateNamesInput")
    @DisplayName("parseNames 메서드는 쉼표로 분리된 이름 목록을 반환한다.")
    void should_getNamesList_when_parseNames(final String input, final List<String> expected) {
        final List<String> result = parser.parseNames(input);

        assertThat(result).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "입력: {0} / 출력: {1}")
    @CsvSource(value = {"-100:-100", "-1:-1", "0:0", "1:1", "100:100"}, delimiter = ':')
    @DisplayName("parseCount 메서드는 문자열에 알맞은 숫자를 반환한다.")
    void should_returnNumber_when_parseCount(final String input, final int expected) {
        final int result = parser.parseCount(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력 : {0}")
    @ValueSource(strings = {"a", "A", "가", "@", " "})
    @DisplayName("parseCount 메서드는 문자열을 숫자로 변환할 수 없으면 예외를 던진다.")
    void should_throwException_when_inputNotConvertToNumber(final String input) {
        assertThatThrownBy(() -> parser.parseCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(format("입력된 횟수[{0}]: 횟수는 숫자만 가능합니다.", input));
    }
}
