package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

  @DisplayName("0에서 9 사이에서 random한 값을 구할 수 있다.")
  @RepeatedTest(100)
  void run() {
    assertThat(RandomGenerator.run(1))
            .containsAnyOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
  }
}
