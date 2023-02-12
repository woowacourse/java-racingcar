package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.strategy.ForwardMovingStrategy;

class CarTest {
    @DisplayName("자동차 위치 비교 테스트")
    @Test
    void matchCarPositionTest() {
        // given
        Car car = new Car("pobi", new ForwardMovingStrategy());
        int expectedPosition = 2;

        // when
        car.moveForward();
        boolean actual = car.matchPosition(expectedPosition);

        // then
        assertThat(actual).isTrue();
    }
}
