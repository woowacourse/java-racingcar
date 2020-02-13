package racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int MOVING_UNIT = 1;

    @Test
    void move_랜덤_값이_3_이하() {
        Car car = new Car(new Name("test"));
        final int stoppedRandomNumber = 3;
        final int initPosition = car.getPosition();

        car.move(stoppedRandomNumber);
        final int actual = car.getPosition();

        final int expected = initPosition;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void move_랜덤_값이_4_이상() {
        Car car = new Car(new Name("test"));
        final int movedRandomNumber = 7;
        final int initPosition = car.getPosition();

        car.move(movedRandomNumber);
        final int actual = car.getPosition();

        final int expected = initPosition + MOVING_UNIT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void isWinnerPosition_우승한_위치의_자동차() {
        Car car = new Car(new Name("test"));
        final int winnerPosition = 2;

        car.move(7);
        car.move(9);

        assertThat(car.isSamePosition(winnerPosition)).isTrue();
    }

    @Test
    void isWinnerPosition_우승하지_못한_위치의_자동차() {
        Car car = new Car(new Name("test"));
        final int winnerPosition = 2;

        car.move(9);

        assertThat(car.isSamePosition(winnerPosition)).isFalse();
    }
}
