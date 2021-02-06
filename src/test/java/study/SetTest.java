package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    @DisplayName("Set의 크기가 3인 확인한다")
    void setShouldHaveThreeElements() {
        int hashSetSize = numbers.size();
        assertThat(hashSetSize).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set이 1,2,3 값을 가지고 있어야 한다")
    @ValueSource(ints = {1,2,3})
    void setShouldHaveOneAndTwoAndThree(int element) {
        //assertThat(numbers).contains(element);
        assertTrue(numbers.contains(element));
    }

    @ParameterizedTest
    @DisplayName("Set이 1,2,3 이외의 값을 가지면 안된다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "true:false", "4:false", "5:false"}, delimiter = ':')
    void setMustNotHaveOthersThanOneAndTwoAndThree(String input, boolean expected) {
        if (!isNumeric(input)) {
           assertEquals(isNumeric(input), expected);
           return;
        }

        int num = Integer.parseInt(input);
        assertEquals(numbers.contains(num), expected);
    }

    boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
