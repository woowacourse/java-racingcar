package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 도메인 테스트")
class CarTest {
    
    @DisplayName("차는 움직임을 시도한 후 원래 자리에 멈춰있거나 한 칸 움직인다.")
    @Test
    void tryMoveThen() {
        Car car = Car.from("car");
        car.tryMove();
        assertThat(car.getPosition()).isIn(List.of(0, 1));
    }
}