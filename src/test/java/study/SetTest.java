package study;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메서드는 Set의 크기를 반환한다.")
    @Test
    void size() {
        int sizeResult = numbers.size();

        assertThat(sizeResult).isEqualTo(3);
    }

    @DisplayName("contains 메서드는 Set에 특정 값이 존재하는지 확인한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        boolean containsResult = numbers.contains(number);

        assertThat(containsResult).isTrue();
    }

    @DisplayName("contains 메서드는 Set에 특정 값의 존재 여부에 대해 참/거짓을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void containsOrNot(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
