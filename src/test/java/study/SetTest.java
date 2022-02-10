package study;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("size() 메서드를 사용하면 Set의 크기를 반환한다.")
    @Test
    void size_Use_ReturnCardinality() {
        // given & when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("contains() 메서드를 활용하여 특정 값이 존재하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_ExistsNumber_ReturnTrue(final int input) {
        // given & when & then
        assertThat(numbers).contains(input);
    }

    @DisplayName("1, 2, 3인 경우 true를 반환하고, 4, 5인 경우 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_ExistsOrNoneExistsNumber_ReturnTrueOrFalse(String input, String expected) {
        // given & when & then
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.parseBoolean(expected));
    }
}
