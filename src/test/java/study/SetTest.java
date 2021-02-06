package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

@DisplayName("Test Set for studying JUnit and AssertJ")
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Test for set size")
    @Test
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Test for contain all numbers")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsAllNumber(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Test for contain each numbers")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsEachNumber(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> integerInSetTable() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(5, false),
                Arguments.of(6, false)
        );
    }

    @DisplayName("Test for contain each numbers")
    @ParameterizedTest
    @MethodSource("integerInSetTable")
    void compareWithTable(int input, boolean isExist) {
        assertThat(numbers.contains(input)).isEqualTo(isExist);
    }

    @DisplayName("Test for null source")
    @ParameterizedTest
    @NullSource
    void expectNullPointerException(Integer i) {
        assertThatThrownBy(() -> {
            i.toString();
        }).isInstanceOf(NullPointerException.class);
    }
}