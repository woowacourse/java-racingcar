package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    
    
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    void compareTest(String input, boolean expected) {
        String[] inputNumbers = input.split(",");
        for (String number : inputNumbers) {
            assertThat(numbers.contains(Integer.parseInt(number))).isEqualTo(expected);
        }
    }
}
