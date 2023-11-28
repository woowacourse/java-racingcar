package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

public class ParameterizedStudyTest {

    /**
     * [ValueSource가 지원하는 타입]
     * short (with the shorts attribute)
     * byte (bytes attribute)
     * int (ints attribute)
     * long (longs attribute)
     * float (floats attribute)
     * double (doubles attribute)
     * char (chars attribute)
     * java.lang.String (strings attribute)
     * java.lang.Class (classes attribute)
     */
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void parameterizedTest_with_valueSource(int number) {
        assertThat(number % 2 == 0).isTrue();
    }

    @ParameterizedTest
    @NullSource
    void parameterizedTest_with_nullSource(String input) {
        assertThat(input == null).isTrue();
    }

    @ParameterizedTest
    @EmptySource
    void parameterizedTest_with_emptySource_Array(int[] numbers) {
        assertThat(numbers.length).isZero();
    }

    @ParameterizedTest
    @EmptySource
    void parameterizedTest_with_emptySource_List(List<Integer> numbers) {
        assertThat(numbers.size()).isZero();
    }

    @ParameterizedTest
    @EmptySource
    void parameterizedTest_with_emptySource_String(String input) {
        assertThat(input).isEqualTo("");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void parameterizedTest_with_NullAndEmptySource(String input) {
        assertThat(Strings.isNullOrEmpty(input) || input.isBlank()).isTrue();
    }

    private enum Direction {
        NORTH, EAST, SOUTH, WEST;
    }

    // pass all 4 directions
    @ParameterizedTest
    @EnumSource(value = Direction.class)
    void parameterizedTest_with_EnumSource_All_Passing(Direction direction) {
        assertThat(direction).isIn(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    }

    @ParameterizedTest
    @EnumSource(value = Direction.class, names = {"NORTH", "SOUTH"})
    void parameterizedTest_with_EnumSource_names_filter(Direction direction) {
        assertThat(direction).isIn(Direction.NORTH, Direction.SOUTH);
        assertThat(direction).isNotIn(Direction.EAST, Direction.WEST);
    }

    @ParameterizedTest
    @EnumSource(
            value = Direction.class,
            names = {"NORTH", "SOUTH", "EAST"}, // Enum의 value 이름과 매칭한다. 대소문자 구분한다.
            mode = EnumSource.Mode.EXCLUDE
    )
    void parameterizedTest_with_EnumSource_names_filter_exclude(Direction direction) {
        assertThat(direction).isNotIn(Direction.NORTH, Direction.SOUTH);
        assertThat(direction).isIn(Direction.EAST, Direction.WEST);
    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "java,JAVA"})
    void parameterizedTest_with_CsvSource(String input, String expected) {
        assertThat(input.toUpperCase()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"test:TEST", "java:JAVA"}, delimiter = ':')
    void parameterizedTest_with_CsvSource_Using_Delimiter(String input, String expected) {
        assertThat(input.toUpperCase()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csvFile.txt", numLinesToSkip = 1)
    void parameterizedTest_with_CsvSource_Using_CsvFile(String input, String expected) {
        assertThat(input.toUpperCase()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideStringForIsBlank")
    void parameterizedTest_with_MethodSource(String input, boolean expected) {
        assertThat(StringUtils.isBlank(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringForIsBlank() {
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                String input = "not Empty";
                inputs.add(input);
                continue;
            }

            String input = " ".repeat(i);
            inputs.add(input);
        }

        return Stream.of(
                Arguments.of(inputs.get(0), true),
                Arguments.of(inputs.get(1), true),
                Arguments.of(inputs.get(2), true),
                Arguments.of(inputs.get(3), false)
        );
    }

    private static class BlankStringArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((String) null),
                    Arguments.of(""),
                    Arguments.of(" ")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(BlankStringArgumentsProvider.class)
    void parameterizedTest_with_MethodSource_Using_ArgumentsProvider(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    static Stream<Arguments> arguments = Stream.of(
            Arguments.of(null, true),
            Arguments.of("", true),
            Arguments.of(" ", true),
            Arguments.of("Not Empty", false)
    );

    private static class SlashyDateConverter implements ArgumentConverter {

        @Override
        public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
            if (!(source instanceof String)) {
                throw new IllegalArgumentException("문자열이 아닙니다. 입력값:" + source);
            }

            try {
                String[] parts = ((String) source).split("/");
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);

                return LocalDate.of(year, month, day);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("숫자가 아닙니다. 입력값:" + source);
            }
        }
    }

    @ParameterizedTest
    @CsvSource({"2023/11/28", "2023/12/28"})
    void parameterizedTest_with_CustomConverter(@ConvertWith(SlashyDateConverter.class) LocalDate date) {
        assertThat(date.getYear()).isEqualTo(2023);
        assertThat(date.getMonth()).isGreaterThan(Month.OCTOBER);
        assertThat(date.getDayOfMonth()).isEqualTo(28);
    }

    @ParameterizedTest(name = "{index} - Parameter is {0}")
    @EnumSource(value = Direction.class, names = {"SOUTH", "NORTH"})
    void displayNameTest(Direction direction) {
    }
}
