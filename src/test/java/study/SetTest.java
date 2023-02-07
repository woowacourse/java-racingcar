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

  @Test
  void sizeOfSet() {
    int target = numbers.size();
    int expected = 3;
    assertThat(target).isEqualTo(expected);
  }

  @Test
  void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints={1,2,3})
  void containsRemoveDp(Integer input){
    assertThat(numbers.contains(input)).isTrue();
  }

  @DisplayName("numbers에 포함되는 숫자인지 확인하는 테스트")
  @ParameterizedTest(name = "{0} 의 경우 {1}")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void containsTotal(Integer input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
