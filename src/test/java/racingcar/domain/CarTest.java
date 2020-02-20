package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
    @Test
    void 위치를_알려주는_기능_테스트() {
        Car car = new Car("무늬");
        assertThat(car.getLocation()).isEqualTo(0);
    }
}
