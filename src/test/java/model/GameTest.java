package model;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

  @Test
  @DisplayName("우승자를 알아 낼 수 있다.")
  void winners() {
    Car pobi = new Car("pobi");
    Car left = new Car("left");
    pobi.move(4);
    assertThat(new Game().winners(new Cars(of(pobi, left)))).isEqualTo(new Cars(of(pobi)));
  }
}
