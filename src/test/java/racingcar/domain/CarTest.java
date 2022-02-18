package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("test");
        car.proceed();
    }

    @Test
    @DisplayName("자동차 전진")
    void proceed() {
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 위치 확인")
    void isHere() {
        assertThat(car.isHere(1)).isTrue();
    }

    @Test
    @DisplayName("DTO 생성")
    void toDto() {
        CarDto carDto = car.toDto();
        assertThat(carDto.getName()).isEqualTo(car.getName());
        assertThat(carDto.getPosition()).isEqualTo(car.getPosition());
    }
}