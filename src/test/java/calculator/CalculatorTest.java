package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void sum_null_test() throws Exception {
    int inputResult = Calculator.sum(null);
    assertThat(inputResult).isEqualTo(0);
  }

  @Test
  public void sum_blank_test() throws Exception {
    int inputResult = Calculator.sum("");
    assertThat(inputResult).isEqualTo(0);
  }

  @Test
  public void sum_split_test() throws Exception {
    String[] numbers = Calculator.split("1,2");
    assertThat(numbers).contains("1", "2");
  }

  @Test
  public void sum_split_custom_delimiter_test() throws Exception {
    String[] numbers = Calculator.split("//;\n1;2;3");
    assertThat(numbers).contains("1", "2", "3");
  }

  @Test
  public void toIntegers_test() throws Exception {
    String[] stringNumbers = {"1", "2"};
    int[] numbers = Calculator.toIntegers(stringNumbers);
    assertThat(numbers).contains(1, 2);
  }

  @Test
  public void toIntegers_숫자가_아닌_입력_test() throws Exception {
    String[] stringNumbers = {"a", "b"};
    assertThatThrownBy(() -> Calculator.toIntegers(stringNumbers))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void toIntegers_음수_입력_test() throws Exception {
    String[] stringNumbers = {"-1", "-2"};
    assertThatThrownBy(() -> Calculator.toIntegers(stringNumbers))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void addAll_test() throws Exception {
    int[] numbers = {1, 2};
    int result = Calculator.addAll(numbers);
    assertThat(result).isEqualTo(3);
  }
}
