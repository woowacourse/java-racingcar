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
    @DisplayName("Set의 사이즈를 구한다")
    void calculateSetSize() {
        //given
        int size = 3;

        //when
        int result = numbers.size();

        //then
        assertThat(result).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set가 특정값을 가지고 있음을 테스트한다")
    void checkSetContainsValueOnlyTrue(int value) {
        //given
        //when
        //then
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set가 특정값을 가지고 있는 경우, 가지고 있지 않은 경우를 모두 테스트한다")
    void checkSetContainsValue(int value, boolean isContain) {
        //given
        //when
        //then
        assertThat(numbers.contains(value)).isEqualTo(isContain);
    }
}
