package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 초기 포지션이 0인지 검증한다")
    void carInitPositionTest() {
        Car car1 = new Car("aa");
<<<<<<< HEAD
        int position = car1.getPosition().getPosition();
=======
        int position = car1.getPosition();
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071

        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("4 이상의 숫자를 받았을 때, 자동차 포지션이 1 증가하는지 검증한다")
    void carMoveFowardTest() {
        Car testCar = new Car("aa");
        testCar.move(5);
<<<<<<< HEAD
        int position = testCar.getPosition().getPosition();
=======
        int position = testCar.getPosition();
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071

        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("3 이하의 숫자를 받았을 때, 자동차 포지션이 변경되지 않는지 검증한다")
    void carMoveTest() {
        Car testCar = new Car("aa");
<<<<<<< HEAD
        testCar.move(2);
        int currentPosition = testCar.getPosition().getPosition();

        assertThat(currentPosition).isEqualTo(0);
    }
=======
        testCar.move(new TestNumberGenerator().generate());
        int currentPosition = testCar.getPosition();

        assertThat(currentPosition).isEqualTo(0);
    }

    private class TestNumberGenerator implements NumberGenerator {
        private int num = 2;

        @Override
        public int generate() {
            return num;
        }

    }

>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
}