package racingcar.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class MovePredicateTest {
    @Test
    @DisplayName("4 이상의 값일 때 자동차 이동")
    void test_5_car_move() {
        Car car = new Car("forky");
        MovePredicate movePredicate = new MovePredicate();
        car.move(movePredicate.test(5));
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
