package car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    public static final MoveChance MOVABLE_CHANCE = () -> true;

    @Test
    @DisplayName("우승자를 판별하는 테스트")
    void 우승자를_판별한다() {
        Car car1 = new Car("땡칠", 0);
        Car car2 = new Car("물떡", 2);
        Car car3 = new Car("루쿠", 1);
        Game game = new Game(List.of(car1, car2, car3), 1);

        assertThat(game.findWinners()).containsOnly(car2);
    }

    @Test
    @DisplayName("공동 우승자가 있는 경우 테스트")
    void 공동_우승자가_있을_수_있다() {
        Car car1 = new Car("땡칠", 2);
        Car car2 = new Car("물떡", 2);
        Car car3 = new Car("루쿠", 1);
        Game game = new Game(List.of(car1, car2, car3), 1);

        assertThat(game.findWinners()).containsOnly(car1, car2);
    }

    @Test
    void 차가_유일하면_바로_우승자이다() {
        Car car1 = new Car("땡칠", 2);
        Game game = new Game(List.of(car1), 1);

        assertThat(game.findWinners()).containsOnly(car1);
    }

    @Test
    void 차는_1대_이상이어야한다() {
        assertThatThrownBy(() -> new Game(List.of(), 1));
    }

    @Test
    @DisplayName("자동차에게 이동 기회를 주는 테스트")
    void 자동차에게_이동_기회를_준다() {
        Car car = new Car("물떡");
        Game game = new Game(List.of(car), 1);
        game.playOnceWith(MOVABLE_CHANCE);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 중복된_차가_있으면_안된다() {
        List<Car> cars = List.of(new Car("물떡"), new Car("물떡"));
        assertThatThrownBy(() -> new Game(cars, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
