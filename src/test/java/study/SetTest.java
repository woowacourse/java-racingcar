package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
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
    @DisplayName("Set의 크기를 확인하는 학습테스트")
    void getSetSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "{index}번째 : {0}이 set에 포함되어있는지 테스트")
    @ValueSource(ints = {1,2,3})
    void containsTest(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "{index}번째 : {0}이 포함되어있다면 true 아니면 false를 반환한다")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    void contains_ShouldReturnTheExpectedValue(int input, boolean result){
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
