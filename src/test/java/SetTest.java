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

    @DisplayName("집합의 초기값을 설정한다.")
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("집합의 크키가 맞는지 확인한다.")
    @Test
    void hasThreeElements() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("집합에서 해당되는 값이 존재여부를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
            assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("집합에서 해당되는 값이 존재여부를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsOneToFive(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }

}

