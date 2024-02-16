package model;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.Exception;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
  private Car pobi;
  private Car left;

  @BeforeEach
  void setUp() {
    pobi = new Car("포비");
    left = new Car("왼손");
  }

  @Test
  @DisplayName("자동차들이 중복된 이름을 가질 시 예외가 발생한다.")
  void validateDuplicate() {
    assertThatThrownBy(() -> new Game(of("포비", "포비")))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(Exception.DUPLICATE.toString());
  }

  @Test
  @DisplayName("우승자를 알아 낼 수 있다.")
  void findWinner() {
    Game game = new Game(of(pobi.getName(), left.getName()));
    pobi.forward();
    left.stop();
    assertThat(game.findWinners(List.of(pobi, left))).isEqualTo(List.of(pobi));
  }

  @Test
  @DisplayName("공동 우승자를 알아 낼 수 있다")
  void findWinners() {
    Game game = new Game(of(pobi.getName(), left.getName()));
    pobi.forward();
    left.forward();
    assertThat(game.findWinners(List.of(pobi, left))).isEqualTo(List.of(pobi, left));
  }
}
