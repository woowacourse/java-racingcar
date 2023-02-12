package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
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
    @DisplayName("size를 사용해 Set의 크기를 확인한다.")
    public void sizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("@ValueSource를 사용해 Set에 특정 숫자가 포함되어 있는지 확인한다.")
    public void containsWithValueSourceTest(int value) {
        assertThat(numbers.contains(value)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("@CsvSource를 사용해 Set에 특정 숫자가 포함되어 있는지 확인한다.")
    public void containsWithCsvSourceTest(int value, Boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
