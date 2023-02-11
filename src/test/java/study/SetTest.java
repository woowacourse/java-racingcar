package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    @DisplayName("셋_사이즈_테스트")
    public void set_사이즈_테스트() {
        int expectedSize = 3;
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    @DisplayName("특정_원소를_가지고_있는지_체크하는_기능을_테스트")
    public void 특정_원소를_가지고_있는지_체크하는_기능을_테스트(final int target, final boolean expected) {
        assertThat(numbers.contains(target)).isEqualTo(expected);
    }
}
