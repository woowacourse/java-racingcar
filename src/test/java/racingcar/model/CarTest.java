package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("숫자 4보다 작은 숫자가 나왔을 때 안 움직이는지 확인")
    void testDontMoveAboutSmallNumber() {
        Car car = new Car("test", new NumberGenerator() {
            @Override
            public int generateNumber(int bound) {
                return 3;
            }
        });

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 4보다 크거나 같은 숫자가 나왔을 때 안 움직이는지 확인")
    void testMoveAboutBigNumber() {
        Car car = new Car("test", new NumberGenerator() {
            @Override
            public int generateNumber(int bound) {
                return 4;
            }
        });

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}