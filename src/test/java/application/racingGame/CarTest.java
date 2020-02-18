package application.racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi",0);
    }

    @Test
    void moveForward_randomNumber가_4이상이면_전진한다() {
        car.moveForward(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveForward_randomNumber가_4미만이면_정지한다() {
        car.moveForward(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
