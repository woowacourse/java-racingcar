package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void Car_객체_생성자_예외_테스트() {
        String carName = "testException";
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[Error] 자동차 이름은 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void Car_move_작동_테스트_랜덤_숫자가_4이상일때(int randomNumber) {
        Car car = new Car("test");
        car.move(randomNumber);
        assertThat(car.toString()).isEqualTo("test : -");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void Car_move_작동_테스트_랜덤_숫자가_4미만일때(int randomNumber) {
        Car car = new Car("test");
        car.move(randomNumber);
        assertThat(car.toString()).isEqualTo("test : ");
    }
}