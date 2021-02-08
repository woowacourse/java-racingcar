package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

  @Test
  @DisplayName("splitAndSum - null 또는 빈문자")
  public void splitAndSum_nullOrBlank() {
    int result = StringCalculator.splitAndSum(null);
    assertThat(result).isEqualTo(0);

    result = StringCalculator.splitAndSum("");
    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("splitAndSum - 숫자하나")
  public void splitAndSum_aNumber() throws Exception {
    int result = StringCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  @DisplayName("splitAndSum - 쉼표구분자")
  public void splitAndSum_comma() throws Exception {
    int result = StringCalculator.splitAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  @DisplayName("splitAndSum - 쉼표 또는 콜론 구분자")
  public void splitAndSum_commaOrColon() throws Exception {
    int result = StringCalculator.splitAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("splitAndSum - custom 구분자")
  public void splitAndSum_customDelimiter() throws Exception {
    int result = StringCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("splitAndSum - 음수")
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }

}