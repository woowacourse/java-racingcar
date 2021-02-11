package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("set 사이즈 출력")
    void size() {
        assertEquals(numbers.size(), 3);
    }

    @ParameterizedTest
    @DisplayName("set 삽입 후 존재 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("set 삽입하지 않은 값 존재 유무 확인")
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    void trueOrFalse(int input, boolean actual) {
        boolean check = numbers.contains(input);
        assertEquals(actual, check);
    }
}
