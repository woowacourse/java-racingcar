package car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    public static final MoveChance MOVABLE_CHANCE = () -> true;
    @Test
    @DisplayName("우승자를 판별하는 테스트")
    void 우승자를_판별한다() {
        Car car1 = new Car("땡칠", 0);
        Car car2 = new Car("물떡", 2);
        Car car3 = new Car("루쿠", 1);
        Game game = new Game(List.of(car1, car2, car3), MOVABLE_CHANCE);
        Winners winners = new Winners(game);
        winners.findWinners();
        assertThat(winners.getWinners().get(0).getName()).isEqualTo(car2.getName());
    }

    @Test
    @DisplayName("공동 우승자가 있는 경우 테스트")
    void 공동_우승자가_있을_수_있다() {
        Car car1 = new Car("땡칠", 2);
        Car car2 = new Car("물떡", 2);
        Car car3 = new Car("루쿠", 1);
        Game game = new Game(List.of(car1, car2, car3), MOVABLE_CHANCE);
        Winners winners = new Winners(game);
        winners.findWinners();
        assertThat(winners.getWinners().get(0).getName()).isEqualTo(car1.getName());
        assertThat(winners.getWinners().get(1).getName()).isEqualTo(car2.getName());
    }
}
