package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("set 사이즈 확인")
    void check_size() {
        assertEquals(numbers.size(), 3);
        assertNotEquals(numbers.size(), 8);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contain_success(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @DisplayName("set 에 포함되어 있는지, 안되어있는지 테스트")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void contain(int number, boolean expected) {
        assertEquals(numbers.contains(number), expected);
    }
}
