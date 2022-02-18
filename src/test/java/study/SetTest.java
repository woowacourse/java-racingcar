package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;


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

    // Test Case 구현
    @Test
    @DisplayName("set size 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Nested
    class contains {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void success(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }

        @ParameterizedTest
        @CsvSource({"1,true", "2,true", "3,true", "4,fail", "5,fail"})
        void successAndFail(int input, boolean expected) {
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }
    }
}
