package study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
  void size() {
    int size = numbers.size();
    assertThat(size).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void contains(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
  void contains(String input, boolean expected) {
    List<Integer> inputList = Arrays.stream(input.split(","))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toList());

    Assertions.assertEquals(numbers.containsAll(inputList), expected);
  }

}
