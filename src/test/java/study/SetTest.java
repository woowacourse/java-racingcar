package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("Set을 사용하면 중복이 제거된 사이즈가 조회된다.")
    void 집합_사이즈_조회_테스트() {
        // when
        int size = numbers.size();

        // then
        assertThat(size)
                .isEqualTo(3);
    }

    @DisplayName("set에 포함 여부를 paramterized test로 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 집합_포함_여부_paramaterizedTest(int input) {
        assertTrue(numbers.contains(input));
    }

    @DisplayName("set의 포함 여부를 유동적으로 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 집합_포함_유동적으로_확인(int input, boolean expected) {
        Assertions.assertThat(numbers.contains(input))
                .isEqualTo(expected);
    }
}
