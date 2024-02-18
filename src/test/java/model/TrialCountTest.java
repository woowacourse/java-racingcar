package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import response.Exception;

class TrialCountTest {
  @ParameterizedTest
  @ValueSource(ints = {-1, 0})
  @DisplayName("숫자가 양수가 아닐 시 예외가 발생한다.")
  void validatePositive(int number) {
    assertThatThrownBy(() -> new TrialCount(number))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(Exception.POSITIVE.getMessage());
  }

  @Test
  @DisplayName("횟수가 남아있는지 알 수 있다.")
  void isRest() {
    TrialCount trialCount = new TrialCount(1);
    assertAll(
        () -> assertThat(trialCount.isRest()).isTrue(),
        () -> trialCount.reduce(),
        () -> assertThat(trialCount.isRest()).isFalse());
  }
}
