package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("set의 size()메소드를 통해 크기 확인")
    @Test
    void test1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "contains({arguments})를 호출하였을 때, 해당 값이 set에 존재하면 true를 반환한다.")
    @ValueSource(ints = {1, 2, 3})
    void test2(final int index) {
        assertThat(numbers.contains(index)).isTrue();
    }

    @ParameterizedTest(name = "contains() 를 호출하였을 때, 해당 값이 set에 존재하면 true를, 없으면 false를 반환한다.")
    @CsvSource(value = {"0,false", "1,true", "2,true", "3,true", "4,false"})
    void test3(final int index, final boolean expected) {
        assertThat(numbers.contains(index)).isEqualTo(expected);
        assertThat('\0').isEqualTo(',');
    }
}
