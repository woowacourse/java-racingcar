package model;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import constant.Exception;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

  @Test
  @DisplayName("자동차들이 중복된 이름을 가질 시 예외가 발생한다.")
  void validateDuplicate() {
    assertThatThrownBy(() -> new Game(of("포비", "포비")))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(Exception.DUPLICATE.toString());
  }

  @Test
  @DisplayName("자동차들을 전진 혹은 정지시킨다.")
  void proceed() {
    List<Car> cars = new Game(of("포비", "왼손")).proceed(of(4, 3));

    Car pobi = new Car("포비");
    pobi.forward();
    Car left = new Car("왼손");
    left.stop();

    assertAll(
        () -> assertThat(cars).containsExactly(pobi, left),
        () -> assertThat(cars.get(0).getStatuses()).isEqualTo(of(CarStatus.FORWARD)),
        () -> assertThat(cars.get(1).getStatuses()).isEqualTo(of(CarStatus.STOP)));
  }

  @Test
  @DisplayName("우승자를 알아 낼 수 있다.")
  void findWinner() {
    Game game = new Game(of("포비", "왼손"));
    game.proceed(of(4, 0));
    assertThat(game.findWinners()).extracting(Car::getName).isEqualTo(List.of("포비"));
  }

  @Test
  @DisplayName("공동 우승자를 알아 낼 수 있다")
  void findWinners() {
    List<String> winners = List.of("포비", "왼손");
    Game game = new Game(winners);
    game.proceed(of(4, 5));
    assertThat(game.findWinners()).extracting(Car::getName).isEqualTo(winners);
  }

  @Test
  @DisplayName("자동차 경주에 참가하는 자동차 개수를 알 수 있다")
  void getParticipantsSize() {
    Game game = new Game(of("포비", "왼손"));
    assertThat(game.getParticipantsSize()).isEqualTo(2);
  }
}
