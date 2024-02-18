package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarNameTest {
  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("이름이 없을 시 예외가 발생한다.")
  void validateNullAndEmpty(String input) {
    assertThatThrownBy(() -> new CarName(input)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("이름이 6자 이상일 시 예외가 발생한다.")
  void validateNameLength() {
    String name = "abcdefg";
    assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
  }
}
