package study;

//import org.junit.Test;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.HashSet;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    // Test Case 구현
    @DisplayName("Set 크기 확인")
    @Test
    public void setSize() {
        int length = numbers.size();
        assertThat(length).isEqualTo(4);
    }

    @DisplayName("Parameterized Test를 통한 contains 메소드 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Parameterized Test: False Case")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        boolean actualValue = numbers.contains(Integer.parseInt(input));

        assertEquals(Boolean.parseBoolean(expected), actualValue);
    }

}
