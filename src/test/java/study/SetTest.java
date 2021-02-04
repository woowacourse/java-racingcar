package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("Set의 size 메소드를 테스트한다.")
    public void testSetSize() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "Set에 {arguments}의 값이 존재하는지를 테스트한다.")
    @ValueSource(ints = {1, 2, 3})
    public void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "Set의 contains 메소드에 {0}을 넣었을 떄 결과값이 {1}인지 테스트한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void testFailContains(int num, boolean result) {
        assertThat(numbers.contains(num)).isEqualTo(result);
    }
}
