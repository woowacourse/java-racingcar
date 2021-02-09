package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("전진조건 테스트")
    @Test
    void moveForward() {
        // given(준비)
        Car car = new Car("mini");
        int previous = car.getPosition();
        // when(실행)
        car.move(5);
        // then(검증)
        assertThat(car.getPosition()).isEqualTo(previous + 1);
    }

}
