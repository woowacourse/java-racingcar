package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("move() : 자동차의 이동 테스트")
    void test_move() {
        // given
        int givenDistance = 10;
        int expectedDistanceAfterMove = givenDistance + 1;
        Car car = new Car("pobi", givenDistance);

        // when
        car.move();

        // then
        assertThat(car.getDistance()).isEqualTo(expectedDistanceAfterMove);
    }
}
