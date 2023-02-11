package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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

    // Test Case 구현
    @Test
    @DisplayName("Set의 크기 확인 테스트")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "contains 메소드 테스트 - {0} 포함 테스트")
    @ValueSource(ints = {1, 2, 3})
    void setContainsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "contains 메소드 테스트 - {0} 포함, 결과 : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContainsTest2(int number, boolean expectedValue) {
        assertThat(numbers.contains(number)).isEqualTo(expectedValue);
    }
}
