package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    public void Car_객체_생성자_예외_테스트() {
        String carName = "testException";
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[Error] 자동차 이름은 5자이하여야 합니다.");
    }

    @Test
    public void Car_move_작동_테스트_랜덤_숫자가_4이상일때() {
        Car car = new Car("test");
        int randomNumber = 4;

        car.move(randomNumber);
        assertThat(car.toString()).isEqualTo("test : -");
    }

    @Test
    public void Car_move_작동_테스트_랜덤_숫자가_4미만일때(){
        Car car = new Car("test");
        int randomNumber = 1;

        car.move(randomNumber);
        assertThat(car.toString()).isEqualTo("test : ");
    }
}