package study;

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

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("numbers의 사이즈는 3이다.")
    void checkSetSize () {
        int result = numbers.size();
        int expect = 3;
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "{0} 포함해야 한다.")
    @ValueSource(ints = {1,2,3})
    void checkContain (int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest(name = "{0} 값이 포함되어있으면 true, 없으면 false를 반환")
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"})
    void checkContainBoolean(int value, boolean expect) {
        assertThat(numbers.contains(value)).isEqualTo(expect);
    }
 }
