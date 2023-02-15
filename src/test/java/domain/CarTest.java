package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @DisplayName("자동차 객체가 올바르게 생성되어야 한다.")
    @Test
    void 자동차_객체_생성() {
        Car dino = new Car("dino");
        assertThat(dino.getClass()).isEqualTo(Car.class);
    }

    @DisplayName("자동차 객체가 생성될 때 자동차 이름이 부여된다.")
    @Test
    void 자동차_객체생성시_이름_확인() {
        Car dino = new Car("dino");
        assertThat(dino.getName()).isEqualTo("dino");
    }

    @DisplayName("자동차 객체가 생성될 때 step은 0으로 초기화 된다.")
    @Test
    void 자동차_객체생성시_스텝_확인() {
        Car dino = new Car("dino");
        assertThat(dino.getStep()).isEqualTo(0);
    }
}
