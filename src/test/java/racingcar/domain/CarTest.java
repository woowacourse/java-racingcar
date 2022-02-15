package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.movestrategy.MovableMovingStrategy;
import racingcar.domain.movestrategy.StoppableMovingStrategy;

public class CarTest {

    @Test
    void Car_생성_성공() {
        Car car = new Car("12345", new MovableMovingStrategy());
        assertThat(car.getName()).isEqualTo("12345");
    }

    @Test
    void 자동차_전진_성공() {
        Car car = new Car("jae", new MovableMovingStrategy());
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    void 자동차_전진_실패() {
        Car car = new Car("jae", new StoppableMovingStrategy());
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);

    }
}
