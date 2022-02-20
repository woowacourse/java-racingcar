package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("Set 컬렉션의 크기를 구한다.")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 컬랫션에 원소가 존재하는지 확인한다")
    @ParameterizedTest(name = "{index} {displayName} key={0}")
    @ValueSource(ints = {1, 2, 3})
    void containTest(final int key) {
        assertThat(numbers.contains(key)).isTrue();
    }

    @DisplayName("Key 값으로 value값의 존재를 판단한다.")
    @ParameterizedTest(name = "{index} {displayName} key={0} expected={1}")
    @CsvSource(value = {"1:true", "4:false"}, delimiter = ':')
    void findValueTest(int key, boolean expected) {
        assertThat(numbers.contains(key)).isEqualTo(expected);
    }
}
