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
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 사이즈를 확인한다")
    void CheckSetSize() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 원소 포함 유무를 확인한다")
    void CheckSetNumbers(int number) {
        assertThat(numbers.contains(number)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("Set의 원소 포함 유무를 확인한다")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void CheckSetNumbersWithOutOfIndex(int number, boolean isExisting) {
        assertThat(numbers.contains(number)).isEqualTo(isExisting);
    }
}
