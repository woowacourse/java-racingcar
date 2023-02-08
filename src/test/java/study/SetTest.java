package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    @DisplayName("set.size() 메서드 사용 테스트")
    void setSizeTest() {
        int size = numbers.size();
        Assertions.assertThat(size).isEqualTo(5);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set 요소 포함 확인 테스트")
    void setContainsParmaterizedTest(int checkingValue) {
        assertTrue(numbers.contains(checkingValue));
    }

}
