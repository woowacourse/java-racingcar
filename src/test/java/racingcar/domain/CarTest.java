package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 테스트")
    public void carName() {
        Car car = new Car("bmw");
        assertThat(car.getName()).isEqualTo("bmw");
    }
}
