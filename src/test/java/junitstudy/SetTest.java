package junitstudy;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("Set size 확인")
    public void set_size_확인() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set값 전체 존재 확인")
    public void set값_전체_존재_확인(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:True", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set값 존재 여부 구별")
    public void set값_존재_여부_구별(int value, boolean result) {
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
