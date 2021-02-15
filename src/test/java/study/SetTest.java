package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers = new HashSet<>();

    @BeforeEach
    void setUp() {
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("사이즈 확인")
    @Test
    void sizeTest() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("1 2 3 들어 있는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsOneTwoThreeTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("parameter가 1,2,3일 땐 True, 4,5일 땐 false")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_fourOrFive_false(int param, boolean result) {
        assertThat(numbers.contains(param)).isEqualTo(result);
    }
}
