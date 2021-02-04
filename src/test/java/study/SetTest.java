package study;

import org.junit.jupiter.api.BeforeEach;
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
    
    @Test
    public void sizeTest() {
        
        // when
        int size = 3;
        
        // then
        assertThat(size).isEqualTo(3);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int input) {
        
        // when
        boolean hasNumber = numbers.contains(input);
    
        // then
        assertThat(hasNumber).isTrue();
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    void compareTest(String input, boolean expected) {
        
        // given
        String[] inputNumbers = input.split(",");
        
        for (String number : inputNumbers) {
            
            // when
            boolean hasNumber = numbers.contains(Integer.parseInt(number));
            
            // then
            assertThat(hasNumber).isEqualTo(expected);
        }
    }
}
