package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("Set 크기 확인")
    void size_메서드로_Set_크기_확인하기() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set 안에 특정 값이 존재하는지 확인")
    void contains_메서드로_특정_값_존재_확인하기(int inputNumber) {
        assertTrue(numbers.contains(inputNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false", "99:false"}, delimiter = ':')
    @DisplayName("Set 안에 특정 값의 존재 여부에 따른 ture/false 값 확인")
    void contains_메서드로_특정_값_존재_여부_확인하기(int inputNumber, boolean expected) {
        assertThat(numbers.contains(inputNumber)).isEqualTo(expected);
    }
}