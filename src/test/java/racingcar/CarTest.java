package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차의 초기 포지션이 0인지 검증한다")
    void carInitPositionTest() {
        Car car1 = new Car("aa");
        int position = car1.getPosition();

        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("4 이상의 랜덤 숫자를 받았을 때, 자동차 포지션이 1 증가하는지 검증한다")
    void carMoveTest() {
        Car car1 = new Car("aa");
        car1.move(5);
        int position = car1.getPosition();

        assertThat(position).isEqualTo(1);
    }



}