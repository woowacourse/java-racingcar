package carracinggame.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 위치 정상 확인")
    @Test
    void testCarPosition() {
        Car car = new Car("woowahan");
        for (int i = 9; i >= 0; i--) {
            car.move(i);
        }
        int position = car.getPosition();
        assertThat(position).isEqualTo(6);
    }
}
