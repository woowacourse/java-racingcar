package study;

<<<<<<< HEAD
import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
=======
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
>>>>>>> 0eeabe8 (test: HashSet 사이즈 테스트)

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertTrue;
=======
>>>>>>> 0eeabe8 (test: HashSet 사이즈 테스트)

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
    void getSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }
<<<<<<< HEAD

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void hasNumber(int sameNumber) {
        assertThat(numbers.contains(sameNumber)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void findNumber(int sameNumber, boolean result) {
        assertThat(numbers.contains(sameNumber)).isEqualTo(result);
    }
=======
>>>>>>> 0eeabe8 (test: HashSet 사이즈 테스트)
}