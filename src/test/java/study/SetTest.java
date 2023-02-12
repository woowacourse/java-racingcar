package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
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
    @DisplayName("Size Check")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.size()).isNotEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContained(int number) {
        Assertions.assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void isContained2(int number, boolean expected) {
        Assertions.assertEquals(numbers.contains(number), expected);
    }
}
