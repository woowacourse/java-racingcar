package util;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilTest {

  @RepeatedTest(value = 10, name = "{totalRepetitions}번 중 {currentRepetition}번째 시도")
  public void 한자릿수_추출() {
    int randomNum = RandomUtil.getZeroToNine();
    Assertions.assertThat(randomNum <= 9 && randomNum >= 0).isTrue();
  }
}