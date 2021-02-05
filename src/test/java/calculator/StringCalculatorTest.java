package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

  @Test
  public void splitAndSum_null_or_empty_string() {
    int result = StringCalculator.splitAndSum(null);
    assertThat(result).isEqualTo(0);

    result = StringCalculator.splitAndSum("");
    assertThat(result).isEqualTo(0);
  }

  @Test
  public void splitAndSum_one_number() throws Exception {
    int result = StringCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void splitAndSum_comma_delimiter() throws Exception {
    int result = StringCalculator.splitAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void splitAndSum_comma_or_colon_delimiter() throws Exception {
    int result = StringCalculator.splitAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_custom_delimiter() throws Exception {
    int result = StringCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }

}