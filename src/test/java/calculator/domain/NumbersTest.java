package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @Test
    @DisplayName("합계를 계산하는 부분")
    void calculateSumTest(){
        List<Number> numbers = new ArrayList<Number>();
        for(int i = 1; i <= 10; i++) {
            numbers.add(new Number(Integer.toString(i)));
        }
        assertThat(new Numbers(numbers).calculateSum()).isEqualTo(55);
    }
}
