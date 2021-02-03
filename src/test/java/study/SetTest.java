package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @ParameterizedTest(name = "Test {index}: {arguments}")
    @ValueSource(ints = {1,2,3})
    @DisplayName("contains")
    void contains_ShouldContainInputValue(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "Test {index}: {arguments}")
    @CsvSource(value = {"1:True","2:True","3:True","4:False","5:False"}, delimiter = ':')
    @DisplayName("contains with different results")
    void contains_ShouldGenerateTheExpectedBooleanResult(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
