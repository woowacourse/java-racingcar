import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

public class Test2 {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @ParameterizedTest(name = "{index} => number={0}, expected={1}")
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"}, delimiter = ',')
    void csvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자인지 판별하는 메소드이다.")
    void checkNumeric() {
        String str = "14";
        boolean isDigit = str.chars().allMatch(Character::isDigit);
        assertThat(isDigit).isTrue();
    }
}
