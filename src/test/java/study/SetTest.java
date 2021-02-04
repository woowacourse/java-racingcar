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

@DisplayName("Test Set for studying JUnit and AssertJ")
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

    @DisplayName("Test for set size")
    @Test
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Test for contain all numbers")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsAllNumber(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Test for contain each numbers")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsEachNumber(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
/*
앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 “1;2;3//;\n과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며,
'더하기를 실행하는' 결과 값은 6이 반환되어야 한다
 */