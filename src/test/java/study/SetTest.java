package study;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("numbers의 크기는 3이다")
    void set_size_method_test() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "numbers는 {0}을 포함한다")
    @ValueSource(ints = {1, 2, 3})
    void contains_test(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "numbers가 {0}을 포함하는 것은 {1}이다")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_test2(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
