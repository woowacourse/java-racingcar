package util;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilTest {

  @DisplayName("추출한 난수가 한 자릿수인지 확인하는 테스트")
  @RepeatedTest(value = 10, name = "{totalRepetitions}번 중 {currentRepetition}번째 시도")
  public void 난수_한자릿수_검증() {
    int randomNum = RandomUtil.getDigit();
    Assertions.assertThat(randomNum <= 9 && randomNum >= 0).isTrue();
  }
}