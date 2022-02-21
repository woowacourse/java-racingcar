package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SeparatorTest {

    private final Separator separator = new Separator();

    @DisplayName("문자열 분리 기능 테스트")
    @ParameterizedTest(name = "[{index}] 입력 : \"{0}\", 기대 : {1}")
    @MethodSource("provideForExtractCustomUnitsTest")
    void extractCustomUnitsTest(final String text, final List<String> expected) {
        final List<String> actual = separator.splitByUnits(text);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> provideForExtractCustomUnitsTest() {
        return Stream.of(
                Arguments.of("111", Arrays.asList("111")),
                Arguments.of("1,1", Arrays.asList("1", "1")),
                Arguments.of("//a\n1a1", Arrays.asList("1", "1")),
                Arguments.of("//,+\n1,a+1b", Arrays.asList("1", "a", "1b")),
                Arguments.of("//-()\n1(a)1", Arrays.asList("1", "a", "1"))
        );
    }

}
