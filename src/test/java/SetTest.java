import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("set의 크기를 구한다")
    void sizeTest() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @DisplayName("특정 숫자를 포함한다.")
    @ParameterizedTest(name = "{0}를 포함한다. ")
    @ValueSource(ints = {1,2,3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("특정 숫자를 포함한다")
    @ParameterizedTest(name = "{0}의 경우 {1}를 반환한다 ")
    @CsvSource(value = {"1:true", "2:true", "4:false"}, delimiter = ':')
    void contains(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}