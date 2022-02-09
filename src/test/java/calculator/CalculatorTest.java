package calculator;

import static org.assertj.core.api.Assertions.assertThat;

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
}
