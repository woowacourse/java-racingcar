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
    public void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set 내부의 값이 존재하면 True 반환")
    public void checkNumberSuccess(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 100})
    @DisplayName("Set 내부의 값이 존재하지 않으면 False 반환")
    public void checkNumberFail(int number) {
        assertThat(numbers.contains(number)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "0:false", "4:false", "100:false"}, delimiter = ':')
    @DisplayName("Set 내부의 값이 존재하면 True, 존재하지 않으면 False 반환")
    public void checkNumber(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
