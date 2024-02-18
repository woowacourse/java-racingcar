package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryHelperTest {

  @Test
  @DisplayName("재시도 횟수가 최대값을 넘지 않는 경우")
  void retry() {
    final int[] retryCount = {0};
    RetryHelper retryHelper = new RetryHelper(2);
    retryHelper.retry(() -> {
      if (retryCount[0] > 0) {
        return "test";
      }
      retryCount[0]++;
      throw new RuntimeException("재시도");
    });
  }

  @Test
  @DisplayName("재시도 횟수가 최댓값을 넘는 경우 예외 발생")
  void retryTimeOver() {
    final int[] retryCount = {0};
    RetryHelper retryHelper = new RetryHelper(2);
    Assertions.assertThatThrownBy(() -> retryHelper.retry(() -> {
          if (retryCount[0] > 2) {
            return "test";
          }
          retryCount[0]++;
          throw new RuntimeException("재시도");
        }))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("프로그램이 비정상 종료되었습니다.");

  }
}