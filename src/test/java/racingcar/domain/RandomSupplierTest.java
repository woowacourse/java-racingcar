package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomSupplierTest {

  @Test
  @DisplayName("랜덤 바운드 검사")
  public void randomBound() throws Exception{
    for (int i = 0; i < 100; i++) {
      Assertions.assertThat(new RandomSupplier().get()).isBetween(0,9);
    }
  }

}