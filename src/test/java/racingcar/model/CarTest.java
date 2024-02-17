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

    @Test
    @DisplayName("두 포지션 값 중 큰 값을 리턴하는지 확인(본인의 값이 더 큰 경우)")
    void testOtherPositionIsSmaller() {
        Car car = new Car("test", new NumberGenerator() {
            @Override
            public int generateNumber(int bound) {
                return 4;
            }
        });

        car.move();
        car.move();

        assertThat(car.comparePosition(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("두 포지션 값 중 큰 값을 리턴하는지 확인(전달받은 값이 더 큰 경우)")
    void testOtherPositionIsBigger() {
        Car car = new Car("test", new NumberGenerator() {
            @Override
            public int generateNumber(int bound) {
                return 4;
            }
        });

        car.move();
        car.move();

        assertThat(car.comparePosition(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("전달받은 값과 포지션이 같은 경우 true를 반환하는지 확인")
    void testMatchesPosition() {
        Car car = new Car("test", new NumberGenerator() {
            @Override
            public int generateNumber(int bound) {
                return 4;
            }
        });

        car.move();
        car.move();

        assertThat(car.matchesPosition(2)).isTrue();
    }

    @Test
    @DisplayName("전달받은 값과 포지션이 다른 경우 false를 반환하는지 확인")
    void testDoesNotMatchPosition() {
        Car car = new Car("test", new NumberGenerator() {
            @Override
            public int generateNumber(int bound) {
                return 4;
            }
        });

        car.move();
        car.move();

        assertThat(car.matchesPosition(3)).isFalse();
    }
}