package study;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("size 메소드 - 올바른 크기 반환")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("contains 메소드 - 값이 존재하는지 확인")
    @ValueSource(ints = {1,2,3})
    void containsTestWithParameter(int target) {
        assertTrue(numbers.contains(target));
    }

    @ParameterizedTest
    @DisplayName("contains 메소드 - 값이 존재하는지 확인(존재하지 않는 값도 입력)")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void containsTestWithCsvParameter(int target, boolean isContain) {
        assertThat(numbers.contains(target)).isEqualTo(isContain);
    }

}
